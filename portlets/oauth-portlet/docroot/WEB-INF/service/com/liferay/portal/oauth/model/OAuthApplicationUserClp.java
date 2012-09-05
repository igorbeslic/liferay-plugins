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

package com.liferay.portal.oauth.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.oauth.service.OAuthApplicationUserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class OAuthApplicationUserClp extends BaseModelImpl<OAuthApplicationUser>
	implements OAuthApplicationUser {
	public OAuthApplicationUserClp() {
	}

	public Class<?> getModelClass() {
		return OAuthApplicationUser.class;
	}

	public String getModelClassName() {
		return OAuthApplicationUser.class.getName();
	}

	public long getPrimaryKey() {
		return _oaauId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOaauId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_oaauId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaauId", getOaauId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicationId", getApplicationId());
		attributes.put("accessToken", getAccessToken());
		attributes.put("accessSecret", getAccessSecret());
		attributes.put("authorized", getAuthorized());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaauId = (Long)attributes.get("oaauId");

		if (oaauId != null) {
			setOaauId(oaauId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long applicationId = (Long)attributes.get("applicationId");

		if (applicationId != null) {
			setApplicationId(applicationId);
		}

		String accessToken = (String)attributes.get("accessToken");

		if (accessToken != null) {
			setAccessToken(accessToken);
		}

		String accessSecret = (String)attributes.get("accessSecret");

		if (accessSecret != null) {
			setAccessSecret(accessSecret);
		}

		Boolean authorized = (Boolean)attributes.get("authorized");

		if (authorized != null) {
			setAuthorized(authorized);
		}
	}

	public long getOaauId() {
		return _oaauId;
	}

	public void setOaauId(long oaauId) {
		_oaauId = oaauId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getApplicationId() {
		return _applicationId;
	}

	public void setApplicationId(long applicationId) {
		_applicationId = applicationId;
	}

	public String getAccessToken() {
		return _accessToken;
	}

	public void setAccessToken(String accessToken) {
		_accessToken = accessToken;
	}

	public String getAccessSecret() {
		return _accessSecret;
	}

	public void setAccessSecret(String accessSecret) {
		_accessSecret = accessSecret;
	}

	public boolean getAuthorized() {
		return _authorized;
	}

	public boolean isAuthorized() {
		return _authorized;
	}

	public void setAuthorized(boolean authorized) {
		_authorized = authorized;
	}

	public BaseModel<?> getOAuthApplicationUserRemoteModel() {
		return _oAuthApplicationUserRemoteModel;
	}

	public void setOAuthApplicationUserRemoteModel(
		BaseModel<?> oAuthApplicationUserRemoteModel) {
		_oAuthApplicationUserRemoteModel = oAuthApplicationUserRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			OAuthApplicationUserLocalServiceUtil.addOAuthApplicationUser(this);
		}
		else {
			OAuthApplicationUserLocalServiceUtil.updateOAuthApplicationUser(this);
		}
	}

	@Override
	public OAuthApplicationUser toEscapedModel() {
		return (OAuthApplicationUser)Proxy.newProxyInstance(OAuthApplicationUser.class.getClassLoader(),
			new Class[] { OAuthApplicationUser.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OAuthApplicationUserClp clone = new OAuthApplicationUserClp();

		clone.setOaauId(getOaauId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setApplicationId(getApplicationId());
		clone.setAccessToken(getAccessToken());
		clone.setAccessSecret(getAccessSecret());
		clone.setAuthorized(getAuthorized());

		return clone;
	}

	public int compareTo(OAuthApplicationUser oAuthApplicationUser) {
		long primaryKey = oAuthApplicationUser.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OAuthApplicationUserClp oAuthApplicationUser = null;

		try {
			oAuthApplicationUser = (OAuthApplicationUserClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = oAuthApplicationUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{oaauId=");
		sb.append(getOaauId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", applicationId=");
		sb.append(getApplicationId());
		sb.append(", accessToken=");
		sb.append(getAccessToken());
		sb.append(", accessSecret=");
		sb.append(getAccessSecret());
		sb.append(", authorized=");
		sb.append(getAuthorized());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.oauth.model.OAuthApplicationUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>oaauId</column-name><column-value><![CDATA[");
		sb.append(getOaauId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationId</column-name><column-value><![CDATA[");
		sb.append(getApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessToken</column-name><column-value><![CDATA[");
		sb.append(getAccessToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessSecret</column-name><column-value><![CDATA[");
		sb.append(getAccessSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorized</column-name><column-value><![CDATA[");
		sb.append(getAuthorized());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _oaauId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _applicationId;
	private String _accessToken;
	private String _accessSecret;
	private boolean _authorized;
	private BaseModel<?> _oAuthApplicationUserRemoteModel;
}