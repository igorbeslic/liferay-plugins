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

package com.liferay.portal.oauth.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.oauth.model.OAuthApplication;
import com.liferay.portal.oauth.model.OAuthApplicationModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OAuthApplication service. Represents a row in the &quot;OAuthApplication&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.oauth.model.OAuthApplicationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OAuthApplicationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplicationImpl
 * @see com.liferay.portal.oauth.model.OAuthApplication
 * @see com.liferay.portal.oauth.model.OAuthApplicationModel
 * @generated
 */
public class OAuthApplicationModelImpl extends BaseModelImpl<OAuthApplication>
	implements OAuthApplicationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a o auth application model instance should use the {@link com.liferay.portal.oauth.model.OAuthApplication} interface instead.
	 */
	public static final String TABLE_NAME = "OAuthApplication";
	public static final Object[][] TABLE_COLUMNS = {
			{ "applicationId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "website", Types.VARCHAR },
			{ "callBackURL", Types.VARCHAR },
			{ "accessLevel", Types.INTEGER },
			{ "consumerKey", Types.VARCHAR },
			{ "consumerSecret", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table OAuthApplication (applicationId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description VARCHAR(75) null,website VARCHAR(75) null,callBackURL VARCHAR(75) null,accessLevel INTEGER,consumerKey VARCHAR(75) null,consumerSecret VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table OAuthApplication";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.oauth.model.OAuthApplication"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.oauth.model.OAuthApplication"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.oauth.model.OAuthApplication"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long CONSUMERKEY_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.oauth.model.OAuthApplication"));

	public OAuthApplicationModelImpl() {
	}

	public long getPrimaryKey() {
		return _applicationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setApplicationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_applicationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return OAuthApplication.class;
	}

	public String getModelClassName() {
		return OAuthApplication.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationId", getApplicationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("website", getWebsite());
		attributes.put("callBackURL", getCallBackURL());
		attributes.put("accessLevel", getAccessLevel());
		attributes.put("consumerKey", getConsumerKey());
		attributes.put("consumerSecret", getConsumerSecret());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationId = (Long)attributes.get("applicationId");

		if (applicationId != null) {
			setApplicationId(applicationId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String callBackURL = (String)attributes.get("callBackURL");

		if (callBackURL != null) {
			setCallBackURL(callBackURL);
		}

		Integer accessLevel = (Integer)attributes.get("accessLevel");

		if (accessLevel != null) {
			setAccessLevel(accessLevel);
		}

		String consumerKey = (String)attributes.get("consumerKey");

		if (consumerKey != null) {
			setConsumerKey(consumerKey);
		}

		String consumerSecret = (String)attributes.get("consumerSecret");

		if (consumerSecret != null) {
			setConsumerSecret(consumerSecret);
		}
	}

	public long getApplicationId() {
		return _applicationId;
	}

	public void setApplicationId(long applicationId) {
		_applicationId = applicationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
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

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getWebsite() {
		if (_website == null) {
			return StringPool.BLANK;
		}
		else {
			return _website;
		}
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getCallBackURL() {
		if (_callBackURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _callBackURL;
		}
	}

	public void setCallBackURL(String callBackURL) {
		_callBackURL = callBackURL;
	}

	public int getAccessLevel() {
		return _accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		_accessLevel = accessLevel;
	}

	public String getConsumerKey() {
		if (_consumerKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _consumerKey;
		}
	}

	public void setConsumerKey(String consumerKey) {
		_columnBitmask |= CONSUMERKEY_COLUMN_BITMASK;

		if (_originalConsumerKey == null) {
			_originalConsumerKey = _consumerKey;
		}

		_consumerKey = consumerKey;
	}

	public String getOriginalConsumerKey() {
		return GetterUtil.getString(_originalConsumerKey);
	}

	public String getConsumerSecret() {
		if (_consumerSecret == null) {
			return StringPool.BLANK;
		}
		else {
			return _consumerSecret;
		}
	}

	public void setConsumerSecret(String consumerSecret) {
		_consumerSecret = consumerSecret;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			OAuthApplication.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OAuthApplication toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (OAuthApplication)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		OAuthApplicationImpl oAuthApplicationImpl = new OAuthApplicationImpl();

		oAuthApplicationImpl.setApplicationId(getApplicationId());
		oAuthApplicationImpl.setCompanyId(getCompanyId());
		oAuthApplicationImpl.setUserId(getUserId());
		oAuthApplicationImpl.setUserName(getUserName());
		oAuthApplicationImpl.setCreateDate(getCreateDate());
		oAuthApplicationImpl.setModifiedDate(getModifiedDate());
		oAuthApplicationImpl.setName(getName());
		oAuthApplicationImpl.setDescription(getDescription());
		oAuthApplicationImpl.setWebsite(getWebsite());
		oAuthApplicationImpl.setCallBackURL(getCallBackURL());
		oAuthApplicationImpl.setAccessLevel(getAccessLevel());
		oAuthApplicationImpl.setConsumerKey(getConsumerKey());
		oAuthApplicationImpl.setConsumerSecret(getConsumerSecret());

		oAuthApplicationImpl.resetOriginalValues();

		return oAuthApplicationImpl;
	}

	public int compareTo(OAuthApplication oAuthApplication) {
		long primaryKey = oAuthApplication.getPrimaryKey();

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

		OAuthApplication oAuthApplication = null;

		try {
			oAuthApplication = (OAuthApplication)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = oAuthApplication.getPrimaryKey();

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
	public void resetOriginalValues() {
		OAuthApplicationModelImpl oAuthApplicationModelImpl = this;

		oAuthApplicationModelImpl._originalCompanyId = oAuthApplicationModelImpl._companyId;

		oAuthApplicationModelImpl._setOriginalCompanyId = false;

		oAuthApplicationModelImpl._originalUserId = oAuthApplicationModelImpl._userId;

		oAuthApplicationModelImpl._setOriginalUserId = false;

		oAuthApplicationModelImpl._originalConsumerKey = oAuthApplicationModelImpl._consumerKey;

		oAuthApplicationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OAuthApplication> toCacheModel() {
		OAuthApplicationCacheModel oAuthApplicationCacheModel = new OAuthApplicationCacheModel();

		oAuthApplicationCacheModel.applicationId = getApplicationId();

		oAuthApplicationCacheModel.companyId = getCompanyId();

		oAuthApplicationCacheModel.userId = getUserId();

		oAuthApplicationCacheModel.userName = getUserName();

		String userName = oAuthApplicationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			oAuthApplicationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			oAuthApplicationCacheModel.createDate = createDate.getTime();
		}
		else {
			oAuthApplicationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			oAuthApplicationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			oAuthApplicationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		oAuthApplicationCacheModel.name = getName();

		String name = oAuthApplicationCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			oAuthApplicationCacheModel.name = null;
		}

		oAuthApplicationCacheModel.description = getDescription();

		String description = oAuthApplicationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			oAuthApplicationCacheModel.description = null;
		}

		oAuthApplicationCacheModel.website = getWebsite();

		String website = oAuthApplicationCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			oAuthApplicationCacheModel.website = null;
		}

		oAuthApplicationCacheModel.callBackURL = getCallBackURL();

		String callBackURL = oAuthApplicationCacheModel.callBackURL;

		if ((callBackURL != null) && (callBackURL.length() == 0)) {
			oAuthApplicationCacheModel.callBackURL = null;
		}

		oAuthApplicationCacheModel.accessLevel = getAccessLevel();

		oAuthApplicationCacheModel.consumerKey = getConsumerKey();

		String consumerKey = oAuthApplicationCacheModel.consumerKey;

		if ((consumerKey != null) && (consumerKey.length() == 0)) {
			oAuthApplicationCacheModel.consumerKey = null;
		}

		oAuthApplicationCacheModel.consumerSecret = getConsumerSecret();

		String consumerSecret = oAuthApplicationCacheModel.consumerSecret;

		if ((consumerSecret != null) && (consumerSecret.length() == 0)) {
			oAuthApplicationCacheModel.consumerSecret = null;
		}

		return oAuthApplicationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{applicationId=");
		sb.append(getApplicationId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", callBackURL=");
		sb.append(getCallBackURL());
		sb.append(", accessLevel=");
		sb.append(getAccessLevel());
		sb.append(", consumerKey=");
		sb.append(getConsumerKey());
		sb.append(", consumerSecret=");
		sb.append(getConsumerSecret());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.oauth.model.OAuthApplication");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applicationId</column-name><column-value><![CDATA[");
		sb.append(getApplicationId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>callBackURL</column-name><column-value><![CDATA[");
		sb.append(getCallBackURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessLevel</column-name><column-value><![CDATA[");
		sb.append(getAccessLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerKey</column-name><column-value><![CDATA[");
		sb.append(getConsumerKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerSecret</column-name><column-value><![CDATA[");
		sb.append(getConsumerSecret());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OAuthApplication.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			OAuthApplication.class
		};
	private long _applicationId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _website;
	private String _callBackURL;
	private int _accessLevel;
	private String _consumerKey;
	private String _originalConsumerKey;
	private String _consumerSecret;
	private long _columnBitmask;
	private OAuthApplication _escapedModelProxy;
}