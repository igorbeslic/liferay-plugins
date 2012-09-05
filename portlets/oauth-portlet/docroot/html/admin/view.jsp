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
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>

<portlet:actionURL var="searchActionURL">
	<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
</portlet:actionURL>

<aui:form action="<%= searchActionURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-util:include page="/html/admin/toolbar.jsp" servletContext="<%= application %>" />

	<liferay-ui:search-container
		delta="5"
		emptyResultsMessage="no-applications-were-found"
		searchContainer="<%= new OAuthApplicationSearch(renderRequest, currentURLObj) %>"
	>

		<liferay-ui:search-form
			page="/html/admin/search.jsp"
			servletContext="<%= application %>"
		/>

		<%
		List<OAuthApplication> applications = null;
		int applicationsCount = 0;

		if (permissionChecker.isCompanyAdmin()) {
			applications = OAuthApplicationLocalServiceUtil.getApplications(themeDisplay.getCompanyId(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			applicationsCount = OAuthApplicationLocalServiceUtil.getApplicationsCount(themeDisplay.getCompanyId());
		}
		else {
			applications = OAuthApplicationLocalServiceUtil.getApplicationsByUserId(themeDisplay.getUserId(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			applicationsCount = OAuthApplicationLocalServiceUtil.getApplicationsByUserIdCount(themeDisplay.getUserId());
		}
		%>

		<liferay-ui:search-container-results
			results="<%= applications %>"
			total="<%= applicationsCount %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.portal.oauth.model.OAuthApplication"
			keyProperty="applicationId"
			modelVar="oAuthApplication"
		>

			<liferay-ui:search-container-column-text
				orderable="<%= true %>"
				property="applicationId"
			/>

			<liferay-ui:search-container-column-text
				orderable="<%= true %>"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				property="website"
			/>

			<liferay-ui:search-container-column-text
				name="access-level"
				value='<%= LanguageUtil.get(pageContext, "access-level-option-" + oAuthApplication.getAccessLevel()) %>'
			/>

			<liferay-ui:search-container-column-text
				name="authorizations-count"
				value="<%= String.valueOf(OAuthApplicationUserLocalServiceUtil.getApplicationUsersCount(oAuthApplication.getApplicationId())) %>"
			/>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/html/admin/actions.jsp"
			/>

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>