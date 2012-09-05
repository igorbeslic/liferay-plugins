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

package com.liferay.portal.oauth.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.oauth.model.OAuthApplicationUser;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the o auth application user service. This utility wraps {@link OAuthApplicationUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplicationUserPersistence
 * @see OAuthApplicationUserPersistenceImpl
 * @generated
 */
public class OAuthApplicationUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(OAuthApplicationUser oAuthApplicationUser) {
		getPersistence().clearCache(oAuthApplicationUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OAuthApplicationUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OAuthApplicationUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OAuthApplicationUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static OAuthApplicationUser update(
		OAuthApplicationUser oAuthApplicationUser, boolean merge)
		throws SystemException {
		return getPersistence().update(oAuthApplicationUser, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static OAuthApplicationUser update(
		OAuthApplicationUser oAuthApplicationUser, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(oAuthApplicationUser, merge, serviceContext);
	}

	/**
	* Caches the o auth application user in the entity cache if it is enabled.
	*
	* @param oAuthApplicationUser the o auth application user
	*/
	public static void cacheResult(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser) {
		getPersistence().cacheResult(oAuthApplicationUser);
	}

	/**
	* Caches the o auth application users in the entity cache if it is enabled.
	*
	* @param oAuthApplicationUsers the o auth application users
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> oAuthApplicationUsers) {
		getPersistence().cacheResult(oAuthApplicationUsers);
	}

	/**
	* Creates a new o auth application user with the primary key. Does not add the o auth application user to the database.
	*
	* @param oaauId the primary key for the new o auth application user
	* @return the new o auth application user
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser create(
		long oaauId) {
		return getPersistence().create(oaauId);
	}

	/**
	* Removes the o auth application user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaauId the primary key of the o auth application user
	* @return the o auth application user that was removed
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser remove(
		long oaauId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence().remove(oaauId);
	}

	public static com.liferay.portal.oauth.model.OAuthApplicationUser updateImpl(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(oAuthApplicationUser, merge);
	}

	/**
	* Returns the o auth application user with the primary key or throws a {@link com.liferay.portal.oauth.NoSuchApplicationUserException} if it could not be found.
	*
	* @param oaauId the primary key of the o auth application user
	* @return the o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByPrimaryKey(
		long oaauId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence().findByPrimaryKey(oaauId);
	}

	/**
	* Returns the o auth application user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param oaauId the primary key of the o auth application user
	* @return the o auth application user, or <code>null</code> if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByPrimaryKey(
		long oaauId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(oaauId);
	}

	/**
	* Returns all the o auth application users where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByAccessToken(
		java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAccessToken(accessToken);
	}

	/**
	* Returns a range of all the o auth application users where accessToken = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param accessToken the access token
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByAccessToken(
		java.lang.String accessToken, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAccessToken(accessToken, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users where accessToken = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param accessToken the access token
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByAccessToken(
		java.lang.String accessToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAccessToken(accessToken, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByAccessToken_First(
		java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByAccessToken_First(accessToken, orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByAccessToken_First(
		java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAccessToken_First(accessToken, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByAccessToken_Last(
		java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByAccessToken_Last(accessToken, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByAccessToken_Last(
		java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAccessToken_Last(accessToken, orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] findByAccessToken_PrevAndNext(
		long oaauId, java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByAccessToken_PrevAndNext(oaauId, accessToken,
			orderByComparator);
	}

	/**
	* Returns all the o auth application users that the user has permission to view where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByAccessToken(
		java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByAccessToken(accessToken);
	}

	/**
	* Returns a range of all the o auth application users that the user has permission to view where accessToken = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param accessToken the access token
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByAccessToken(
		java.lang.String accessToken, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByAccessToken(accessToken, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users that the user has permissions to view where accessToken = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param accessToken the access token
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByAccessToken(
		java.lang.String accessToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByAccessToken(accessToken, start, end,
			orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where accessToken = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByAccessToken_PrevAndNext(
		long oaauId, java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .filterFindByAccessToken_PrevAndNext(oaauId, accessToken,
			orderByComparator);
	}

	/**
	* Returns all the o auth application users where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByApplicationId(
		long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApplicationId(applicationId);
	}

	/**
	* Returns a range of all the o auth application users where applicationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param applicationId the application ID
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByApplicationId(
		long applicationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApplicationId(applicationId, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users where applicationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param applicationId the application ID
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByApplicationId(
		long applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicationId(applicationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByApplicationId_First(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByApplicationId_First(applicationId, orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByApplicationId_First(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicationId_First(applicationId, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByApplicationId_Last(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByApplicationId_Last(applicationId, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByApplicationId_Last(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicationId_Last(applicationId, orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] findByApplicationId_PrevAndNext(
		long oaauId, long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByApplicationId_PrevAndNext(oaauId, applicationId,
			orderByComparator);
	}

	/**
	* Returns all the o auth application users that the user has permission to view where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByApplicationId(
		long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByApplicationId(applicationId);
	}

	/**
	* Returns a range of all the o auth application users that the user has permission to view where applicationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param applicationId the application ID
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByApplicationId(
		long applicationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByApplicationId(applicationId, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users that the user has permissions to view where applicationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param applicationId the application ID
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByApplicationId(
		long applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByApplicationId(applicationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where applicationId = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByApplicationId_PrevAndNext(
		long oaauId, long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .filterFindByApplicationId_PrevAndNext(oaauId,
			applicationId, orderByComparator);
	}

	/**
	* Returns all the o auth application users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the o auth application users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set where userId = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] findByUserId_PrevAndNext(
		long oaauId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByUserId_PrevAndNext(oaauId, userId, orderByComparator);
	}

	/**
	* Returns all the o auth application users that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserId(userId);
	}

	/**
	* Returns a range of all the o auth application users that the user has permission to view where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users that the user has permissions to view where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where userId = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByUserId_PrevAndNext(
		long oaauId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .filterFindByUserId_PrevAndNext(oaauId, userId,
			orderByComparator);
	}

	/**
	* Returns all the o auth application users where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByA_A(
		long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA_A(applicationId, authorized);
	}

	/**
	* Returns a range of all the o auth application users where applicationId = &#63; and authorized = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByA_A(
		long applicationId, boolean authorized, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA_A(applicationId, authorized, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users where applicationId = &#63; and authorized = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByA_A(
		long applicationId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByA_A(applicationId, authorized, start, end,
			orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByA_A_First(
		long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByA_A_First(applicationId, authorized, orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByA_A_First(
		long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_A_First(applicationId, authorized,
			orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByA_A_Last(
		long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByA_A_Last(applicationId, authorized, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByA_A_Last(
		long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_A_Last(applicationId, authorized, orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set where applicationId = &#63; and authorized = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] findByA_A_PrevAndNext(
		long oaauId, long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByA_A_PrevAndNext(oaauId, applicationId, authorized,
			orderByComparator);
	}

	/**
	* Returns all the o auth application users that the user has permission to view where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByA_A(
		long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByA_A(applicationId, authorized);
	}

	/**
	* Returns a range of all the o auth application users that the user has permission to view where applicationId = &#63; and authorized = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByA_A(
		long applicationId, boolean authorized, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByA_A(applicationId, authorized, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users that the user has permissions to view where applicationId = &#63; and authorized = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByA_A(
		long applicationId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByA_A(applicationId, authorized, start, end,
			orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where applicationId = &#63; and authorized = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByA_A_PrevAndNext(
		long oaauId, long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .filterFindByA_A_PrevAndNext(oaauId, applicationId,
			authorized, orderByComparator);
	}

	/**
	* Returns the o auth application user where userId = &#63; and applicationId = &#63; or throws a {@link com.liferay.portal.oauth.NoSuchApplicationUserException} if it could not be found.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @return the matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByU_AP(
		long userId, long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence().findByU_AP(userId, applicationId);
	}

	/**
	* Returns the o auth application user where userId = &#63; and applicationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @return the matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByU_AP(
		long userId, long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_AP(userId, applicationId);
	}

	/**
	* Returns the o auth application user where userId = &#63; and applicationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByU_AP(
		long userId, long applicationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_AP(userId, applicationId, retrieveFromCache);
	}

	/**
	* Returns all the o auth application users where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByU_AU(
		long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_AU(userId, authorized);
	}

	/**
	* Returns a range of all the o auth application users where userId = &#63; and authorized = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByU_AU(
		long userId, boolean authorized, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_AU(userId, authorized, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users where userId = &#63; and authorized = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByU_AU(
		long userId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_AU(userId, authorized, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByU_AU_First(
		long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByU_AU_First(userId, authorized, orderByComparator);
	}

	/**
	* Returns the first o auth application user in the ordered set where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByU_AU_First(
		long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_AU_First(userId, authorized, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser findByU_AU_Last(
		long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByU_AU_Last(userId, authorized, orderByComparator);
	}

	/**
	* Returns the last o auth application user in the ordered set where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser fetchByU_AU_Last(
		long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_AU_Last(userId, authorized, orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set where userId = &#63; and authorized = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param userId the user ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] findByU_AU_PrevAndNext(
		long oaauId, long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .findByU_AU_PrevAndNext(oaauId, userId, authorized,
			orderByComparator);
	}

	/**
	* Returns all the o auth application users that the user has permission to view where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByU_AU(
		long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByU_AU(userId, authorized);
	}

	/**
	* Returns a range of all the o auth application users that the user has permission to view where userId = &#63; and authorized = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @return the range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByU_AU(
		long userId, boolean authorized, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByU_AU(userId, authorized, start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users that the user has permissions to view where userId = &#63; and authorized = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByU_AU(
		long userId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByU_AU(userId, authorized, start, end,
			orderByComparator);
	}

	/**
	* Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where userId = &#63; and authorized = &#63;.
	*
	* @param oaauId the primary key of the current o auth application user
	* @param userId the user ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByU_AU_PrevAndNext(
		long oaauId, long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence()
				   .filterFindByU_AU_PrevAndNext(oaauId, userId, authorized,
			orderByComparator);
	}

	/**
	* Returns all the o auth application users.
	*
	* @return the o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the o auth application users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of o auth application users
	* @param end the upper bound of the range of o auth application users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the o auth application users where accessToken = &#63; from the database.
	*
	* @param accessToken the access token
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAccessToken(java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAccessToken(accessToken);
	}

	/**
	* Removes all the o auth application users where applicationId = &#63; from the database.
	*
	* @param applicationId the application ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByApplicationId(long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByApplicationId(applicationId);
	}

	/**
	* Removes all the o auth application users where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the o auth application users where applicationId = &#63; and authorized = &#63; from the database.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByA_A(long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByA_A(applicationId, authorized);
	}

	/**
	* Removes the o auth application user where userId = &#63; and applicationId = &#63; from the database.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @return the o auth application user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplicationUser removeByU_AP(
		long userId, long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException {
		return getPersistence().removeByU_AP(userId, applicationId);
	}

	/**
	* Removes all the o auth application users where userId = &#63; and authorized = &#63; from the database.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_AU(long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_AU(userId, authorized);
	}

	/**
	* Removes all the o auth application users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of o auth application users where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAccessToken(java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAccessToken(accessToken);
	}

	/**
	* Returns the number of o auth application users that the user has permission to view where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByAccessToken(java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByAccessToken(accessToken);
	}

	/**
	* Returns the number of o auth application users where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApplicationId(long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByApplicationId(applicationId);
	}

	/**
	* Returns the number of o auth application users that the user has permission to view where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByApplicationId(long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByApplicationId(applicationId);
	}

	/**
	* Returns the number of o auth application users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of o auth application users that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUserId(userId);
	}

	/**
	* Returns the number of o auth application users where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA_A(long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByA_A(applicationId, authorized);
	}

	/**
	* Returns the number of o auth application users that the user has permission to view where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByA_A(long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByA_A(applicationId, authorized);
	}

	/**
	* Returns the number of o auth application users where userId = &#63; and applicationId = &#63;.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_AP(long userId, long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_AP(userId, applicationId);
	}

	/**
	* Returns the number of o auth application users where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_AU(long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_AU(userId, authorized);
	}

	/**
	* Returns the number of o auth application users that the user has permission to view where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByU_AU(long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByU_AU(userId, authorized);
	}

	/**
	* Returns the number of o auth application users.
	*
	* @return the number of o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OAuthApplicationUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OAuthApplicationUserPersistence)PortletBeanLocatorUtil.locate(com.liferay.portal.oauth.service.ClpSerializer.getServletContextName(),
					OAuthApplicationUserPersistence.class.getName());

			ReferenceRegistry.registerReference(OAuthApplicationUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OAuthApplicationUserPersistence persistence) {
	}

	private static OAuthApplicationUserPersistence _persistence;
}