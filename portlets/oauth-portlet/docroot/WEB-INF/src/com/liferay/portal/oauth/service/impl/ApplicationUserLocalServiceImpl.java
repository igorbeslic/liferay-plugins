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

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.oauth.model.ApplicationUser;
import com.liferay.portal.oauth.service.base.ApplicationUserLocalServiceBaseImpl;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the application user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portal.oauth.service.ApplicationUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.oauth.service.base.ApplicationUserLocalServiceBaseImpl
 * @see com.liferay.portal.oauth.service.ApplicationUserLocalServiceUtil
 */
public class ApplicationUserLocalServiceImpl
	extends ApplicationUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portal.oauth.service.ApplicationUserLocalServiceUtil} to access the application user local service.
	 */
	
	/**
	 * Add new user's authorization for an existing application that is
	 * registered to use OAuth feature. All optional fields will be set to
	 * null or initial value (depending on data type). Method creates necessary
	 * resources used later by permissions algorithm.
	 *
	 * @param authorized
	 * @param oAuthApplicationId
	 * @param userId
	 * @param accessSecret
	 * @param accessToken
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public ApplicationUser addApplicationUser(
			boolean authorized, long oAuthApplicationId, long userId,
			String accessSecret, String accessToken,
			ServiceContext serviceContext)
		throws PortalException, SystemException {
		ApplicationUser oAuthApplications_users =
				createApplicationUser(
						CounterLocalServiceUtil.increment());

		oAuthApplications_users.setAuthorized(authorized);
		oAuthApplications_users.setApplicationId(oAuthApplicationId);
		oAuthApplications_users.setUserId(userId);
		oAuthApplications_users.setAccessSecret(accessSecret);
		oAuthApplications_users.setAccessToken(accessToken);

		oAuthApplications_users = updateApplicationUser(
			oAuthApplications_users, true);

		resourceLocalService.addModelResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			serviceContext.getUserId(), ApplicationUser.class.getName(),
			oAuthApplications_users.getPrimaryKey(), new String[0],
			new String[0]);

		return oAuthApplications_users;
	}

	public int countByApplicationId(long applicationId) throws SystemException {
		return applicationUserPersistence
				.countByApplicationId(applicationId);
	}

	public int countByOwner(long ownerId, boolean authorized)
		throws SystemException {
		return applicationUserFinder.countByO_A(ownerId, authorized);
	}

	public int countByUser(long userId) throws SystemException {
		return applicationUserPersistence.countByU_AU(userId);
	}

	public ApplicationUser deleteApplicationUser(
			long applicationId, long userId, ServiceContext serviceContext)
		throws PortalException, SystemException {
		ApplicationUser oAuthApplications_users =
			applicationUserPersistence
				.findByU_AP(userId, applicationId);

		oAuthApplications_users = deleteApplicationUser(
				oAuthApplications_users);

		resourceLocalService.deleteResource(
				serviceContext.getCompanyId(),
				ApplicationUser.class.getName(),
				ResourceConstants.SCOPE_COMPANY,
				oAuthApplications_users.getPrimaryKey());

		return oAuthApplications_users;
	}

	public List<ApplicationUser> findByApplicationId(long applicationId)
		throws SystemException {
			return applicationUserPersistence
					.findByApplicationId(applicationId);
	}

	public List<ApplicationUser> findByOwner(
			long ownerId, boolean authorized, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {
		return applicationUserFinder
				.findByO_A(ownerId, authorized, start, end, orderByComparator);
	}

	public List<ApplicationUser> findByUser(long userId)
		throws SystemException {
		return applicationUserPersistence.findByU_AU(userId);
	}

	public List<ApplicationUser> findByUser(
			long userId, int start, int end)
		throws SystemException {
		return applicationUserPersistence
				.findByU_AU(userId, start, end);
	}

	public List<ApplicationUser> findByUser(
			long userId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {
		return applicationUserPersistence
				.findByU_AU(userId, start, end, orderByComparator);
	}

	public ApplicationUser getApplicationUserByAccessToken(
		String accessToken)
		throws SystemException {

		ApplicationUser applicationUser = null;
		List<ApplicationUser> oAuthApplications_userses =
			applicationUserPersistence.findByAccessToken(accessToken);

		if (oAuthApplications_userses.size() > 0) {
			applicationUser = oAuthApplications_userses.get(0);
		}

		return applicationUser;
	}

	/**
	 * Update user's authorization for an existing application that is
	 * registered to use OAuth feature. If entity doesn't exist new one (with
	 * resources for later permissions check) will be created. When updating
	 * existing authorization, method prevents overwriting non null
	 * accessSecret and accessToken fields.
	 *
	 * @param authorized if set to false application access rights are revoked
	 * @param oAuthApplicationId
	 * @param userId
	 * @param accessSecret
	 * @param accessToken
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public ApplicationUser updateApplicationUser(
			boolean authorized, long applicationId, long userId,
			String accessSecret, String accessToken,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		ApplicationUser applicationUser =
			applicationUserPersistence.fetchByU_AP(userId, applicationId);

		if (applicationUser == null) {
			applicationUser =
				addApplicationUser(
					authorized, applicationId, userId, accessSecret,
					accessToken, serviceContext);
		}
		else {
			applicationUser.setAuthorized(authorized);

			/* update secret/token only if it is null
			 * (update is not supported by OAuth Specification
			 */
			if (null == applicationUser.getAccessSecret()) {
				applicationUser.setAccessSecret(accessSecret);
			}

			if (null == applicationUser.getAccessToken()) {
				applicationUser.setAccessToken(accessToken);
			}

			applicationUser = updateApplicationUser(
					applicationUser, true);
		}

		return applicationUser;
	}

	public ApplicationUser updateApplicationUser(
			long applicationId, long userId, boolean authorized)
		throws SystemException {

		ApplicationUser applicationUser =
			applicationUserPersistence.fetchByU_AP(
				userId, applicationId);

		if (applicationUser == null) {
			applicationUser = createApplicationUser(
					CounterLocalServiceUtil.increment());
			applicationUser.setApplicationId(applicationId);
			applicationUser.setUserId(userId);
		}

		applicationUser.setAuthorized(authorized);

		applicationUser = updateApplicationUser(
			applicationUser, true);

		return applicationUser;
	}

	public ApplicationUser updateApplicationUser(
			long applicationId, long userId, String accessToken,
			String accessSecret)
		throws SystemException {

		ApplicationUser applicationUser =
			applicationUserPersistence.fetchByU_AP(
				userId, applicationId);

		if (applicationUser == null) {
			applicationUser = createApplicationUser(
					CounterLocalServiceUtil.increment());
			applicationUser.setApplicationId(applicationId);
			applicationUser.setUserId(userId);
			applicationUser.setAccessToken(accessToken);
			applicationUser.setAccessSecret(accessSecret);
		}

		applicationUser.setAccessToken(accessToken);
		applicationUser.setAccessSecret(accessSecret);

		applicationUser = updateApplicationUser(
			applicationUser, true);

		return applicationUser;
	}
	
}