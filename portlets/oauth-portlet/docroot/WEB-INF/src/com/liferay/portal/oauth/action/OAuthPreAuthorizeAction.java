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

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.StringBundler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivica Cardic
 *
 */
public class OAuthPreAuthorizeAction extends BaseStrutsAction {

	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String uri = request.getRequestURI();
		String queryString = request.getQueryString();

		StringBundler sb =new StringBundler(7);

		sb.append(uri);
		sb.append("/private?");
		sb.append(queryString);
		sb.append("&redirect=");
		sb.append(uri);
		sb.append("?");
		sb.append(queryString);

		response.sendRedirect(sb.toString());

		return null;
	}

}