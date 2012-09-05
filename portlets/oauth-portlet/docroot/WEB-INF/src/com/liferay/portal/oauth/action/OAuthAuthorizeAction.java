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

package com.liferay.portal.oauth.action;

import com.liferay.portal.kernel.portlet.WindowStateFactory;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.oauth.util.OAuthConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Authorization request handler action.
 *
 * @author Ivica Cardic
 */
public class OAuthAuthorizeAction extends BaseStrutsAction {

	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String oauthToken = ParamUtil.getString(
			request, OAuthConstants.OAUTH_TOKEN);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			request, OAuthConstants.OAUTH_AUTHORIZE, themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(getWindowState(request));
		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setParameter(OAuthConstants.OAUTH_TOKEN, oauthToken);
		portletURL.setParameter("saveLastPath", "0");

		String redirect = portletURL.toString();

		response.sendRedirect(redirect);

		return null;
	}

	protected WindowState getWindowState(HttpServletRequest request) {
		WindowState windowState = WindowState.MAXIMIZED;

		String windowStateString = ParamUtil.getString(request, "windowState");

		if (Validator.isNotNull(windowStateString)) {
			windowState = WindowStateFactory.getWindowState(windowStateString);
		}

		return windowState;
	}

}