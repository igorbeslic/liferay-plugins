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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class OAuthApplicationSoap implements Serializable {
	public static OAuthApplicationSoap toSoapModel(OAuthApplication model) {
		OAuthApplicationSoap soapModel = new OAuthApplicationSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setSecret(model.getSecret());
		soapModel.setCallBackURL(model.getCallBackURL());

		return soapModel;
	}

	public static OAuthApplicationSoap[] toSoapModels(OAuthApplication[] models) {
		OAuthApplicationSoap[] soapModels = new OAuthApplicationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OAuthApplicationSoap[][] toSoapModels(
		OAuthApplication[][] models) {
		OAuthApplicationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OAuthApplicationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OAuthApplicationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OAuthApplicationSoap[] toSoapModels(
		List<OAuthApplication> models) {
		List<OAuthApplicationSoap> soapModels = new ArrayList<OAuthApplicationSoap>(models.size());

		for (OAuthApplication model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OAuthApplicationSoap[soapModels.size()]);
	}

	public OAuthApplicationSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getSecret() {
		return _secret;
	}

	public void setSecret(String secret) {
		_secret = secret;
	}

	public String getCallBackURL() {
		return _callBackURL;
	}

	public void setCallBackURL(String callBackURL) {
		_callBackURL = callBackURL;
	}

	private long _id;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ownerId;
	private String _name;
	private String _description;
	private String _website;
	private String _secret;
	private String _callBackURL;
}