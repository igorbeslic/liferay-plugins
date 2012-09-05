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
OAuthApplication oAuthApplication = (OAuthApplication)request.getAttribute(OAuthConstants.BEAN_ID);

String actionName = "addApplication";

if ((oAuthApplication != null) && (oAuthApplication.getApplicationId() != 0)) {
	actionName = "editApplication";
}

String backURL = ParamUtil.getString(request, "referer");
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= actionName.equals("addApplication") ? "new-application" : oAuthApplication.getName() %>'
/>

<aui:model-context bean="<%= oAuthApplication %>" model="<%= OAuthApplication.class %>" />

<liferay-ui:error-marker key="errorSection" value="details" />

<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="this-field-is-required" />
<liferay-ui:error exception="<%= MalformedURLException.class %>" message="please-enter-a-valid-url" />

<liferay-portlet:actionURL name="<%= actionName %>" var="addApplicationURL">
	<portlet:param name="mvcPath" value="/html/admin/edit.jsp" />
	<portlet:param name="referer" value="<%= backURL %>" />
</liferay-portlet:actionURL>

<aui:form action="<%= addApplicationURL %>" method="post">
	<aui:input id="applicationId" name="applicationId" type="hidden" />

	<aui:fieldset>
		<aui:input label="name" name="<%= OAuthConstants.NAME%>" showRequiredLabel="true" />
		<aui:input label="description" name="<%= OAuthConstants.DESCRIPTION%>" type="textarea" />
		<aui:input label="website" name="<%= OAuthConstants.WEBSITE %>" showRequiredLabel="true"  />
		<aui:input label="callback-url" name="<%= OAuthConstants.CALLBACK_URL%>" showRequiredLabel="true" />

		<aui:select helpMessage="access-level-description" label="access-level" name="<%= OAuthConstants.ACCESS_TYPE %>">
			<aui:option label='access-level-option-0' value="<%= OAuthConstants.ACCESS_TYPE_READ %>"></aui:option>
			<aui:option label='access-level-option-1' value="<%= OAuthConstants.ACCESS_TYPE_WRITE %>"></aui:option>
		</aui:select>

		<c:if test="<%= (oAuthApplication != null) && (Validator.isNotNull(oAuthApplication.getConsumerKey())) %>">
			<aui:field-wrapper helpMessage="application-credentials-description" label="application-credentials">
				<liferay-ui:message key="application-key" />: <%= oAuthApplication.getConsumerKey() %> <br />
				<liferay-ui:message key="application-secret" />: <%= oAuthApplication.getConsumerSecret() %>
			</aui:field-wrapper>
		</c:if>

		<aui:button-row>
			<aui:button type="submit" />
			<aui:button href="<%= backURL %>" value="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>