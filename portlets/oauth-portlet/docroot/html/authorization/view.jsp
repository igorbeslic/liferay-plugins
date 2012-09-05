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
long userId = themeDisplay.getUserId();

String toolbarItem = ParamUtil.getString(request, "toolbarItem", "my-authorizations");
%>

<portlet:actionURL var="searchActionURL" >
	<portlet:param name="mvcPath" value="/html/authorization/view.jsp" />
</portlet:actionURL>

<aui:form action="<%= searchActionURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-util:include page="/html/authorization/toolbar.jsp" servletContext="<%= application %>" />

	<liferay-ui:search-container
		delta="5"
		emptyResultsMessage="no-authorized-applications-were-found"
	>

		<%
		List<OAuthApplicationUser> applications = null;
		int applicationsCount = 0;

		if (toolbarItem.equals("my-authorizations")) {
			applications = OAuthApplicationUserLocalServiceUtil.getApplicationUsersByUserId(userId, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			applicationsCount = OAuthApplicationUserLocalServiceUtil.getApplicationUsersByUserIdCount(userId);
		}
		else {
			applications = OAuthApplicationUserLocalServiceUtil.getApplicationUsers(themeDisplay.getCompanyId(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			applicationsCount = OAuthApplicationUserLocalServiceUtil.getApplicationUsersCount(themeDisplay.getCompanyId());
		}
		%>

		<liferay-ui:search-container-results
			results="<%= applications %>"
			total="<%= applicationsCount %>"
		 />

		<liferay-ui:search-container-row
			className="com.liferay.portal.oauth.model.OAuthApplicationUser"
			keyProperty="oaauId"
			modelVar="applicationUser">

			<%
			OAuthApplication oAuthApplication = OAuthApplicationLocalServiceUtil.fetchOAuthApplication(applicationUser.getApplicationId());
			%>

			<liferay-ui:search-container-column-text
				orderable="<%= true %>"
				property="oaauId"
			/>

			<liferay-ui:search-container-column-text
				name="name"
				value="<%= oAuthApplication.getName() %>"
			/>

			<liferay-ui:search-container-column-text
				property="accessToken"
			/>

			<liferay-ui:search-container-column-text
				name="access-level"
				value='<%= LanguageUtil.get(pageContext, "access-level-option-" + oAuthApplication.getAccessLevel()) %>'
			/>

			<liferay-ui:search-container-column-text
				property="authorized"
			/>

			<c:if test="<%= permissionChecker.hasPermission(0, OAuthApplicationUser.class.getName(), applicationUser.getApplicationId(), ActionKeys.DELETE) %>">
				<liferay-portlet:actionURL name="deleteApplicationUser" var="revokeURL">
					<portlet:param name="<%= OAuthConstants.APPLICATION_ID %>" value="<%= String.valueOf(applicationUser.getApplicationId()) %>" />
				</liferay-portlet:actionURL>

				<liferay-ui:search-container-column-text
					href="<%= revokeURL %>"
				>
					<liferay-ui:message key="revoke" />
				</liferay-ui:search-container-column-text>
			</c:if>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>