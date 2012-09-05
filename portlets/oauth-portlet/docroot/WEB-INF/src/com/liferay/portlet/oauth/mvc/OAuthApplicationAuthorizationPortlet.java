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
import com.liferay.portal.oauth.service.OAuthApplicationUserLocalServiceUtil;
import com.liferay.portal.oauth.util.OAuthConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

/**
 *
 * @author Igor Beslic
 *
 */
public class OAuthApplicationAuthorizationPortlet extends MVCPortlet {

	public void deleteApplicationUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		long applicationId = ParamUtil.getLong(
			actionRequest, OAuthConstants.APPLICATION_ID);

		try {
			if (applicationId > 0) {
				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(actionRequest);

				OAuthApplicationUserLocalServiceUtil.deleteApplicationUser(
					applicationId, serviceContext.getUserId(), serviceContext);
			}
			else {
				SessionErrors.add(
					actionRequest, "cant-complete-operation-without-id");
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