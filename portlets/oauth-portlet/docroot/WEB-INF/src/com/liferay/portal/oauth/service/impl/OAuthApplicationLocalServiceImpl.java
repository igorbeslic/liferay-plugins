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

package com.liferay.portal.oauth.service.impl;

import com.liferay.portal.RequiredFieldException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.oauth.OAuthUtil;
import com.liferay.portal.oauth.model.OAuthApplication;
import com.liferay.portal.oauth.service.base.OAuthApplicationLocalServiceBaseImpl;
import com.liferay.portal.oauth.util.OAuthConstants;
import com.liferay.portal.service.ServiceContext;

import java.net.MalformedURLException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the o auth application local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portal.oauth.service.OAuthApplicationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Igor Beslic
 * @see com.liferay.portal.oauth.service.base.OAuthApplicationLocalServiceBaseImpl
 * @see com.liferay.portal.oauth.service.OAuthApplicationLocalServiceUtil
 */
public class OAuthApplicationLocalServiceImpl
	extends OAuthApplicationLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portal.oauth.service.OAuthApplicationLocalServiceUtil} to access the o auth application local service.
	 */

	/**
	 * Add info about new application that should use OAuth feature. Method will
	 * generate new consumer key and secret that will be used by this
	 * application to do authorized access to portal resources.
	 */
	public OAuthApplication addApplication(
			long userId, String name, String description, String website,
			String callBackURL, int accessLevel, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		validate(name, website, callBackURL);

		Date now = new Date();

		// Application

		long applicationId = counterLocalService.increment();

		OAuthApplication application = oAuthApplicationPersistence.create(
			applicationId);

		application.setCompanyId(user.getCompanyId());
		application.setUserId(user.getUserId());
		application.setUserName(user.getFullName());
		application.setCreateDate(serviceContext.getCreateDate(now));
		application.setModifiedDate(serviceContext.getModifiedDate(now));
		application.setName(name);
		application.setDescription(description);
		application.setWebsite(website);
		application.setCallBackURL(callBackURL);
		application.setAccessLevel(accessLevel);

		// This is to support potential import

		String consumerKey = serviceContext.getUuid();

		if (Validator.isNull(consumerKey)) {
			consumerKey = PortalUUIDUtil.generate();
		}

		String consumerSecret = OAuthUtil.randomizeToken(consumerKey);

		application.setConsumerKey(consumerKey);
		application.setConsumerSecret(consumerSecret);

		oAuthApplicationPersistence.update(application, false);

		// Resources

		resourceLocalService.addResources(
			application.getCompanyId(), 0, userId,
			OAuthApplication.class.getName(), application.getApplicationId(),
			false, false, false);

		return application;
	}

	public OAuthApplication deleteApplication(
			OAuthApplication application, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Applications

		oAuthApplicationUserPersistence.removeByApplicationId(
			application.getApplicationId());

		// Resources

		resourceLocalService.deleteResource(
			application.getCompanyId(), OAuthApplication.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, application.getApplicationId());

		// Application

		oAuthApplicationPersistence.remove(application);

		return application;
	}

	public OAuthApplication deleteApplication(
			long applicationId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		OAuthApplication application =
			oAuthApplicationPersistence.findByPrimaryKey(applicationId);

		return deleteApplication(application, serviceContext);
	}

	public OAuthApplication fetchApplication(String consumerKey)
		throws SystemException {

		return oAuthApplicationPersistence.fetchByConsumerKey(consumerKey);
	}

	public OAuthApplication getApplication(long applicationId)
		throws PortalException, SystemException {

		return oAuthApplicationPersistence.findByPrimaryKey(applicationId);
	}

	public OAuthApplication getApplication(String consumerKey)
		throws PortalException, SystemException {

		return oAuthApplicationPersistence.findByConsumerKey(consumerKey);
	}

	public List<OAuthApplication> getApplications(long companyId)
		throws SystemException {

		return oAuthApplicationPersistence.findByCompanyId(companyId);
	}

	public List<OAuthApplication> getApplications(
			long companyId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return oAuthApplicationPersistence.findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	public List<OAuthApplication> getApplicationsByUserId(
			long userId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return oAuthApplicationPersistence.findByUserId(
			userId, start, end, orderByComparator);
	}

	public int getApplicationsByUserIdCount(long userId)
		throws SystemException {

		return oAuthApplicationPersistence.countByUserId(userId);
	}

	public int getApplicationsCount(long companyId) throws SystemException {
		return oAuthApplicationPersistence.countByCompanyId(companyId);
	}

	/**
	 * Update existing application that should use OAuth feature. If changed
	 * method will update name, description, website, callbackURL and
	 * access level.
	 */
	public OAuthApplication updateApplication(
			long userId, long applicationId, String name, String description,
			String website, String callBackURL, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Application

		validate(name, website, callBackURL);

		Date now = new Date();

		OAuthApplication application =
			oAuthApplicationPersistence.findByPrimaryKey(applicationId);

		application.setModifiedDate(serviceContext.getModifiedDate(now));
		application.setName(name);
		application.setDescription(description);
		application.setWebsite(website);
		application.setCallBackURL(callBackURL);

		oAuthApplicationPersistence.update(application, false);

		return application;
	}

	private void validate(String name, String website, String callBackURL)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new RequiredFieldException(
				"required-field", OAuthConstants.NAME);
		}

		if (Validator.isNull(callBackURL)) {
			throw new RequiredFieldException(
				"required-field", OAuthConstants.CALLBACK_URL);
		}

		if (!Validator.isUrl(callBackURL)) {
			throw new PortalException(new MalformedURLException(callBackURL));
		}

		if (Validator.isNull(website)) {
			throw new RequiredFieldException(
				"required-field", OAuthConstants.WEBSITE);
		}

		if (!Validator.isUrl(website)) {
			throw new PortalException(new MalformedURLException(website));
		}
	}

}