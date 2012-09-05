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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OAuthApplicationUser}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       OAuthApplicationUser
 * @generated
 */
public class OAuthApplicationUserWrapper implements OAuthApplicationUser,
	ModelWrapper<OAuthApplicationUser> {
	public OAuthApplicationUserWrapper(
		OAuthApplicationUser oAuthApplicationUser) {
		_oAuthApplicationUser = oAuthApplicationUser;
	}

	public Class<?> getModelClass() {
		return OAuthApplicationUser.class;
	}

	public String getModelClassName() {
		return OAuthApplicationUser.class.getName();
	}

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

	/**
	* Returns the primary key of this o auth application user.
	*
	* @return the primary key of this o auth application user
	*/
	public long getPrimaryKey() {
		return _oAuthApplicationUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this o auth application user.
	*
	* @param primaryKey the primary key of this o auth application user
	*/
	public void setPrimaryKey(long primaryKey) {
		_oAuthApplicationUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the oaau ID of this o auth application user.
	*
	* @return the oaau ID of this o auth application user
	*/
	public long getOaauId() {
		return _oAuthApplicationUser.getOaauId();
	}

	/**
	* Sets the oaau ID of this o auth application user.
	*
	* @param oaauId the oaau ID of this o auth application user
	*/
	public void setOaauId(long oaauId) {
		_oAuthApplicationUser.setOaauId(oaauId);
	}

	/**
	* Returns the company ID of this o auth application user.
	*
	* @return the company ID of this o auth application user
	*/
	public long getCompanyId() {
		return _oAuthApplicationUser.getCompanyId();
	}

	/**
	* Sets the company ID of this o auth application user.
	*
	* @param companyId the company ID of this o auth application user
	*/
	public void setCompanyId(long companyId) {
		_oAuthApplicationUser.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this o auth application user.
	*
	* @return the user ID of this o auth application user
	*/
	public long getUserId() {
		return _oAuthApplicationUser.getUserId();
	}

	/**
	* Sets the user ID of this o auth application user.
	*
	* @param userId the user ID of this o auth application user
	*/
	public void setUserId(long userId) {
		_oAuthApplicationUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this o auth application user.
	*
	* @return the user uuid of this o auth application user
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this o auth application user.
	*
	* @param userUuid the user uuid of this o auth application user
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_oAuthApplicationUser.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this o auth application user.
	*
	* @return the user name of this o auth application user
	*/
	public java.lang.String getUserName() {
		return _oAuthApplicationUser.getUserName();
	}

	/**
	* Sets the user name of this o auth application user.
	*
	* @param userName the user name of this o auth application user
	*/
	public void setUserName(java.lang.String userName) {
		_oAuthApplicationUser.setUserName(userName);
	}

	/**
	* Returns the create date of this o auth application user.
	*
	* @return the create date of this o auth application user
	*/
	public java.util.Date getCreateDate() {
		return _oAuthApplicationUser.getCreateDate();
	}

	/**
	* Sets the create date of this o auth application user.
	*
	* @param createDate the create date of this o auth application user
	*/
	public void setCreateDate(java.util.Date createDate) {
		_oAuthApplicationUser.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this o auth application user.
	*
	* @return the modified date of this o auth application user
	*/
	public java.util.Date getModifiedDate() {
		return _oAuthApplicationUser.getModifiedDate();
	}

	/**
	* Sets the modified date of this o auth application user.
	*
	* @param modifiedDate the modified date of this o auth application user
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_oAuthApplicationUser.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the application ID of this o auth application user.
	*
	* @return the application ID of this o auth application user
	*/
	public long getApplicationId() {
		return _oAuthApplicationUser.getApplicationId();
	}

	/**
	* Sets the application ID of this o auth application user.
	*
	* @param applicationId the application ID of this o auth application user
	*/
	public void setApplicationId(long applicationId) {
		_oAuthApplicationUser.setApplicationId(applicationId);
	}

	/**
	* Returns the access token of this o auth application user.
	*
	* @return the access token of this o auth application user
	*/
	public java.lang.String getAccessToken() {
		return _oAuthApplicationUser.getAccessToken();
	}

	/**
	* Sets the access token of this o auth application user.
	*
	* @param accessToken the access token of this o auth application user
	*/
	public void setAccessToken(java.lang.String accessToken) {
		_oAuthApplicationUser.setAccessToken(accessToken);
	}

	/**
	* Returns the access secret of this o auth application user.
	*
	* @return the access secret of this o auth application user
	*/
	public java.lang.String getAccessSecret() {
		return _oAuthApplicationUser.getAccessSecret();
	}

	/**
	* Sets the access secret of this o auth application user.
	*
	* @param accessSecret the access secret of this o auth application user
	*/
	public void setAccessSecret(java.lang.String accessSecret) {
		_oAuthApplicationUser.setAccessSecret(accessSecret);
	}

	/**
	* Returns the authorized of this o auth application user.
	*
	* @return the authorized of this o auth application user
	*/
	public boolean getAuthorized() {
		return _oAuthApplicationUser.getAuthorized();
	}

	/**
	* Returns <code>true</code> if this o auth application user is authorized.
	*
	* @return <code>true</code> if this o auth application user is authorized; <code>false</code> otherwise
	*/
	public boolean isAuthorized() {
		return _oAuthApplicationUser.isAuthorized();
	}

	/**
	* Sets whether this o auth application user is authorized.
	*
	* @param authorized the authorized of this o auth application user
	*/
	public void setAuthorized(boolean authorized) {
		_oAuthApplicationUser.setAuthorized(authorized);
	}

	public boolean isNew() {
		return _oAuthApplicationUser.isNew();
	}

	public void setNew(boolean n) {
		_oAuthApplicationUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _oAuthApplicationUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_oAuthApplicationUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _oAuthApplicationUser.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _oAuthApplicationUser.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_oAuthApplicationUser.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _oAuthApplicationUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_oAuthApplicationUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OAuthApplicationUserWrapper((OAuthApplicationUser)_oAuthApplicationUser.clone());
	}

	public int compareTo(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser) {
		return _oAuthApplicationUser.compareTo(oAuthApplicationUser);
	}

	@Override
	public int hashCode() {
		return _oAuthApplicationUser.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portal.oauth.model.OAuthApplicationUser> toCacheModel() {
		return _oAuthApplicationUser.toCacheModel();
	}

	public com.liferay.portal.oauth.model.OAuthApplicationUser toEscapedModel() {
		return new OAuthApplicationUserWrapper(_oAuthApplicationUser.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _oAuthApplicationUser.toString();
	}

	public java.lang.String toXmlString() {
		return _oAuthApplicationUser.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_oAuthApplicationUser.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public OAuthApplicationUser getWrappedOAuthApplicationUser() {
		return _oAuthApplicationUser;
	}

	public OAuthApplicationUser getWrappedModel() {
		return _oAuthApplicationUser;
	}

	public void resetOriginalValues() {
		_oAuthApplicationUser.resetOriginalValues();
	}

	private OAuthApplicationUser _oAuthApplicationUser;
}