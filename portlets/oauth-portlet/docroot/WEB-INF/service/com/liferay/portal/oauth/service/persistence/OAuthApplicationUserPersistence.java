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

import com.liferay.portal.oauth.model.OAuthApplicationUser;
import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the o auth application user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplicationUserPersistenceImpl
 * @see OAuthApplicationUserUtil
 * @generated
 */
public interface OAuthApplicationUserPersistence extends BasePersistence<OAuthApplicationUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OAuthApplicationUserUtil} to access the o auth application user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the o auth application user in the entity cache if it is enabled.
	*
	* @param oAuthApplicationUser the o auth application user
	*/
	public void cacheResult(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser);

	/**
	* Caches the o auth application users in the entity cache if it is enabled.
	*
	* @param oAuthApplicationUsers the o auth application users
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> oAuthApplicationUsers);

	/**
	* Creates a new o auth application user with the primary key. Does not add the o auth application user to the database.
	*
	* @param oaauId the primary key for the new o auth application user
	* @return the new o auth application user
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser create(
		long oaauId);

	/**
	* Removes the o auth application user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oaauId the primary key of the o auth application user
	* @return the o auth application user that was removed
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser remove(
		long oaauId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	public com.liferay.portal.oauth.model.OAuthApplicationUser updateImpl(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the o auth application user with the primary key or throws a {@link com.liferay.portal.oauth.NoSuchApplicationUserException} if it could not be found.
	*
	* @param oaauId the primary key of the o auth application user
	* @return the o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByPrimaryKey(
		long oaauId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the o auth application user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param oaauId the primary key of the o auth application user
	* @return the o auth application user, or <code>null</code> if a o auth application user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByPrimaryKey(
		long oaauId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the o auth application users where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByAccessToken(
		java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByAccessToken(
		java.lang.String accessToken, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByAccessToken(
		java.lang.String accessToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByAccessToken_First(
		java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the first o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByAccessToken_First(
		java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByAccessToken_Last(
		java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the last o auth application user in the ordered set where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByAccessToken_Last(
		java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] findByAccessToken_PrevAndNext(
		long oaauId, java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users that the user has permission to view where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByAccessToken(
		java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByAccessToken(
		java.lang.String accessToken, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByAccessToken(
		java.lang.String accessToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByAccessToken_PrevAndNext(
		long oaauId, java.lang.String accessToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByApplicationId(
		long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByApplicationId(
		long applicationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByApplicationId(
		long applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByApplicationId_First(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the first o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByApplicationId_First(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByApplicationId_Last(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the last o auth application user in the ordered set where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByApplicationId_Last(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] findByApplicationId_PrevAndNext(
		long oaauId, long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users that the user has permission to view where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByApplicationId(
		long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByApplicationId(
		long applicationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByApplicationId(
		long applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByApplicationId_PrevAndNext(
		long oaauId, long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first o auth application user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the first o auth application user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last o auth application user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the last o auth application user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] findByUserId_PrevAndNext(
		long oaauId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByUserId_PrevAndNext(
		long oaauId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByA_A(
		long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByA_A(
		long applicationId, boolean authorized, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByA_A(
		long applicationId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByA_A_First(
		long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the first o auth application user in the ordered set where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByA_A_First(
		long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByA_A_Last(
		long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the last o auth application user in the ordered set where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByA_A_Last(
		long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] findByA_A_PrevAndNext(
		long oaauId, long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users that the user has permission to view where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByA_A(
		long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByA_A(
		long applicationId, boolean authorized, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByA_A(
		long applicationId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByA_A_PrevAndNext(
		long oaauId, long applicationId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the o auth application user where userId = &#63; and applicationId = &#63; or throws a {@link com.liferay.portal.oauth.NoSuchApplicationUserException} if it could not be found.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @return the matching o auth application user
	* @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByU_AP(
		long userId, long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the o auth application user where userId = &#63; and applicationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @return the matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByU_AP(
		long userId, long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the o auth application user where userId = &#63; and applicationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByU_AP(
		long userId, long applicationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the o auth application users where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @return the matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByU_AU(
		long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByU_AU(
		long userId, boolean authorized, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findByU_AU(
		long userId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByU_AU_First(
		long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the first o auth application user in the ordered set where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByU_AU_First(
		long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser findByU_AU_Last(
		long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns the last o auth application user in the ordered set where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser fetchByU_AU_Last(
		long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] findByU_AU_PrevAndNext(
		long oaauId, long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users that the user has permission to view where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @return the matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByU_AU(
		long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByU_AU(
		long userId, boolean authorized, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> filterFindByU_AU(
		long userId, boolean authorized, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portal.oauth.model.OAuthApplicationUser[] filterFindByU_AU_PrevAndNext(
		long oaauId, long userId, boolean authorized,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Returns all the o auth application users.
	*
	* @return the o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portal.oauth.model.OAuthApplicationUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the o auth application users where accessToken = &#63; from the database.
	*
	* @param accessToken the access token
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAccessToken(java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the o auth application users where applicationId = &#63; from the database.
	*
	* @param applicationId the application ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApplicationId(long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the o auth application users where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the o auth application users where applicationId = &#63; and authorized = &#63; from the database.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @throws SystemException if a system exception occurred
	*/
	public void removeByA_A(long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the o auth application user where userId = &#63; and applicationId = &#63; from the database.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @return the o auth application user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.oauth.model.OAuthApplicationUser removeByU_AP(
		long userId, long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationUserException;

	/**
	* Removes all the o auth application users where userId = &#63; and authorized = &#63; from the database.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_AU(long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the o auth application users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public int countByAccessToken(java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users that the user has permission to view where accessToken = &#63;.
	*
	* @param accessToken the access token
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByAccessToken(java.lang.String accessToken)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public int countByApplicationId(long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users that the user has permission to view where applicationId = &#63;.
	*
	* @param applicationId the application ID
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByApplicationId(long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_A(long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users that the user has permission to view where applicationId = &#63; and authorized = &#63;.
	*
	* @param applicationId the application ID
	* @param authorized the authorized
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByA_A(long applicationId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users where userId = &#63; and applicationId = &#63;.
	*
	* @param userId the user ID
	* @param applicationId the application ID
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_AP(long userId, long applicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @return the number of matching o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_AU(long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users that the user has permission to view where userId = &#63; and authorized = &#63;.
	*
	* @param userId the user ID
	* @param authorized the authorized
	* @return the number of matching o auth application users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByU_AU(long userId, boolean authorized)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of o auth application users.
	*
	* @return the number of o auth application users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}