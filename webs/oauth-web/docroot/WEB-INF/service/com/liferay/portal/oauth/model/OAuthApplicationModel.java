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
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the OAuthApplication service. Represents a row in the &quot;OAuthApplication&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.oauth.model.impl.OAuthApplicationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.oauth.model.impl.OAuthApplicationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplication
 * @see com.liferay.portal.oauth.model.impl.OAuthApplicationImpl
 * @see com.liferay.portal.oauth.model.impl.OAuthApplicationModelImpl
 * @generated
 */
public interface OAuthApplicationModel extends AuditedModel,
	BaseModel<OAuthApplication> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a o auth application model instance should use the {@link OAuthApplication} interface instead.
	 */

	/**
	 * Returns the primary key of this o auth application.
	 *
	 * @return the primary key of this o auth application
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this o auth application.
	 *
	 * @param primaryKey the primary key of this o auth application
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this o auth application.
	 *
	 * @return the ID of this o auth application
	 */
	public long getId();

	/**
	 * Sets the ID of this o auth application.
	 *
	 * @param id the ID of this o auth application
	 */
	public void setId(long id);

	/**
	 * Returns the company ID of this o auth application.
	 *
	 * @return the company ID of this o auth application
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this o auth application.
	 *
	 * @param companyId the company ID of this o auth application
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this o auth application.
	 *
	 * @return the user ID of this o auth application
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this o auth application.
	 *
	 * @param userId the user ID of this o auth application
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this o auth application.
	 *
	 * @return the user uuid of this o auth application
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this o auth application.
	 *
	 * @param userUuid the user uuid of this o auth application
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this o auth application.
	 *
	 * @return the user name of this o auth application
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this o auth application.
	 *
	 * @param userName the user name of this o auth application
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this o auth application.
	 *
	 * @return the create date of this o auth application
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this o auth application.
	 *
	 * @param createDate the create date of this o auth application
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this o auth application.
	 *
	 * @return the modified date of this o auth application
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this o auth application.
	 *
	 * @param modifiedDate the modified date of this o auth application
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the owner ID of this o auth application.
	 *
	 * @return the owner ID of this o auth application
	 */
	public long getOwnerId();

	/**
	 * Sets the owner ID of this o auth application.
	 *
	 * @param ownerId the owner ID of this o auth application
	 */
	public void setOwnerId(long ownerId);

	/**
	 * Returns the name of this o auth application.
	 *
	 * @return the name of this o auth application
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this o auth application.
	 *
	 * @param name the name of this o auth application
	 */
	public void setName(String name);

	/**
	 * Returns the description of this o auth application.
	 *
	 * @return the description of this o auth application
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this o auth application.
	 *
	 * @param description the description of this o auth application
	 */
	public void setDescription(String description);

	/**
	 * Returns the website of this o auth application.
	 *
	 * @return the website of this o auth application
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this o auth application.
	 *
	 * @param website the website of this o auth application
	 */
	public void setWebsite(String website);

	/**
	 * Returns the secret of this o auth application.
	 *
	 * @return the secret of this o auth application
	 */
	@AutoEscape
	public String getSecret();

	/**
	 * Sets the secret of this o auth application.
	 *
	 * @param secret the secret of this o auth application
	 */
	public void setSecret(String secret);

	/**
	 * Returns the call back u r l of this o auth application.
	 *
	 * @return the call back u r l of this o auth application
	 */
	@AutoEscape
	public String getCallBackURL();

	/**
	 * Sets the call back u r l of this o auth application.
	 *
	 * @param callBackURL the call back u r l of this o auth application
	 */
	public void setCallBackURL(String callBackURL);

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

	public int compareTo(OAuthApplication oAuthApplication);

	public int hashCode();

	public CacheModel<OAuthApplication> toCacheModel();

	public OAuthApplication toEscapedModel();

	public String toString();

	public String toXmlString();
}