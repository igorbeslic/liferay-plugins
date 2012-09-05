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

import com.liferay.portal.RequiredFieldException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.oauth.model.OAuthApplication;
import com.liferay.portal.oauth.service.OAuthApplicationLocalServiceUtil;
import com.liferay.portal.oauth.util.OAuthConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.net.MalformedURLException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 *
 * @author Igor Beslic
 *
 */
public class OAuthApplicationAdminPortlet extends MVCPortlet
	implements OAuthConstants {

	public void addApplication(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		String name = ParamUtil.getString(actionRequest, NAME);
		String description = ParamUtil.getString(actionRequest, DESCRIPTION);
		String website = ParamUtil.getString(actionRequest, WEBSITE);
		String callBackURL = ParamUtil.getString(actionRequest, CALLBACK_URL);
		int accessLevel = ParamUtil.getInteger(
			actionRequest, ACCESS_TYPE, ACCESS_TYPE_READ);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				actionRequest);

			OAuthApplication application =
				OAuthApplicationLocalServiceUtil.addApplication(
					serviceContext.getUserId(), name, description, website,
					callBackURL, accessLevel, serviceContext);

			actionRequest.setAttribute(BEAN_ID, application);
		}
		catch (Exception e) {
			if (e instanceof SystemException) {
				_log.error(e, e);
			}
			else if (e instanceof RequiredFieldException ||
					 e instanceof MalformedURLException) {

				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw new PortletException(e.fillInStackTrace());
			}
		}
	}

	public void deleteApplication(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long applicationId = ParamUtil.getLong(actionRequest, APPLICATION_ID);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				actionRequest);

			if (applicationId > 0) {
				OAuthApplicationLocalServiceUtil.deleteApplication(
					applicationId, serviceContext);
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

	public void updateApplication(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long applicationId = ParamUtil.getLong(actionRequest, APPLICATION_ID);
		String name = ParamUtil.getString(actionRequest, NAME);
		String description = ParamUtil.getString(actionRequest, DESCRIPTION);
		String website = ParamUtil.getString(actionRequest, WEBSITE);
		String callBackURL = ParamUtil.getString(actionRequest, CALLBACK_URL);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				actionRequest);

			if (applicationId > 0) {
				OAuthApplication application =
					OAuthApplicationLocalServiceUtil.updateApplication(
						serviceContext.getUserId(), applicationId, name,
						description, website, callBackURL, serviceContext);

				actionRequest.setAttribute(BEAN_ID, application);
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
				throw new PortletException(e);
			}
		}
	}

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renberResponse)
		throws PortletException, IOException {

		long applicationId = ParamUtil.getLong(renderRequest, APPLICATION_ID);

		try {
			if (applicationId > 0) {
				OAuthApplication application =
					OAuthApplicationLocalServiceUtil.fetchOAuthApplication(
						applicationId);

				renderRequest.setAttribute(BEAN_ID, application);
			}
		}
		catch (Exception e) {
			if (e instanceof SystemException) {
				SessionErrors.add(renderRequest, e.getClass().getName(), e);
			}
			else {
				throw new PortletException(e.fillInStackTrace());
			}
		}

		super.render(renderRequest, renberResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(
		OAuthApplicationAdminPortlet.class);

}