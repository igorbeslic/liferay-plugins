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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the o auth applications_ users local service. This utility wraps {@link com.liferay.portal.oauth.service.impl.OAuthApplications_UsersLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplications_UsersLocalService
 * @see com.liferay.portal.oauth.service.base.OAuthApplications_UsersLocalServiceBaseImpl
 * @see com.liferay.portal.oauth.service.impl.OAuthApplications_UsersLocalServiceImpl
 * @generated
 */
public class OAuthApplications_UsersLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.oauth.service.impl.OAuthApplications_UsersLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the o auth applications_ users to the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplications_Users the o auth applications_ users
	* @return the o auth applications_ users that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplications_Users addOAuthApplications_Users(
		com.liferay.portal.oauth.model.OAuthApplications_Users oAuthApplications_Users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOAuthApplications_Users(oAuthApplications_Users);
	}

	/**
	* Creates a new o auth applications_ users with the primary key. Does not add the o auth applications_ users to the database.
	*
	* @param oaauid the primary key for the new o auth applications_ users
	* @return the new o auth applications_ users
	*/
	public static com.liferay.portal.oauth.model.OAuthApplications_Users createOAuthApplications_Users(
		long oaauid) {
		return getService().createOAuthApplications_Users(oaauid);
	}

	/**
	* Deletes the o auth applications_ users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaauid the primary key of the o auth applications_ users
	* @return the o auth applications_ users that was removed
	* @throws PortalException if a o auth applications_ users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplications_Users deleteOAuthApplications_Users(
		long oaauid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOAuthApplications_Users(oaauid);
	}

	/**
	* Deletes the o auth applications_ users from the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplications_Users the o auth applications_ users
	* @return the o auth applications_ users that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplications_Users deleteOAuthApplications_Users(
		com.liferay.portal.oauth.model.OAuthApplications_Users oAuthApplications_Users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteOAuthApplications_Users(oAuthApplications_Users);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.portal.oauth.model.OAuthApplications_Users fetchOAuthApplications_Users(
		long oaauid) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOAuthApplications_Users(oaauid);
	}

	/**
	* Returns the o auth applications_ users with the primary key.
	*
	* @param oaauid the primary key of the o auth applications_ users
	* @return the o auth applications_ users
	* @throws PortalException if a o auth applications_ users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplications_Users getOAuthApplications_Users(
		long oaauid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthApplications_Users(oaauid);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> getOAuthApplications_Userses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthApplications_Userses(start, end);
	}

	/**
	* Returns the number of o auth applications_ userses.
	*
	* @return the number of o auth applications_ userses
	* @throws SystemException if a system exception occurred
	*/
	public static int getOAuthApplications_UsersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOAuthApplications_UsersesCount();
	}

	/**
	* Updates the o auth applications_ users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplications_Users the o auth applications_ users
	* @return the o auth applications_ users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		com.liferay.portal.oauth.model.OAuthApplications_Users oAuthApplications_Users)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateOAuthApplications_Users(oAuthApplications_Users);
	}

	/**
	* Updates the o auth applications_ users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplications_Users the o auth applications_ users
	* @param merge whether to merge the o auth applications_ users with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the o auth applications_ users that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		com.liferay.portal.oauth.model.OAuthApplications_Users oAuthApplications_Users,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateOAuthApplications_Users(oAuthApplications_Users, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.portal.oauth.service.OAuthApplications_UsersLocalServiceUtil} to access the o auth applications_ users local service.
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUser(userId);
	}

	public static int countByOwner(long ownerId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByOwner(ownerId, authorized);
	}

	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUser(userId);
	}

	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUser(userId, start, end);
	}

	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUser(userId, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplications_Users> findByOwner(
		long ownerId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByOwner(ownerId, authorized, start, end,
			orderByComparator);
	}

	public static com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		long oAuthApplicationId, long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateOAuthApplications_Users(oAuthApplicationId, userId,
			authorized);
	}

	public static com.liferay.portal.oauth.model.OAuthApplications_Users updateOAuthApplications_Users(
		long oAuthApplicationId, long userId, java.lang.String accessToken,
		java.lang.String accessSecret)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateOAuthApplications_Users(oAuthApplicationId, userId,
			accessToken, accessSecret);
	}

	public static void clearService() {
		_service = null;
	}

	public static OAuthApplications_UsersLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OAuthApplications_UsersLocalService.class.getName());

			if (invokableLocalService instanceof OAuthApplications_UsersLocalService) {
				_service = (OAuthApplications_UsersLocalService)invokableLocalService;
			}
			else {
				_service = new OAuthApplications_UsersLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OAuthApplications_UsersLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(OAuthApplications_UsersLocalService service) {
	}

	private static OAuthApplications_UsersLocalService _service;
}