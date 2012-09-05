<%--
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
--%>

<%@ include file="/html/init.jsp" %>

<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "my-authorizations");
%>

<div class="lfr-portlet-toolbar">
	<c:if test="<%= permissionChecker.isCompanyAdmin() %>">
		<portlet:renderURL var="viewAppsURL">
			<portlet:param name="mvcPath" value="/html/authorization/view.jsp" />
			<portlet:param name="referer" value="<%= currentURL %>" />
			<portlet:param name="toolbarItem" value="view-all" />
		</portlet:renderURL>

		<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : "" %>">
			<a href="<%= viewAppsURL %>"><liferay-ui:message key="view-all" /></a>
		</span>
	</c:if>

	<portlet:renderURL var="myApplicationsURL">
		<portlet:param name="mvcPath" value="/html/authorization/view.jsp" />
		<portlet:param name="referer" value="<%= currentURL %>" />
		<portlet:param name="toolbarItem" value="my-authorizations" />
	</portlet:renderURL>

	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("my-authorizations") ? "current" : "" %>">
		<a href="<%= myApplicationsURL %>"><liferay-ui:message key="my-authorizations" /></a>
	</span>
</div>