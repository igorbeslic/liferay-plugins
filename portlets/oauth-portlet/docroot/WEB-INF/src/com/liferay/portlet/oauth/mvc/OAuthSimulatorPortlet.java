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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.oauth.model.OAuthApplication;
import com.liferay.portal.oauth.service.OAuthApplicationLocalServiceUtil;
import com.liferay.portal.oauth.util.OAuthConstants;
import com.liferay.portlet.oauth.simulator.LiferayApi;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class OAuthSimulatorPortlet extends MVCPortlet
	implements OAuthConstants {

	public void addOAuthorization(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long applicationId = ParamUtil.getLong(actionRequest, APPLICATION_ID);

		try {
			if (applicationId > 0) {
				OAuthApplication application =
					OAuthApplicationLocalServiceUtil.fetchOAuthApplication(
						applicationId);

				ServiceBuilder serviceBuilder = new ServiceBuilder();

				serviceBuilder.provider(LiferayApi.class);
				serviceBuilder.apiKey(application.getConsumerKey());
				serviceBuilder.apiSecret(application.getConsumerSecret());

				OAuthService oAuthService = serviceBuilder.build();

				Token requestToken = oAuthService.getRequestToken();

				actionRequest.setAttribute(
					"oauth-simulator-url",
					LiferayApi.AUTHORIZE_URL.replace(
						"%s", requestToken.getToken()));
				actionRequest.setAttribute(
					"oauth-simulator-token", requestToken.getToken());
				actionRequest.setAttribute(
					"oauth-simulator-secret", requestToken.getSecret());
				actionRequest.setAttribute(
					"applicationId", Long.toString(applicationId));
			}
			else {
				SessionErrors.add(
					actionRequest,
					"can-not-complete-operation-without-application-id");
			}
		}
		catch (Exception e) {
			if (e instanceof SystemException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw new PortletException(e.fillInStackTrace());
			}
		}
	}

	public void verifyOAuthorization(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long applicationId = ParamUtil.getLong(
			actionRequest, OAuthConstants.APPLICATION_ID);

		try {
			if (applicationId > 0) {
				OAuthApplication application =
					OAuthApplicationLocalServiceUtil.fetchOAuthApplication(
						applicationId);

				ServiceBuilder serviceBuilder = new ServiceBuilder();

				serviceBuilder.provider(LiferayApi.class);
				serviceBuilder.apiKey(application.getConsumerKey());
				serviceBuilder.apiSecret(application.getConsumerSecret());

				OAuthService oAuthService = serviceBuilder.build();

				String tokenString = ParamUtil.getString(
					actionRequest, "oauth-simulator-token");
				String secretString = ParamUtil.getString(
					actionRequest, "oauth-simulator-secret");
				String verifierString = ParamUtil.getString(
					actionRequest, "oauth-simulator-verifier");

				Verifier verifier = new Verifier(verifierString);

				Token requestToken = new Token(tokenString, secretString);

				Token accessToken = oAuthService.getAccessToken(
					requestToken, verifier);

				assert accessToken != null;
			}
			else {
				SessionErrors.add(
					actionRequest,
					"can-not-complete-operation-without-application-id");
			}
		}
		catch (Exception e) {
			if (e instanceof SystemException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw new PortletException(e.fillInStackTrace());
			}
		}
	}

}