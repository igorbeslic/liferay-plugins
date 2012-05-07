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
import com.liferay.portal.oauth.model.OAuthApplication;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the o auth application service. This utility wraps {@link OAuthApplicationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplicationPersistence
 * @see OAuthApplicationPersistenceImpl
 * @generated
 */
public class OAuthApplicationUtil {
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
	public static void clearCache(OAuthApplication oAuthApplication) {
		getPersistence().clearCache(oAuthApplication);
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
	public static List<OAuthApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OAuthApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OAuthApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static OAuthApplication update(OAuthApplication oAuthApplication,
		boolean merge) throws SystemException {
		return getPersistence().update(oAuthApplication, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static OAuthApplication update(OAuthApplication oAuthApplication,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(oAuthApplication, merge, serviceContext);
	}

	/**
	* Caches the o auth application in the entity cache if it is enabled.
	*
	* @param oAuthApplication the o auth application
	*/
	public static void cacheResult(
		com.liferay.portal.oauth.model.OAuthApplication oAuthApplication) {
		getPersistence().cacheResult(oAuthApplication);
	}

	/**
	* Caches the o auth applications in the entity cache if it is enabled.
	*
	* @param oAuthApplications the o auth applications
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portal.oauth.model.OAuthApplication> oAuthApplications) {
		getPersistence().cacheResult(oAuthApplications);
	}

	/**
	* Creates a new o auth application with the primary key. Does not add the o auth application to the database.
	*
	* @param id the primary key for the new o auth application
	* @return the new o auth application
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the o auth application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the o auth application
	* @return the o auth application that was removed
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence().remove(id);
	}

	public static com.liferay.portal.oauth.model.OAuthApplication updateImpl(
		com.liferay.portal.oauth.model.OAuthApplication oAuthApplication,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(oAuthApplication, merge);
	}

	/**
	* Returns the o auth application with the primary key or throws a {@link com.liferay.portal.oauth.NoSuchApplicationException} if it could not be found.
	*
	* @param id the primary key of the o auth application
	* @return the o auth application
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the o auth application with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the o auth application
	* @return the o auth application, or <code>null</code> if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the o auth applications where name = &#63;.
	*
	* @param name the name
	* @return the matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name);
	}

	/**
	* Returns a range of all the o auth applications where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence().findByname_First(name, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence().findByname_Last(name, orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current o auth application
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication[] findByname_PrevAndNext(
		long id, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence()
				   .findByname_PrevAndNext(id, name, orderByComparator);
	}

	/**
	* Returns the o auth application where ownerId = &#63; or throws a {@link com.liferay.portal.oauth.NoSuchApplicationException} if it could not be found.
	*
	* @param ownerId the owner ID
	* @return the matching o auth application
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication findByownerId(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence().findByownerId(ownerId);
	}

	/**
	* Returns the o auth application where ownerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ownerId the owner ID
	* @return the matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication fetchByownerId(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByownerId(ownerId);
	}

	/**
	* Returns the o auth application where ownerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ownerId the owner ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication fetchByownerId(
		long ownerId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByownerId(ownerId, retrieveFromCache);
	}

	/**
	* Returns all the o auth applications where website = &#63;.
	*
	* @param website the website
	* @return the matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findBywebsite(
		java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBywebsite(website);
	}

	/**
	* Returns a range of all the o auth applications where website = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param website the website
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findBywebsite(
		java.lang.String website, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBywebsite(website, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications where website = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param website the website
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findBywebsite(
		java.lang.String website, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBywebsite(website, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where website = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication findBywebsite_First(
		java.lang.String website,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence().findBywebsite_First(website, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where website = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication findBywebsite_Last(
		java.lang.String website,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence().findBywebsite_Last(website, orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set where website = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current o auth application
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication[] findBywebsite_PrevAndNext(
		long id, java.lang.String website,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence()
				   .findBywebsite_PrevAndNext(id, website, orderByComparator);
	}

	/**
	* Returns all the o auth applications.
	*
	* @return the o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the o auth applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.oauth.model.OAuthApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the o auth applications where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByname(name);
	}

	/**
	* Removes the o auth application where ownerId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @return the o auth application that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.oauth.model.OAuthApplication removeByownerId(
		long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.oauth.NoSuchApplicationException {
		return getPersistence().removeByownerId(ownerId);
	}

	/**
	* Removes all the o auth applications where website = &#63; from the database.
	*
	* @param website the website
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBywebsite(java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBywebsite(website);
	}

	/**
	* Removes all the o auth applications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of o auth applications where name = &#63;.
	*
	* @param name the name
	* @return the number of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByname(name);
	}

	/**
	* Returns the number of o auth applications where ownerId = &#63;.
	*
	* @param ownerId the owner ID
	* @return the number of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByownerId(long ownerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByownerId(ownerId);
	}

	/**
	* Returns the number of o auth applications where website = &#63;.
	*
	* @param website the website
	* @return the number of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countBywebsite(java.lang.String website)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBywebsite(website);
	}

	/**
	* Returns the number of o auth applications.
	*
	* @return the number of o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OAuthApplicationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OAuthApplicationPersistence)PortletBeanLocatorUtil.locate(com.liferay.portal.oauth.service.ClpSerializer.getServletContextName(),
					OAuthApplicationPersistence.class.getName());

			ReferenceRegistry.registerReference(OAuthApplicationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OAuthApplicationPersistence persistence) {
	}

	private static OAuthApplicationPersistence _persistence;
}