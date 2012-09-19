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

import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

import com.liferay.portal.RequiredFieldException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.oauth.model.Application;
import com.liferay.portal.oauth.service.base.ApplicationLocalServiceBaseImpl;
import com.liferay.portal.oauth.util.OAuthConstants;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the application local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portal.oauth.service.ApplicationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.oauth.service.base.ApplicationLocalServiceBaseImpl
 * @see com.liferay.portal.oauth.service.ApplicationLocalServiceUtil
 */
public class ApplicationLocalServiceImpl extends ApplicationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portal.oauth.service.ApplicationLocalServiceUtil} to access the application local service.
	 */
	
	/**
	 * Add info about new application that should use OAuth feature. Method will
	 * generate new consumer key and secret that will be used by this
	 * application to do authorized access to portal resources.
	 */
	public Application addApplication(
			long userId, String name, String description, String website,
			String callBackURL, int accessLevel, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Application

		User user = userPersistence.findByPrimaryKey(userId);

		validate(name, website, callBackURL);

		Date now = new Date();

		long applicationId = counterLocalService.increment();

		Application application = applicationPersistence.create(
			applicationId);

		application.setCompanyId(user.getCompanyId());
		application.setUserId(user.getUserId());
		application.setUserName(user.getFullName());
		application.setCreateDate(serviceContext.getCreateDate(now));
		application.setModifiedDate(serviceContext.getModifiedDate(now));
		application.setName(name);
		application.setDescription(description);
		application.setWebsite(website);
		application.setConsumerKey(PortalUUIDUtil.generate());

		String secretSeed = application.getConsumerKey().concat(
			String.valueOf(System.nanoTime()));

		application.setConsumerSecret(DigesterUtil.digestHex(secretSeed));
		application.setCallBackURL(callBackURL);
		application.setAccessLevel(accessLevel);

		applicationPersistence.update(application, true);

		// Resources

		resourceLocalService.addModelResources(application, serviceContext);

		return application;
	}

	/**
	 * Delete OAuth application designated by applicationId. Method will
	 * delete all application user's authorizations, application and
	 * corresponding resource entries.
	 */
	public Application deleteApplication(
			long applicationId, long userId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Application user's authorizations
		applicationUserPersistence
			.removeByApplicationId(applicationId);

		// TODO remove resorces when ivica is done with his code...

		// Application

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		Application application =
				applicationPersistence.findByPrimaryKey(applicationId);

		application.setUserId(user.getUserId());
		application.setUserName(user.getFullName());
		application.setModifiedDate(serviceContext.getModifiedDate(now));

		// Resources

		resourceLocalService.deleteResource(
				application, ResourceConstants.SCOPE_COMPANY);

		// Application

		application = applicationPersistence.remove(application);

		return application;
	}

	public Application getApplication(String consumerKey)
		throws SystemException {

		return applicationPersistence.fetchByConsumerKey(consumerKey);
	}

	public List<Application> getApplications(long companyId)
		throws SystemException {

		return applicationPersistence.findByCompanyId(companyId);
	}

	public List<Application> getApplications(
			long companyId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return applicationPersistence.findByCompanyId(
					companyId, start, end, orderByComparator);
	}

	public List<Application> getApplications(
			long companyId, String name, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {
		if (null == name) {
			name = "%";
		}

		return applicationPersistence.findByC_N(
			companyId, name, start, end, orderByComparator);
	}

	public List<Application> getApplicationsByCN(
			long companyId, String name)
		throws SystemException {

		return applicationPersistence.findByC_N(companyId, name);
	}

	public List<Application> getApplicationsByON(long userId, String name)
		throws SystemException {
		if (null == name) {
			name = "%";
		}

		return applicationPersistence.findByU_N(userId, name);
	}

	public List<Application> getApplicationsByON(
			long userId, String name, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {
		if (null == name) {
			name = "%";
		}

		return applicationPersistence.findByU_N(
			userId, name, start, end, orderByComparator);
	}

	public List<Application> getApplicationsByOwner(
			long userId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return applicationPersistence.findByUserId(
			userId, start, end, orderByComparator);
	}

	public int getApplicationsCount(long companyId) throws SystemException {
		return applicationPersistence.countByCompanyId(companyId);
	}

	public int getApplicationsCountByCN(long companyId, String name)
		throws SystemException {
		if (null == name) {
			name = "%";
		}

		return applicationPersistence.countByC_N(companyId, name);
	}

	public int getApplicationsCountByON(long userId, String name)
		throws SystemException {
		if (null == name) {
			name = "%";
		}

		return applicationPersistence.countByU_N(userId, name);
	}

	public int getApplicationsCountByOwnerId(long userId)
		throws SystemException {

		return applicationPersistence.countByUserId(userId);
	}

	/**
	 * Update existing application that should use OAuth feature. If changed
	 * method will update name, description, website, callbackURL and
	 * access level.
	 */
	public Application updateApplication(
			long applicationId, long userId, String name, String description,
			String website, String callBackURL, int accessLevel,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Application

		User user = userPersistence.findByPrimaryKey(userId);

		validate(name, website, callBackURL);

		Date now = new Date();

		Application application =
				applicationPersistence.findByPrimaryKey(applicationId);

		application.setUserId(user.getUserId());
		application.setUserName(user.getFullName());
		application.setModifiedDate(serviceContext.getModifiedDate(now));
		application.setName(name);
		application.setDescription(description);
		application.setWebsite(website);
		application.setCallBackURL(callBackURL);

		// TODO: Ray/Mike - we probably shouldn't allow access level change?
		application.setAccessLevel(accessLevel);

		applicationPersistence.update(application, true);

		// Resources
		// TODO: Ray/Mike does update requires resource updates?

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