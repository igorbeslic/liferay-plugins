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
 * This class is a wrapper for {@link OAuthApplications_UsersLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       OAuthApplications_UsersLocalService
 * @generated
 */
public class OAuthApplications_UsersLocalServiceWrapper
	implements OAuthApplications_UsersLocalService,
		ServiceWrapper<OAuthApplications_UsersLocalService> {
	public OAuthApplications_UsersLocalServiceWrapper(
		OAuthApplications_UsersLocalService oAuthApplications_UsersLocalService) {
		_oAuthApplications_UsersLocalService = oAuthApplications_UsersLocalService;
	}

	/**
	* Adds the o auth applications_ users to the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplications_Users the o auth applications_ users
	* @return the o auth applications_ users that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplications_Users addOAuthApplications_Users(
		com.liferay.portal.oauth.model.OAuthApplications_Users oAuthApplications_Users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.addOAuthApplications_Users(oAuthApplications_Users);
	}

	/**
	* Creates a new o auth applications_ users with the primary key. Does not add the o auth applications_ users to the database.
	*
	* @param oaauid the primary key for the new o auth applications_ users
	* @return the new o auth applications_ users
	*/
	public com.liferay.portal.oauth.model.OAuthApplications_Users createOAuthApplications_Users(
		long oaauid) {
		return _oAuthApplications_UsersLocalService.createOAuthApplications_Users(oaauid);
	}

	/**
	* Deletes the o auth applications_ users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaauid the primary key of the o auth applications_ users
	* @return the o auth applications_ users that was removed
	* @throws PortalException if a o auth applications_ users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplications_Users deleteOAuthApplications_Users(
		long oaauid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.deleteOAuthApplications_Users(oaauid);
	}

	/**
	* Deletes the o auth applications_ users from the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplications_Users the o auth applications_ users
	* @return the o auth applications_ users that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplications_Users deleteOAuthApplications_Users(
		com.liferay.portal.oauth.model.OAuthApplications_Users oAuthApplications_Users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.deleteOAuthApplications_Users(oAuthApplications_Users);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _oAuthApplications_UsersLocalService.dynamicQuery();
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
		return _oAuthApplications_UsersLocalService.dynamicQuery(dynamicQuery);
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
		return _oAuthApplications_UsersLocalService.dynamicQuery(dynamicQuery,
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
		return _oAuthApplications_UsersLocalService.dynamicQuery(dynamicQuery,
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
		return _oAuthApplications_UsersLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.portal.oauth.model.OAuthApplications_Users fetchOAuthApplications_Users(
		long oaauid) throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.fetchOAuthApplications_Users(oaauid);
	}

	/**
	* Returns the o auth applications_ users with the primary key.
	*
	* @param oaauid the primary key of the o auth applications_ users
	* @return the o auth applications_ users
	* @throws PortalException if a o auth applications_ users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplications_Users getOAuthApplications_Users(
		long oaauid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.getOAuthApplications_Users(oaauid);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the o auth applications_ userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of o auth applications_ userses
	* @param end the upper bound of the range of o auth applications_ userses (not inclusive)
	* @return the range of o auth applications_ userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> getOAuthApplications_Userses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.getOAuthApplications_Userses(start,
			end);
	}

	/**
	* Returns the number of o auth applications_ userses.
	*
	* @return the number of o auth applications_ userses
	* @throws SystemException if a system exception occurred
	*/
	public int getOAuthApplications_UsersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.getOAuthApplications_UsersesCount();
	}

	/**
	* Updates the o auth applications_ users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplications_Users the o auth applications_ users
	* @return the o auth applications_ users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		com.liferay.portal.oauth.model.OAuthApplications_Users oAuthApplications_Users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.updateOAuthApplications_Users(oAuthApplications_Users);
	}

	/**
	* Updates the o auth applications_ users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplications_Users the o auth applications_ users
	* @param merge whether to merge the o auth applications_ users with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the o auth applications_ users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		com.liferay.portal.oauth.model.OAuthApplications_Users oAuthApplications_Users,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.updateOAuthApplications_Users(oAuthApplications_Users,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _oAuthApplications_UsersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_oAuthApplications_UsersLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _oAuthApplications_UsersLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

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
	public com.liferay.portal.oauth.model.OAuthApplications_Users addOAuthApplications_Users(
		boolean authorized, long oAuthApplicationId, long userId,
		java.lang.String accessSecret, java.lang.String accessToken,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.addOAuthApplications_Users(authorized,
			oAuthApplicationId, userId, accessSecret, accessToken,
			serviceContext);
	}

	public int countByApplicationId(long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.countByApplicationId(applicationId);
	}

	public int countByOwner(long ownerId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.countByOwner(ownerId,
			authorized);
	}

	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.countByUser(userId);
	}

	public com.liferay.portal.oauth.model.OAuthApplications_Users deleteOAuthApplications_Users(
		long oAuthApplicationId, long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.deleteOAuthApplications_Users(oAuthApplicationId,
			userId, serviceContext);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByApplicationId(
		long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.findByApplicationId(applicationId);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByOwner(
		long ownerId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.findByOwner(ownerId,
			authorized, start, end, orderByComparator);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.findByUser(userId);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.findByUser(userId, start,
			end);
	}

	public java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.findByUser(userId, start,
			end, orderByComparator);
	}

	public com.liferay.portal.oauth.model.OAuthApplications_Users getOAuthApplications_UsersByAccessToken(
		java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.getOAuthApplications_UsersByAccessToken(accessToken);
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
	public com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		boolean authorized, long oAuthApplicationId, long userId,
		java.lang.String accessSecret, java.lang.String accessToken,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.updateOAuthApplications_Users(authorized,
			oAuthApplicationId, userId, accessSecret, accessToken,
			serviceContext);
	}

	public com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		long oAuthApplicationId, long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.updateOAuthApplications_Users(oAuthApplicationId,
			userId, authorized);
	}

	public com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		long oAuthApplicationId, long userId, java.lang.String accessToken,
		java.lang.String accessSecret)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _oAuthApplications_UsersLocalService.updateOAuthApplications_Users(oAuthApplicationId,
			userId, accessToken, accessSecret);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public OAuthApplications_UsersLocalService getWrappedOAuthApplications_UsersLocalService() {
		return _oAuthApplications_UsersLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedOAuthApplications_UsersLocalService(
		OAuthApplications_UsersLocalService oAuthApplications_UsersLocalService) {
		_oAuthApplications_UsersLocalService = oAuthApplications_UsersLocalService;
	}

	public OAuthApplications_UsersLocalService getWrappedService() {
		return _oAuthApplications_UsersLocalService;
	}

	public void setWrappedService(
		OAuthApplications_UsersLocalService oAuthApplications_UsersLocalService) {
		_oAuthApplications_UsersLocalService = oAuthApplications_UsersLocalService;
	}

	private OAuthApplications_UsersLocalService _oAuthApplications_UsersLocalService;
}