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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ApplicationUser service. Represents a row in the &quot;OAuth_ApplicationUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.oauth.model.impl.ApplicationUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.oauth.model.impl.ApplicationUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationUser
 * @see com.liferay.portal.oauth.model.impl.ApplicationUserImpl
 * @see com.liferay.portal.oauth.model.impl.ApplicationUserModelImpl
 * @generated
 */
public interface ApplicationUserModel extends BaseModel<ApplicationUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a application user model instance should use the {@link ApplicationUser} interface instead.
	 */

	/**
	 * Returns the primary key of this application user.
	 *
	 * @return the primary key of this application user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this application user.
	 *
	 * @param primaryKey the primary key of this application user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the oaau ID of this application user.
	 *
	 * @return the oaau ID of this application user
	 */
	public long getOaauId();

	/**
	 * Sets the oaau ID of this application user.
	 *
	 * @param oaauId the oaau ID of this application user
	 */
	public void setOaauId(long oaauId);

	/**
	 * Returns the user ID of this application user.
	 *
	 * @return the user ID of this application user
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this application user.
	 *
	 * @param userId the user ID of this application user
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this application user.
	 *
	 * @return the user uuid of this application user
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this application user.
	 *
	 * @param userUuid the user uuid of this application user
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the application ID of this application user.
	 *
	 * @return the application ID of this application user
	 */
	public long getApplicationId();

	/**
	 * Sets the application ID of this application user.
	 *
	 * @param applicationId the application ID of this application user
	 */
	public void setApplicationId(long applicationId);

	/**
	 * Returns the access token of this application user.
	 *
	 * @return the access token of this application user
	 */
	@AutoEscape
	public String getAccessToken();

	/**
	 * Sets the access token of this application user.
	 *
	 * @param accessToken the access token of this application user
	 */
	public void setAccessToken(String accessToken);

	/**
	 * Returns the access secret of this application user.
	 *
	 * @return the access secret of this application user
	 */
	@AutoEscape
	public String getAccessSecret();

	/**
	 * Sets the access secret of this application user.
	 *
	 * @param accessSecret the access secret of this application user
	 */
	public void setAccessSecret(String accessSecret);

	/**
	 * Returns the authorized of this application user.
	 *
	 * @return the authorized of this application user
	 */
	public boolean getAuthorized();

	/**
	 * Returns <code>true</code> if this application user is authorized.
	 *
	 * @return <code>true</code> if this application user is authorized; <code>false</code> otherwise
	 */
	public boolean isAuthorized();

	/**
	 * Sets whether this application user is authorized.
	 *
	 * @param authorized the authorized of this application user
	 */
	public void setAuthorized(boolean authorized);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ApplicationUser applicationUser);

	public int hashCode();

	public CacheModel<ApplicationUser> toCacheModel();

	public ApplicationUser toEscapedModel();

	public String toString();

	public String toXmlString();
}