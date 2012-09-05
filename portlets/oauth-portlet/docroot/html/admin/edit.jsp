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
Application app = (Application)request.getAttribute(OAuthConstants.BEAN_ID);

String actionName = "addApplication";
if ((null != app) && (0L != app.getApplicationId())) {
	actionName = "updateApplication";
}

String backURL = ParamUtil.getString(request, "referer");
%>

<liferay-ui:error-marker key="errorSection" value="details" />

<aui:model-context bean="<%= app %>" model="<%= Application.class %>" />

<liferay-ui:error exception="<%=RequiredFieldException.class %>" message="this-field-is-required" />
<liferay-ui:error exception="<%=MalformedURLException.class %>" message="please-enter-a-valid-url" />

<liferay-portlet:actionURL name="<%= actionName %>" var="addApplicationURL">
	<portlet:param name="jspPage" value="/html/admin/edit.jsp" />
	<portlet:param name="referer" value="<%= backURL %>" />
</liferay-portlet:actionURL>

<aui:a href="<%= backURL %>">back</aui:a>
<aui:form action="<%= addApplicationURL %>" method="post">
	<aui:input id="applicationId" name="applicationId" type="hidden" />
	<aui:fieldset>
		<aui:input label="name" name="<%=OAuthConstants.NAME%>" showRequiredLabel="true" />
		<aui:input label="description" name="<%=OAuthConstants.DESCRIPTION%>" type="textarea" />
		<aui:input label="website" name="<%=OAuthConstants.WEBSITE%>" showRequiredLabel="true"  />
		<aui:input label="callback-url" name="<%=OAuthConstants.CALLBACK_URL%>" showRequiredLabel="true" />
	
		<aui:select helpMessage="access-level-description" label="access-level" name="<%= OAuthConstants.WEB_APP_ACCESS_TYPE %>">
			<aui:option label="<%= OAuthConstants.WEB_APP_LANG_KEY_ACCESS_TYPE_OPTION.concat(Integer.toString(OAuthConstants.ACCESS_TYPE_READ)) %>" value="<%= OAuthConstants.ACCESS_TYPE_READ %>"></aui:option>
			<aui:option label="<%= OAuthConstants.WEB_APP_LANG_KEY_ACCESS_TYPE_OPTION.concat(Integer.toString(OAuthConstants.ACCESS_TYPE_WRITE)) %>" value="<%= OAuthConstants.ACCESS_TYPE_WRITE %>"></aui:option>
		</aui:select>
	
		<c:if test="<%= (null != app) && (null != app.getConsumerKey()) %>">
			<aui:field-wrapper helpMessage="application-credentials-description" label="application-credentials">
				<liferay-ui:message key="application-key" />: <%= app.getConsumerKey() %> <br />
				<liferay-ui:message key="application-secret" />: <%= app.getConsumerSecret() %>
			</aui:field-wrapper>
		</c:if>
	
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button href="<%= backURL %>" value="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>