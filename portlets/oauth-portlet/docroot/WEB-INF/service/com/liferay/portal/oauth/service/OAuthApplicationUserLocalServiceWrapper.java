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

package com.liferay.portal.oauth.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link OAuthApplicationUserLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       OAuthApplicationUserLocalService
 * @generated
 */
public class OAuthApplicationUserLocalServiceWrapper
	implements OAuthApplicationUserLocalService,
		ServiceWrapper<OAuthApplicationUserLocalService> {
	public OAuthApplicationUserLocalServiceWrapper(
		OAuthApplicationUserLocalService oAuthApplicationUserLocalService) {
		_oAuthApplicationUserLocalService = oAuthApplicationUserLocalService;
	}

	/**
	* Adds the o auth application user to the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplicationUser the o auth application user
	* @return the o auth application user that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser addOAuthApplicationUser(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.addOAuthApplicationUser(oAuthApplicationUser);
	}

	/**
	* Creates a new o auth application user with the primary key. Does not add the o auth application user to the database.
	*
	* @param oaauId the primary key for the new o auth application user
	* @return the new o auth application user
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser createOAuthApplicationUser(
		long oaauId) {
		return _oAuthApplicationUserLocalService.createOAuthApplicationUser(oaauId);
	}

	/**
	* Deletes the o auth application user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaauId the primary key of the o auth application user
	* @return the o auth application user that was removed
	* @throws PortalException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser deleteOAuthApplicationUser(
		long oaauId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.deleteOAuthApplicationUser(oaauId);
	}

	/**
	* Deletes the o auth application user from the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplicationUser the o auth application user
	* @return the o auth application user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser deleteOAuthApplicationUser(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.deleteOAuthApplicationUser(oAuthApplicationUser);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _oAuthApplicationUserLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchOAuthApplicationUser(
		long oaauId) throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.fetchOAuthApplicationUser(oaauId);
	}

	/**
	* Returns the o auth application user with the primary key.
	*
	* @param oaauId the primary key of the o auth application user
	* @return the o auth application user
	* @throws PortalException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser getOAuthApplicationUser(
		long oaauId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getOAuthApplicationUser(oaauId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the o auth application users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> getOAuthApplicationUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getOAuthApplicationUsers(start,
			end);
	}

	/**
	* Returns the number of o auth application users.
	*
	* @return the number of o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public int getOAuthApplicationUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getOAuthApplicationUsersCount();
	}

	/**
	* Updates the o auth application user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplicationUser the o auth application user
	* @return the o auth application user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser updateOAuthApplicationUser(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.updateOAuthApplicationUser(oAuthApplicationUser);
	}

	/**
	* Updates the o auth application user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplicationUser the o auth application user
	* @param merge whether to merge the o auth application user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the o auth application user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser updateOAuthApplicationUser(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.updateOAuthApplicationUser(oAuthApplicationUser,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _oAuthApplicationUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_oAuthApplicationUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _oAuthApplicationUserLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

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
	* @return the applicationUser
	* @throws PortalException
	* @throws SystemException
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser addApplicationUser(
		long userId, long applicationId, java.lang.String accessToken,
		java.lang.String accessSecret, boolean authorized,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.addApplicationUser(userId,
			applicationId, accessToken, accessSecret, authorized, serviceContext);
	}

	public com.liferay.portal.oauth.model.OAuthApplicationUser deleteApplicationUser(
		long userId, long applicationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.deleteApplicationUser(userId,
			applicationId, serviceContext);
	}

	public com.liferay.portal.oauth.model.OAuthApplicationUser deleteApplicationUser(
		com.liferay.portal.oauth.model.OAuthApplicationUser applicationUser,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.deleteApplicationUser(applicationUser,
			serviceContext);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> getApplicationUsers(
		long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getApplicationUsers(applicationId);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> getApplicationUsers(
		long applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getApplicationUsers(applicationId,
			start, end, orderByComparator);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> getApplicationUsersByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getApplicationUsersByUserId(userId);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> getApplicationUsersByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getApplicationUsersByUserId(userId,
			start, end, orderByComparator);
	}

	public int getApplicationUsersByUserIdCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getApplicationUsersByUserIdCount(userId);
	}

	public int getApplicationUsersCount(long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getApplicationUsersCount(applicationId);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> getAuthorizedApplicationUsersByUserId(
		long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getAuthorizedApplicationUsersByUserId(userId,
			authorized);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> getAuthorizedApplicationUsersByUserId(
		long userId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getAuthorizedApplicationUsersByUserId(userId,
			authorized, start, end, orderByComparator);
	}

	public int getAuthorizedApplicationUsersByUserIdCount(long userId,
		boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.getAuthorizedApplicationUsersByUserIdCount(userId,
			authorized);
	}

	public com.liferay.portal.oauth.model.OAuthApplicationUser updateAuthorized(
		long userId, long applicationId, boolean authorized,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.updateAuthorized(userId,
			applicationId, authorized, serviceContext);
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
	public com.liferay.portal.oauth.model.OAuthApplicationUser updateApplicationUser(
		long userId, long applicationId, java.lang.String accessToken,
		java.lang.String accessSecret,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplicationUserLocalService.updateApplicationUser(userId,
			applicationId, accessToken, accessSecret, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public OAuthApplicationUserLocalService getWrappedOAuthApplicationUserLocalService() {
		return _oAuthApplicationUserLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedOAuthApplicationUserLocalService(
		OAuthApplicationUserLocalService oAuthApplicationUserLocalService) {
		_oAuthApplicationUserLocalService = oAuthApplicationUserLocalService;
	}

	public OAuthApplicationUserLocalService getWrappedService() {
		return _oAuthApplicationUserLocalService;
	}

	public void setWrappedService(
		OAuthApplicationUserLocalService oAuthApplicationUserLocalService) {
		_oAuthApplicationUserLocalService = oAuthApplicationUserLocalService;
	}

	private OAuthApplicationUserLocalService _oAuthApplicationUserLocalService;
}