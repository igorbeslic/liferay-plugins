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

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@ include file="/html/init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "jspPage");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

OAuthApplication oAuthApplication = (OAuthApplication)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/html/admin/edit.jsp" />
		<portlet:param name="referer" value="<%= currentURL %>" />
		<portlet:param name="applicationId" value="<%= String.valueOf(oAuthApplication.getApplicationId()) %>" />
	</liferay-portlet:renderURL>

	<liferay-ui:icon
		image="view"
		method="get"
		url="<%= viewURL %>"
	/>

	<c:if test='<%= permissionChecker.hasPermission(0, OAuthApplication.class.getName(), oAuthApplication.getApplicationId(), ActionKeys.UPDATE) %>'>
		<liferay-portlet:renderURL var="editURL">
			<portlet:param name="mvcPath" value="/html/admin/edit.jsp" />
			<portlet:param name="referer" value="<%= currentURL %>" />
			<portlet:param name="applicationId" value="<%= String.valueOf(oAuthApplication.getApplicationId()) %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			method="get"
			url="<%= editURL %>"
		/>
	</c:if>

	<c:if test='<%= permissionChecker.hasPermission(0, OAuthApplication.class.getName(), oAuthApplication.getApplicationId(), ActionKeys.DELETE) %>'>
		<liferay-portlet:actionURL name="deleteApplication" var="deleteURL">
			<portlet:param name="referer" value="<%= currentURL %>" />
			<portlet:param name="applicationId" value="<%= String.valueOf(oAuthApplication.getApplicationId()) %>" />
		</liferay-portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>