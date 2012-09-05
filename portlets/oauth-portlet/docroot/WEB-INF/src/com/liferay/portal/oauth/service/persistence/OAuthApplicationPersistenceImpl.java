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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.oauth.NoSuchApplicationException;
import com.liferay.portal.oauth.model.OAuthApplication;
import com.liferay.portal.oauth.model.impl.OAuthApplicationImpl;
import com.liferay.portal.oauth.model.impl.OAuthApplicationModelImpl;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the o auth application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplicationPersistence
 * @see OAuthApplicationUtil
 * @generated
 */
public class OAuthApplicationPersistenceImpl extends BasePersistenceImpl<OAuthApplication>
	implements OAuthApplicationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OAuthApplicationUtil} to access the o auth application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OAuthApplicationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			OAuthApplicationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_CONSUMERKEY = new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByConsumerKey", new String[] { String.class.getName() },
			OAuthApplicationModelImpl.CONSUMERKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONSUMERKEY = new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConsumerKey",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			OAuthApplicationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the o auth application in the entity cache if it is enabled.
	 *
	 * @param oAuthApplication the o auth application
	 */
	public void cacheResult(OAuthApplication oAuthApplication) {
		EntityCacheUtil.putResult(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationImpl.class, oAuthApplication.getPrimaryKey(),
			oAuthApplication);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
			new Object[] { oAuthApplication.getConsumerKey() }, oAuthApplication);

		oAuthApplication.resetOriginalValues();
	}

	/**
	 * Caches the o auth applications in the entity cache if it is enabled.
	 *
	 * @param oAuthApplications the o auth applications
	 */
	public void cacheResult(List<OAuthApplication> oAuthApplications) {
		for (OAuthApplication oAuthApplication : oAuthApplications) {
			if (EntityCacheUtil.getResult(
						OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
						OAuthApplicationImpl.class,
						oAuthApplication.getPrimaryKey()) == null) {
				cacheResult(oAuthApplication);
			}
			else {
				oAuthApplication.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all o auth applications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OAuthApplicationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OAuthApplicationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the o auth application.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OAuthApplication oAuthApplication) {
		EntityCacheUtil.removeResult(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationImpl.class, oAuthApplication.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(oAuthApplication);
	}

	@Override
	public void clearCache(List<OAuthApplication> oAuthApplications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OAuthApplication oAuthApplication : oAuthApplications) {
			EntityCacheUtil.removeResult(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
				OAuthApplicationImpl.class, oAuthApplication.getPrimaryKey());

			clearUniqueFindersCache(oAuthApplication);
		}
	}

	protected void clearUniqueFindersCache(OAuthApplication oAuthApplication) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
			new Object[] { oAuthApplication.getConsumerKey() });
	}

	/**
	 * Creates a new o auth application with the primary key. Does not add the o auth application to the database.
	 *
	 * @param applicationId the primary key for the new o auth application
	 * @return the new o auth application
	 */
	public OAuthApplication create(long applicationId) {
		OAuthApplication oAuthApplication = new OAuthApplicationImpl();

		oAuthApplication.setNew(true);
		oAuthApplication.setPrimaryKey(applicationId);

		return oAuthApplication;
	}

	/**
	 * Removes the o auth application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationId the primary key of the o auth application
	 * @return the o auth application that was removed
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication remove(long applicationId)
		throws NoSuchApplicationException, SystemException {
		return remove(Long.valueOf(applicationId));
	}

	/**
	 * Removes the o auth application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the o auth application
	 * @return the o auth application that was removed
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OAuthApplication remove(Serializable primaryKey)
		throws NoSuchApplicationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OAuthApplication oAuthApplication = (OAuthApplication)session.get(OAuthApplicationImpl.class,
					primaryKey);

			if (oAuthApplication == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(oAuthApplication);
		}
		catch (NoSuchApplicationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected OAuthApplication removeImpl(OAuthApplication oAuthApplication)
		throws SystemException {
		oAuthApplication = toUnwrappedModel(oAuthApplication);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, oAuthApplication);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(oAuthApplication);

		return oAuthApplication;
	}

	@Override
	public OAuthApplication updateImpl(
		com.liferay.portal.oauth.model.OAuthApplication oAuthApplication,
		boolean merge) throws SystemException {
		oAuthApplication = toUnwrappedModel(oAuthApplication);

		boolean isNew = oAuthApplication.isNew();

		OAuthApplicationModelImpl oAuthApplicationModelImpl = (OAuthApplicationModelImpl)oAuthApplication;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, oAuthApplication, merge);

			oAuthApplication.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OAuthApplicationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((oAuthApplicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(oAuthApplicationModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(oAuthApplicationModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((oAuthApplicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(oAuthApplicationModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(oAuthApplicationModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationImpl.class, oAuthApplication.getPrimaryKey(),
			oAuthApplication);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
				new Object[] { oAuthApplication.getConsumerKey() },
				oAuthApplication);
		}
		else {
			if ((oAuthApplicationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONSUMERKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						oAuthApplicationModelImpl.getOriginalConsumerKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSUMERKEY,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
					new Object[] { oAuthApplication.getConsumerKey() },
					oAuthApplication);
			}
		}

		return oAuthApplication;
	}

	protected OAuthApplication toUnwrappedModel(
		OAuthApplication oAuthApplication) {
		if (oAuthApplication instanceof OAuthApplicationImpl) {
			return oAuthApplication;
		}

		OAuthApplicationImpl oAuthApplicationImpl = new OAuthApplicationImpl();

		oAuthApplicationImpl.setNew(oAuthApplication.isNew());
		oAuthApplicationImpl.setPrimaryKey(oAuthApplication.getPrimaryKey());

		oAuthApplicationImpl.setApplicationId(oAuthApplication.getApplicationId());
		oAuthApplicationImpl.setCompanyId(oAuthApplication.getCompanyId());
		oAuthApplicationImpl.setUserId(oAuthApplication.getUserId());
		oAuthApplicationImpl.setUserName(oAuthApplication.getUserName());
		oAuthApplicationImpl.setCreateDate(oAuthApplication.getCreateDate());
		oAuthApplicationImpl.setModifiedDate(oAuthApplication.getModifiedDate());
		oAuthApplicationImpl.setName(oAuthApplication.getName());
		oAuthApplicationImpl.setDescription(oAuthApplication.getDescription());
		oAuthApplicationImpl.setWebsite(oAuthApplication.getWebsite());
		oAuthApplicationImpl.setCallBackURL(oAuthApplication.getCallBackURL());
		oAuthApplicationImpl.setAccessLevel(oAuthApplication.getAccessLevel());
		oAuthApplicationImpl.setConsumerKey(oAuthApplication.getConsumerKey());
		oAuthApplicationImpl.setConsumerSecret(oAuthApplication.getConsumerSecret());

		return oAuthApplicationImpl;
	}

	/**
	 * Returns the o auth application with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the o auth application
	 * @return the o auth application
	 * @throws com.liferay.portal.NoSuchModelException if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OAuthApplication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the o auth application with the primary key or throws a {@link com.liferay.portal.oauth.NoSuchApplicationException} if it could not be found.
	 *
	 * @param applicationId the primary key of the o auth application
	 * @return the o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication findByPrimaryKey(long applicationId)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = fetchByPrimaryKey(applicationId);

		if (oAuthApplication == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + applicationId);
			}

			throw new NoSuchApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				applicationId);
		}

		return oAuthApplication;
	}

	/**
	 * Returns the o auth application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the o auth application
	 * @return the o auth application, or <code>null</code> if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OAuthApplication fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the o auth application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationId the primary key of the o auth application
	 * @return the o auth application, or <code>null</code> if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication fetchByPrimaryKey(long applicationId)
		throws SystemException {
		OAuthApplication oAuthApplication = (OAuthApplication)EntityCacheUtil.getResult(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
				OAuthApplicationImpl.class, applicationId);

		if (oAuthApplication == _nullOAuthApplication) {
			return null;
		}

		if (oAuthApplication == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				oAuthApplication = (OAuthApplication)session.get(OAuthApplicationImpl.class,
						Long.valueOf(applicationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (oAuthApplication != null) {
					cacheResult(oAuthApplication);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OAuthApplicationModelImpl.ENTITY_CACHE_ENABLED,
						OAuthApplicationImpl.class, applicationId,
						_nullOAuthApplication);
				}

				closeSession(session);
			}
		}

		return oAuthApplication;
	}

	/**
	 * Returns all the o auth applications where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the o auth applications where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of o auth applications
	 * @param end the upper bound of the range of o auth applications (not inclusive)
	 * @return the range of matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the o auth applications where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of o auth applications
	 * @param end the upper bound of the range of o auth applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<OAuthApplication> list = (List<OAuthApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthApplication oAuthApplication : list) {
				if ((companyId != oAuthApplication.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_OAUTHAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<OAuthApplication>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first o auth application in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (oAuthApplication != null) {
			return oAuthApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationException(msg.toString());
	}

	/**
	 * Returns the first o auth application in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application, or <code>null</code> if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OAuthApplication> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last o auth application in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (oAuthApplication != null) {
			return oAuthApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationException(msg.toString());
	}

	/**
	 * Returns the last o auth application in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application, or <code>null</code> if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<OAuthApplication> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the o auth applications before and after the current o auth application in the ordered set where companyId = &#63;.
	 *
	 * @param applicationId the primary key of the current o auth application
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication[] findByCompanyId_PrevAndNext(long applicationId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = findByPrimaryKey(applicationId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplication[] array = new OAuthApplicationImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, oAuthApplication,
					companyId, orderByComparator, true);

			array[1] = oAuthApplication;

			array[2] = getByCompanyId_PrevAndNext(session, oAuthApplication,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplication getByCompanyId_PrevAndNext(Session session,
		OAuthApplication oAuthApplication, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHAPPLICATION_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth applications that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching o auth applications that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> filterFindByCompanyId(long companyId)
		throws SystemException {
		return filterFindByCompanyId(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the o auth applications that the user has permission to view where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of o auth applications
	 * @param end the upper bound of the range of o auth applications (not inclusive)
	 * @return the range of matching o auth applications that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> filterFindByCompanyId(long companyId,
		int start, int end) throws SystemException {
		return filterFindByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the o auth applications that the user has permissions to view where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of o auth applications
	 * @param end the upper bound of the range of o auth applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching o auth applications that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> filterFindByCompanyId(long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId(companyId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(2);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplication.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			return (List<OAuthApplication>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the o auth applications before and after the current o auth application in the ordered set of o auth applications that the user has permission to view where companyId = &#63;.
	 *
	 * @param applicationId the primary key of the current o auth application
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication[] filterFindByCompanyId_PrevAndNext(
		long applicationId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchApplicationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId_PrevAndNext(applicationId, companyId,
				orderByComparator);
		}

		OAuthApplication oAuthApplication = findByPrimaryKey(applicationId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplication[] array = new OAuthApplicationImpl[3];

			array[0] = filterGetByCompanyId_PrevAndNext(session,
					oAuthApplication, companyId, orderByComparator, true);

			array[1] = oAuthApplication;

			array[2] = filterGetByCompanyId_PrevAndNext(session,
					oAuthApplication, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplication filterGetByCompanyId_PrevAndNext(
		Session session, OAuthApplication oAuthApplication, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplication.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the o auth application where consumerKey = &#63; or throws a {@link com.liferay.portal.oauth.NoSuchApplicationException} if it could not be found.
	 *
	 * @param consumerKey the consumer key
	 * @return the matching o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication findByConsumerKey(String consumerKey)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = fetchByConsumerKey(consumerKey);

		if (oAuthApplication == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("consumerKey=");
			msg.append(consumerKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchApplicationException(msg.toString());
		}

		return oAuthApplication;
	}

	/**
	 * Returns the o auth application where consumerKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param consumerKey the consumer key
	 * @return the matching o auth application, or <code>null</code> if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication fetchByConsumerKey(String consumerKey)
		throws SystemException {
		return fetchByConsumerKey(consumerKey, true);
	}

	/**
	 * Returns the o auth application where consumerKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param consumerKey the consumer key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching o auth application, or <code>null</code> if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication fetchByConsumerKey(String consumerKey,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { consumerKey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
					finderArgs, this);
		}

		if (result instanceof OAuthApplication) {
			OAuthApplication oAuthApplication = (OAuthApplication)result;

			if (!Validator.equals(consumerKey, oAuthApplication.getConsumerKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_OAUTHAPPLICATION_WHERE);

			if (consumerKey == null) {
				query.append(_FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_1);
			}
			else {
				if (consumerKey.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (consumerKey != null) {
					qPos.add(consumerKey);
				}

				List<OAuthApplication> list = q.list();

				result = list;

				OAuthApplication oAuthApplication = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
						finderArgs, list);
				}
				else {
					oAuthApplication = list.get(0);

					cacheResult(oAuthApplication);

					if ((oAuthApplication.getConsumerKey() == null) ||
							!oAuthApplication.getConsumerKey()
												 .equals(consumerKey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
							finderArgs, oAuthApplication);
					}
				}

				return oAuthApplication;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONSUMERKEY,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (OAuthApplication)result;
			}
		}
	}

	/**
	 * Returns all the o auth applications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the o auth applications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of o auth applications
	 * @param end the upper bound of the range of o auth applications (not inclusive)
	 * @return the range of matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the o auth applications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of o auth applications
	 * @param end the upper bound of the range of o auth applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<OAuthApplication> list = (List<OAuthApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthApplication oAuthApplication : list) {
				if ((userId != oAuthApplication.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_OAUTHAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<OAuthApplication>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first o auth application in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = fetchByUserId_First(userId,
				orderByComparator);

		if (oAuthApplication != null) {
			return oAuthApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationException(msg.toString());
	}

	/**
	 * Returns the first o auth application in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application, or <code>null</code> if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OAuthApplication> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last o auth application in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = fetchByUserId_Last(userId,
				orderByComparator);

		if (oAuthApplication != null) {
			return oAuthApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationException(msg.toString());
	}

	/**
	 * Returns the last o auth application in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application, or <code>null</code> if a matching o auth application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<OAuthApplication> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the o auth applications before and after the current o auth application in the ordered set where userId = &#63;.
	 *
	 * @param applicationId the primary key of the current o auth application
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication[] findByUserId_PrevAndNext(long applicationId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = findByPrimaryKey(applicationId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplication[] array = new OAuthApplicationImpl[3];

			array[0] = getByUserId_PrevAndNext(session, oAuthApplication,
					userId, orderByComparator, true);

			array[1] = oAuthApplication;

			array[2] = getByUserId_PrevAndNext(session, oAuthApplication,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplication getByUserId_PrevAndNext(Session session,
		OAuthApplication oAuthApplication, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHAPPLICATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth applications that the user has permission to view where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching o auth applications that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> filterFindByUserId(long userId)
		throws SystemException {
		return filterFindByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the o auth applications that the user has permission to view where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of o auth applications
	 * @param end the upper bound of the range of o auth applications (not inclusive)
	 * @return the range of matching o auth applications that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> filterFindByUserId(long userId, int start,
		int end) throws SystemException {
		return filterFindByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the o auth applications that the user has permissions to view where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of o auth applications
	 * @param end the upper bound of the range of o auth applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching o auth applications that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> filterFindByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUserId(userId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(2);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplication.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			return (List<OAuthApplication>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the o auth applications before and after the current o auth application in the ordered set of o auth applications that the user has permission to view where userId = &#63;.
	 *
	 * @param applicationId the primary key of the current o auth application
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application
	 * @throws com.liferay.portal.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication[] filterFindByUserId_PrevAndNext(
		long applicationId, long userId, OrderByComparator orderByComparator)
		throws NoSuchApplicationException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUserId_PrevAndNext(applicationId, userId,
				orderByComparator);
		}

		OAuthApplication oAuthApplication = findByPrimaryKey(applicationId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplication[] array = new OAuthApplicationImpl[3];

			array[0] = filterGetByUserId_PrevAndNext(session, oAuthApplication,
					userId, orderByComparator, true);

			array[1] = oAuthApplication;

			array[2] = filterGetByUserId_PrevAndNext(session, oAuthApplication,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplication filterGetByUserId_PrevAndNext(Session session,
		OAuthApplication oAuthApplication, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplication.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth applications.
	 *
	 * @return the o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplication> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<OAuthApplication> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<OAuthApplication> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<OAuthApplication> list = (List<OAuthApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OAUTHAPPLICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OAUTHAPPLICATION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<OAuthApplication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OAuthApplication>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the o auth applications where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (OAuthApplication oAuthApplication : findByCompanyId(companyId)) {
			remove(oAuthApplication);
		}
	}

	/**
	 * Removes the o auth application where consumerKey = &#63; from the database.
	 *
	 * @param consumerKey the consumer key
	 * @return the o auth application that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplication removeByConsumerKey(String consumerKey)
		throws NoSuchApplicationException, SystemException {
		OAuthApplication oAuthApplication = findByConsumerKey(consumerKey);

		return remove(oAuthApplication);
	}

	/**
	 * Removes all the o auth applications where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (OAuthApplication oAuthApplication : findByUserId(userId)) {
			remove(oAuthApplication);
		}
	}

	/**
	 * Removes all the o auth applications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (OAuthApplication oAuthApplication : findAll()) {
			remove(oAuthApplication);
		}
	}

	/**
	 * Returns the number of o auth applications where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAUTHAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o auth applications that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching o auth applications that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCompanyId(long companyId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCompanyId(companyId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_OAUTHAPPLICATION_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplication.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of o auth applications where consumerKey = &#63;.
	 *
	 * @param consumerKey the consumer key
	 * @return the number of matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public int countByConsumerKey(String consumerKey) throws SystemException {
		Object[] finderArgs = new Object[] { consumerKey };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONSUMERKEY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAUTHAPPLICATION_WHERE);

			if (consumerKey == null) {
				query.append(_FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_1);
			}
			else {
				if (consumerKey.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (consumerKey != null) {
					qPos.add(consumerKey);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONSUMERKEY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o auth applications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAUTHAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o auth applications that the user has permission to view where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching o auth applications that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByUserId(long userId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByUserId(userId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_OAUTHAPPLICATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplication.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of o auth applications.
	 *
	 * @return the number of o auth applications
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OAUTHAPPLICATION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the o auth application persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portal.oauth.model.OAuthApplication")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OAuthApplication>> listenersList = new ArrayList<ModelListener<OAuthApplication>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OAuthApplication>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(OAuthApplicationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = OAuthApplicationPersistence.class)
	protected OAuthApplicationPersistence oAuthApplicationPersistence;
	@BeanReference(type = OAuthApplicationUserPersistence.class)
	protected OAuthApplicationUserPersistence oAuthApplicationUserPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_OAUTHAPPLICATION = "SELECT oAuthApplication FROM OAuthApplication oAuthApplication";
	private static final String _SQL_SELECT_OAUTHAPPLICATION_WHERE = "SELECT oAuthApplication FROM OAuthApplication oAuthApplication WHERE ";
	private static final String _SQL_COUNT_OAUTHAPPLICATION = "SELECT COUNT(oAuthApplication) FROM OAuthApplication oAuthApplication";
	private static final String _SQL_COUNT_OAUTHAPPLICATION_WHERE = "SELECT COUNT(oAuthApplication) FROM OAuthApplication oAuthApplication WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "oAuthApplication.companyId = ?";
	private static final String _FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_1 = "oAuthApplication.consumerKey IS NULL";
	private static final String _FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_2 = "oAuthApplication.consumerKey = ?";
	private static final String _FINDER_COLUMN_CONSUMERKEY_CONSUMERKEY_3 = "(oAuthApplication.consumerKey IS NULL OR oAuthApplication.consumerKey = ?)";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "oAuthApplication.userId = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "oAuthApplication.applicationId";
	private static final String _FILTER_SQL_SELECT_OAUTHAPPLICATION_WHERE = "SELECT DISTINCT {oAuthApplication.*} FROM OAuthApplication oAuthApplication WHERE ";
	private static final String _FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {OAuthApplication.*} FROM (SELECT DISTINCT oAuthApplication.applicationId FROM OAuthApplication oAuthApplication WHERE ";
	private static final String _FILTER_SQL_SELECT_OAUTHAPPLICATION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN OAuthApplication ON TEMP_TABLE.applicationId = OAuthApplication.applicationId";
	private static final String _FILTER_SQL_COUNT_OAUTHAPPLICATION_WHERE = "SELECT COUNT(DISTINCT oAuthApplication.applicationId) AS COUNT_VALUE FROM OAuthApplication oAuthApplication WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "oAuthApplication";
	private static final String _FILTER_ENTITY_TABLE = "OAuthApplication";
	private static final String _ORDER_BY_ENTITY_ALIAS = "oAuthApplication.";
	private static final String _ORDER_BY_ENTITY_TABLE = "OAuthApplication.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OAuthApplication exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OAuthApplication exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OAuthApplicationPersistenceImpl.class);
	private static OAuthApplication _nullOAuthApplication = new OAuthApplicationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OAuthApplication> toCacheModel() {
				return _nullOAuthApplicationCacheModel;
			}
		};

	private static CacheModel<OAuthApplication> _nullOAuthApplicationCacheModel = new CacheModel<OAuthApplication>() {
			public OAuthApplication toEntityModel() {
				return _nullOAuthApplication;
			}
		};
}