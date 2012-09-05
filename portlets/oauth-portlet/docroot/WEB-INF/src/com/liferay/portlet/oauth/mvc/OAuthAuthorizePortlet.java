/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.oauth.mvc;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.oauth.OAuthAccessor;
import com.liferay.portal.oauth.OAuthConsumer;
import com.liferay.portal.oauth.OAuthMessage;
import com.liferay.portal.oauth.OAuthProblemException;
import com.liferay.portal.oauth.OAuthUtil;
import com.liferay.portal.oauth.util.OAuthConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
public class OAuthAuthorizePortlet extends MVCPortlet
	implements OAuthConstants {

	public void authorize(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		OAuthMessage requestMessage = OAuthUtil.getMessage(
			actionRequest, null);

		try {
			OAuthAccessor accessor = OAuthUtil.getAccessor(
				requestMessage);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				actionRequest);

			OAuthUtil.authorize(
				accessor, serviceContext.getUserId(), serviceContext);

			returnToConsumer(actionRequest, actionResponse, accessor);
		}
		catch (Exception e) {
			if (e instanceof OAuthProblemException) {
				OAuthProblemException authProblemException =
					(OAuthProblemException)e;

				SessionErrors.add(
					actionRequest, authProblemException.getProblem());
			}
			else {
				SessionErrors.add(actionRequest, e.getClass());
			}
		}
	}

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {

		OAuthMessage requestMessage = OAuthUtil.getMessage(
			renderRequest, null);

		try {
			OAuthAccessor accessor = OAuthUtil.getAccessor(
				requestMessage);

			renderRequest.setAttribute(OAUTH_ACCESSOR, accessor);

			if (Boolean.TRUE.equals(accessor.getProperty(AUTHORIZED))) {
				SessionErrors.add(renderRequest, ALREADY_AUTHORIZED_KEY);
			}
		}
		catch (Exception e) {
			if (e instanceof OAuthProblemException) {
				OAuthProblemException authProblemException =
					(OAuthProblemException)e;

				SessionErrors.add(
					renderRequest, OAuthProblemException.class,
					authProblemException.getProblem());
			}
			else {
				SessionErrors.add(renderRequest, e.getClass());
			}
		}

		super.render(renderRequest, renderResponse);
	}

	private void returnToConsumer(
			ActionRequest actionRequest, ActionResponse actionResponse,
			OAuthAccessor accessor)
		throws Exception {

		// send the user back to site's callBackUrl

		String callback = ParamUtil.getString(actionRequest, OAUTH_CALLBACK);

		OAuthConsumer consumer = accessor.getConsumer();

		String callbackURL = consumer.getCallbackURL();

		if (NONE.equals(callback) && Validator.isNotNull(callbackURL)) {
			callback = callbackURL;
		}

		String token = accessor.getRequestToken();

		String verifier = OAuthUtil.randomizeToken(callback.concat(token));

		if (NONE.equals(callback)) {
			actionRequest.setAttribute(OAUTH_ACCESSOR, accessor);
			actionRequest.setAttribute(VERIFIER, verifier);
		}
		else {
			if (token != null) {
				callback = OAuthUtil.addParameters(
					callback, OAUTH_TOKEN, token,
					OAUTH_VERIFIER, verifier);
			}

			actionResponse.sendRedirect(callback);
		}
	}

}