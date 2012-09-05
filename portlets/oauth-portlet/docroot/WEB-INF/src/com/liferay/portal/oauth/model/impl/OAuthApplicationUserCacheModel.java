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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.oauth.model.OAuthApplicationUser;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing OAuthApplicationUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplicationUser
 * @generated
 */
public class OAuthApplicationUserCacheModel implements CacheModel<OAuthApplicationUser>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{oaauId=");
		sb.append(oaauId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", applicationId=");
		sb.append(applicationId);
		sb.append(", accessToken=");
		sb.append(accessToken);
		sb.append(", accessSecret=");
		sb.append(accessSecret);
		sb.append(", authorized=");
		sb.append(authorized);
		sb.append("}");

		return sb.toString();
	}

	public OAuthApplicationUser toEntityModel() {
		OAuthApplicationUserImpl oAuthApplicationUserImpl = new OAuthApplicationUserImpl();

		oAuthApplicationUserImpl.setOaauId(oaauId);
		oAuthApplicationUserImpl.setCompanyId(companyId);
		oAuthApplicationUserImpl.setUserId(userId);

		if (userName == null) {
			oAuthApplicationUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			oAuthApplicationUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			oAuthApplicationUserImpl.setCreateDate(null);
		}
		else {
			oAuthApplicationUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			oAuthApplicationUserImpl.setModifiedDate(null);
		}
		else {
			oAuthApplicationUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		oAuthApplicationUserImpl.setApplicationId(applicationId);

		if (accessToken == null) {
			oAuthApplicationUserImpl.setAccessToken(StringPool.BLANK);
		}
		else {
			oAuthApplicationUserImpl.setAccessToken(accessToken);
		}

		if (accessSecret == null) {
			oAuthApplicationUserImpl.setAccessSecret(StringPool.BLANK);
		}
		else {
			oAuthApplicationUserImpl.setAccessSecret(accessSecret);
		}

		oAuthApplicationUserImpl.setAuthorized(authorized);

		oAuthApplicationUserImpl.resetOriginalValues();

		return oAuthApplicationUserImpl;
	}

	public long oaauId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long applicationId;
	public String accessToken;
	public String accessSecret;
	public boolean authorized;
}