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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.oauth.model.OAuthApplicationUser;
import com.liferay.portal.oauth.service.base.OAuthApplicationUserLocalServiceBaseImpl;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the o auth applications_ users local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portal.oauth.service.OAuthApplicationUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.oauth.service.base.OAuthApplicationUserLocalServiceBaseImpl
 * @see com.liferay.portal.oauth.service.OAuthApplicationUserLocalServiceUtil
 */
public class OAuthApplicationUserLocalServiceImpl
	extends OAuthApplicationUserLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portal.oauth.service.OAuthApplicationUserLocalServiceUtil} to access the o auth applications_ users local service.
	 */

	/**
	 * Add new user's authorization for an existing application that is
	 * registered to use OAuth feature. All optional fields will be set to
	 * null or initial value (depending on data type). Method creates necessary
	 * resources used later by permissions algorithm.
	 *
	 * @param userId
	 * @param applicationId
	 * @param accessToken
	 * @param accessSecret
	 * @param authorized
	 * @param serviceContext
	 *
	 * @return the applicationUser
	 * @throws PortalException
	 * @throws SystemException
	 */
	public OAuthApplicationUser addApplicationUser(
			long userId, long applicationId, String accessToken,
			String accessSecret, boolean authorized,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		long oaauId = counterLocalService.increment();

		OAuthApplicationUser applicationUser =
			oAuthApplicationUserPersistence.create(oaauId);

		applicationUser.setUserId(userId);
		applicationUser.setApplicationId(applicationId);
		applicationUser.setAccessToken(accessToken);
		applicationUser.setAccessSecret(accessSecret);
		applicationUser.setAuthorized(authorized);

		applicationUser = oAuthApplicationUserPersistence.update(
			applicationUser, false);

		resourceLocalService.addResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			serviceContext.getUserId(), OAuthApplicationUser.class.getName(),
			applicationUser.getPrimaryKey(), false, false, false);

		return applicationUser;
	}

	public OAuthApplicationUser deleteApplicationUser(
			long userId, long applicationId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		OAuthApplicationUser applicationUser =
			oAuthApplicationUserPersistence.findByU_AP(
				userId, applicationId);

		return deleteApplicationUser(applicationUser, serviceContext);
	}

	public OAuthApplicationUser deleteApplicationUser(
			OAuthApplicationUser applicationUser, ServiceContext serviceContext)
		throws PortalException, SystemException {

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), OAuthApplicationUser.class.getName(),
			ResourceConstants.SCOPE_COMPANY, applicationUser.getPrimaryKey());

		applicationUser = oAuthApplicationUserPersistence.remove(
			applicationUser);

		return applicationUser;
	}

	public List<OAuthApplicationUser> getApplicationUsers(long applicationId)
		throws SystemException {

		return oAuthApplicationUserPersistence.findByApplicationId(
			applicationId);
	}

	public List<OAuthApplicationUser> getApplicationUsers(
			long applicationId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return oAuthApplicationUserPersistence.findByApplicationId(
			applicationId, start, end, orderByComparator);
	}

	public List<OAuthApplicationUser> getApplicationUsersByUserId(long userId)
		throws SystemException {

		return oAuthApplicationUserPersistence.findByUserId(userId);
	}

	public List<OAuthApplicationUser> getApplicationUsersByUserId(
			long userId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return oAuthApplicationUserPersistence.findByUserId(
			userId, start, end, orderByComparator);
	}

	public int getApplicationUsersByUserIdCount(long userId)
		throws SystemException {

		return oAuthApplicationUserPersistence.countByUserId(userId);
	}

	public int getApplicationUsersCount(long applicationId)
		throws SystemException {

		return oAuthApplicationUserPersistence.countByApplicationId(
			applicationId);
	}

	public List<OAuthApplicationUser> getAuthorizedApplicationUsersByUserId(
			long userId, boolean authorized)
		throws SystemException {

		return oAuthApplicationUserPersistence.findByU_AU(userId, authorized);
	}

	public List<OAuthApplicationUser> getAuthorizedApplicationUsersByUserId(
			long userId, boolean authorized, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return oAuthApplicationUserPersistence.findByU_AU(
			userId, authorized, start, end, orderByComparator);
	}

	public int getAuthorizedApplicationUsersByUserIdCount(
			long userId, boolean authorized)
		throws SystemException {

		return oAuthApplicationUserPersistence.countByU_AU(userId, authorized);
	}

	public OAuthApplicationUser updateAuthorized(
			long userId, long applicationId, boolean authorized,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		OAuthApplicationUser applicationUser =
			oAuthApplicationUserPersistence.fetchByU_AP(userId, applicationId);

		applicationUser.setAuthorized(authorized);

		oAuthApplicationUserPersistence.update(applicationUser, false);

		return applicationUser;
	}

	/**
	 * Update user's authorization for an existing application that is
	 * registered to use OAuth feature. If entity doesn't exist new one (with
	 * resources for later permissions check) will be created. When updating
	 * existing authorization, method prevents overwriting non null
	 * accessSecret and accessToken fields.
	 *
	 * @param userId
	 * @param applicationId
	 * @param accessToken
	 * @param accessSecret
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public OAuthApplicationUser updateApplicationUser(
			long userId, long applicationId, String accessToken,
			String accessSecret, ServiceContext serviceContext)
		throws PortalException, SystemException {

		OAuthApplicationUser applicationUser =
			oAuthApplicationUserPersistence.fetchByU_AP(userId, applicationId);

		applicationUser.setAccessToken(accessToken);
		applicationUser.setAccessSecret(accessSecret);

		oAuthApplicationUserPersistence.update(applicationUser, false);

		return applicationUser;
	}

}