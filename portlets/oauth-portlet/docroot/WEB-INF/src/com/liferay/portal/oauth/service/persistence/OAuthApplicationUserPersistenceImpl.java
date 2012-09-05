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
import com.liferay.portal.oauth.NoSuchApplicationUserException;
import com.liferay.portal.oauth.model.OAuthApplicationUser;
import com.liferay.portal.oauth.model.impl.OAuthApplicationUserImpl;
import com.liferay.portal.oauth.model.impl.OAuthApplicationUserModelImpl;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the o auth application user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthApplicationUserPersistence
 * @see OAuthApplicationUserUtil
 * @generated
 */
public class OAuthApplicationUserPersistenceImpl extends BasePersistenceImpl<OAuthApplicationUser>
	implements OAuthApplicationUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OAuthApplicationUserUtil} to access the o auth application user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OAuthApplicationUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACCESSTOKEN =
		new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccessToken",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCESSTOKEN =
		new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAccessToken",
			new String[] { String.class.getName() },
			OAuthApplicationUserModelImpl.ACCESSTOKEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACCESSTOKEN = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAccessToken",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONID =
		new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicationId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID =
		new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApplicationId",
			new String[] { Long.class.getName() },
			OAuthApplicationUserModelImpl.APPLICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONID = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApplicationId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			OAuthApplicationUserModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			OAuthApplicationUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A_A = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByA_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_A = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA_A",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			OAuthApplicationUserModelImpl.APPLICATIONID_COLUMN_BITMASK |
			OAuthApplicationUserModelImpl.AUTHORIZED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_A = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_A",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_U_AP = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByU_AP",
			new String[] { Long.class.getName(), Long.class.getName() },
			OAuthApplicationUserModelImpl.USERID_COLUMN_BITMASK |
			OAuthApplicationUserModelImpl.APPLICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_AP = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_AP",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_AU = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_AU",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AU = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_AU",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			OAuthApplicationUserModelImpl.USERID_COLUMN_BITMASK |
			OAuthApplicationUserModelImpl.AUTHORIZED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_AU = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_AU",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the o auth application user in the entity cache if it is enabled.
	 *
	 * @param oAuthApplicationUser the o auth application user
	 */
	public void cacheResult(OAuthApplicationUser oAuthApplicationUser) {
		EntityCacheUtil.putResult(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			oAuthApplicationUser.getPrimaryKey(), oAuthApplicationUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AP,
			new Object[] {
				Long.valueOf(oAuthApplicationUser.getUserId()),
				Long.valueOf(oAuthApplicationUser.getApplicationId())
			}, oAuthApplicationUser);

		oAuthApplicationUser.resetOriginalValues();
	}

	/**
	 * Caches the o auth application users in the entity cache if it is enabled.
	 *
	 * @param oAuthApplicationUsers the o auth application users
	 */
	public void cacheResult(List<OAuthApplicationUser> oAuthApplicationUsers) {
		for (OAuthApplicationUser oAuthApplicationUser : oAuthApplicationUsers) {
			if (EntityCacheUtil.getResult(
						OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
						OAuthApplicationUserImpl.class,
						oAuthApplicationUser.getPrimaryKey()) == null) {
				cacheResult(oAuthApplicationUser);
			}
			else {
				oAuthApplicationUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all o auth application users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OAuthApplicationUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OAuthApplicationUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the o auth application user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OAuthApplicationUser oAuthApplicationUser) {
		EntityCacheUtil.removeResult(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserImpl.class, oAuthApplicationUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(oAuthApplicationUser);
	}

	@Override
	public void clearCache(List<OAuthApplicationUser> oAuthApplicationUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OAuthApplicationUser oAuthApplicationUser : oAuthApplicationUsers) {
			EntityCacheUtil.removeResult(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
				OAuthApplicationUserImpl.class,
				oAuthApplicationUser.getPrimaryKey());

			clearUniqueFindersCache(oAuthApplicationUser);
		}
	}

	protected void clearUniqueFindersCache(
		OAuthApplicationUser oAuthApplicationUser) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_AP,
			new Object[] {
				Long.valueOf(oAuthApplicationUser.getUserId()),
				Long.valueOf(oAuthApplicationUser.getApplicationId())
			});
	}

	/**
	 * Creates a new o auth application user with the primary key. Does not add the o auth application user to the database.
	 *
	 * @param oaauId the primary key for the new o auth application user
	 * @return the new o auth application user
	 */
	public OAuthApplicationUser create(long oaauId) {
		OAuthApplicationUser oAuthApplicationUser = new OAuthApplicationUserImpl();

		oAuthApplicationUser.setNew(true);
		oAuthApplicationUser.setPrimaryKey(oaauId);

		return oAuthApplicationUser;
	}

	/**
	 * Removes the o auth application user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaauId the primary key of the o auth application user
	 * @return the o auth application user that was removed
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser remove(long oaauId)
		throws NoSuchApplicationUserException, SystemException {
		return remove(Long.valueOf(oaauId));
	}

	/**
	 * Removes the o auth application user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the o auth application user
	 * @return the o auth application user that was removed
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OAuthApplicationUser remove(Serializable primaryKey)
		throws NoSuchApplicationUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser oAuthApplicationUser = (OAuthApplicationUser)session.get(OAuthApplicationUserImpl.class,
					primaryKey);

			if (oAuthApplicationUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(oAuthApplicationUser);
		}
		catch (NoSuchApplicationUserException nsee) {
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
	protected OAuthApplicationUser removeImpl(
		OAuthApplicationUser oAuthApplicationUser) throws SystemException {
		oAuthApplicationUser = toUnwrappedModel(oAuthApplicationUser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, oAuthApplicationUser);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(oAuthApplicationUser);

		return oAuthApplicationUser;
	}

	@Override
	public OAuthApplicationUser updateImpl(
		com.liferay.portal.oauth.model.OAuthApplicationUser oAuthApplicationUser,
		boolean merge) throws SystemException {
		oAuthApplicationUser = toUnwrappedModel(oAuthApplicationUser);

		boolean isNew = oAuthApplicationUser.isNew();

		OAuthApplicationUserModelImpl oAuthApplicationUserModelImpl = (OAuthApplicationUserModelImpl)oAuthApplicationUser;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, oAuthApplicationUser, merge);

			oAuthApplicationUser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OAuthApplicationUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((oAuthApplicationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCESSTOKEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						oAuthApplicationUserModelImpl.getOriginalAccessToken()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACCESSTOKEN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCESSTOKEN,
					args);

				args = new Object[] {
						oAuthApplicationUserModelImpl.getAccessToken()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACCESSTOKEN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCESSTOKEN,
					args);
			}

			if ((oAuthApplicationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getOriginalApplicationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID,
					args);

				args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getApplicationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID,
					args);
			}

			if ((oAuthApplicationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((oAuthApplicationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((oAuthApplicationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getOriginalApplicationId()),
						Boolean.valueOf(oAuthApplicationUserModelImpl.getOriginalAuthorized())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_A,
					args);

				args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getApplicationId()),
						Boolean.valueOf(oAuthApplicationUserModelImpl.getAuthorized())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_A,
					args);
			}

			if ((oAuthApplicationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getOriginalUserId()),
						Boolean.valueOf(oAuthApplicationUserModelImpl.getOriginalAuthorized())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_AU, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AU,
					args);

				args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getUserId()),
						Boolean.valueOf(oAuthApplicationUserModelImpl.getAuthorized())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_AU, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AU,
					args);
			}
		}

		EntityCacheUtil.putResult(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
			OAuthApplicationUserImpl.class,
			oAuthApplicationUser.getPrimaryKey(), oAuthApplicationUser);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AP,
				new Object[] {
					Long.valueOf(oAuthApplicationUser.getUserId()),
					Long.valueOf(oAuthApplicationUser.getApplicationId())
				}, oAuthApplicationUser);
		}
		else {
			if ((oAuthApplicationUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_U_AP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(oAuthApplicationUserModelImpl.getOriginalUserId()),
						Long.valueOf(oAuthApplicationUserModelImpl.getOriginalApplicationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_AP, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_AP, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AP,
					new Object[] {
						Long.valueOf(oAuthApplicationUser.getUserId()),
						Long.valueOf(oAuthApplicationUser.getApplicationId())
					}, oAuthApplicationUser);
			}
		}

		return oAuthApplicationUser;
	}

	protected OAuthApplicationUser toUnwrappedModel(
		OAuthApplicationUser oAuthApplicationUser) {
		if (oAuthApplicationUser instanceof OAuthApplicationUserImpl) {
			return oAuthApplicationUser;
		}

		OAuthApplicationUserImpl oAuthApplicationUserImpl = new OAuthApplicationUserImpl();

		oAuthApplicationUserImpl.setNew(oAuthApplicationUser.isNew());
		oAuthApplicationUserImpl.setPrimaryKey(oAuthApplicationUser.getPrimaryKey());

		oAuthApplicationUserImpl.setOaauId(oAuthApplicationUser.getOaauId());
		oAuthApplicationUserImpl.setCompanyId(oAuthApplicationUser.getCompanyId());
		oAuthApplicationUserImpl.setUserId(oAuthApplicationUser.getUserId());
		oAuthApplicationUserImpl.setUserName(oAuthApplicationUser.getUserName());
		oAuthApplicationUserImpl.setCreateDate(oAuthApplicationUser.getCreateDate());
		oAuthApplicationUserImpl.setModifiedDate(oAuthApplicationUser.getModifiedDate());
		oAuthApplicationUserImpl.setApplicationId(oAuthApplicationUser.getApplicationId());
		oAuthApplicationUserImpl.setAccessToken(oAuthApplicationUser.getAccessToken());
		oAuthApplicationUserImpl.setAccessSecret(oAuthApplicationUser.getAccessSecret());
		oAuthApplicationUserImpl.setAuthorized(oAuthApplicationUser.isAuthorized());

		return oAuthApplicationUserImpl;
	}

	/**
	 * Returns the o auth application user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the o auth application user
	 * @return the o auth application user
	 * @throws com.liferay.portal.NoSuchModelException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OAuthApplicationUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the o auth application user with the primary key or throws a {@link com.liferay.portal.oauth.NoSuchApplicationUserException} if it could not be found.
	 *
	 * @param oaauId the primary key of the o auth application user
	 * @return the o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser findByPrimaryKey(long oaauId)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByPrimaryKey(oaauId);

		if (oAuthApplicationUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + oaauId);
			}

			throw new NoSuchApplicationUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				oaauId);
		}

		return oAuthApplicationUser;
	}

	/**
	 * Returns the o auth application user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the o auth application user
	 * @return the o auth application user, or <code>null</code> if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OAuthApplicationUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the o auth application user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaauId the primary key of the o auth application user
	 * @return the o auth application user, or <code>null</code> if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByPrimaryKey(long oaauId)
		throws SystemException {
		OAuthApplicationUser oAuthApplicationUser = (OAuthApplicationUser)EntityCacheUtil.getResult(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
				OAuthApplicationUserImpl.class, oaauId);

		if (oAuthApplicationUser == _nullOAuthApplicationUser) {
			return null;
		}

		if (oAuthApplicationUser == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				oAuthApplicationUser = (OAuthApplicationUser)session.get(OAuthApplicationUserImpl.class,
						Long.valueOf(oaauId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (oAuthApplicationUser != null) {
					cacheResult(oAuthApplicationUser);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OAuthApplicationUserModelImpl.ENTITY_CACHE_ENABLED,
						OAuthApplicationUserImpl.class, oaauId,
						_nullOAuthApplicationUser);
				}

				closeSession(session);
			}
		}

		return oAuthApplicationUser;
	}

	/**
	 * Returns all the o auth application users where accessToken = &#63;.
	 *
	 * @param accessToken the access token
	 * @return the matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findByAccessToken(String accessToken)
		throws SystemException {
		return findByAccessToken(accessToken, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> findByAccessToken(String accessToken,
		int start, int end) throws SystemException {
		return findByAccessToken(accessToken, start, end, null);
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
	public List<OAuthApplicationUser> findByAccessToken(String accessToken,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCESSTOKEN;
			finderArgs = new Object[] { accessToken };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACCESSTOKEN;
			finderArgs = new Object[] { accessToken, start, end, orderByComparator };
		}

		List<OAuthApplicationUser> list = (List<OAuthApplicationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthApplicationUser oAuthApplicationUser : list) {
				if (!Validator.equals(accessToken,
							oAuthApplicationUser.getAccessToken())) {
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

			query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

			if (accessToken == null) {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_1);
			}
			else {
				if (accessToken.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_2);
				}
			}

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

				if (accessToken != null) {
					qPos.add(accessToken);
				}

				list = (List<OAuthApplicationUser>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first o auth application user in the ordered set where accessToken = &#63;.
	 *
	 * @param accessToken the access token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser findByAccessToken_First(String accessToken,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByAccessToken_First(accessToken,
				orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accessToken=");
		msg.append(accessToken);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
	}

	/**
	 * Returns the first o auth application user in the ordered set where accessToken = &#63;.
	 *
	 * @param accessToken the access token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByAccessToken_First(String accessToken,
		OrderByComparator orderByComparator) throws SystemException {
		List<OAuthApplicationUser> list = findByAccessToken(accessToken, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser findByAccessToken_Last(String accessToken,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByAccessToken_Last(accessToken,
				orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accessToken=");
		msg.append(accessToken);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
	}

	/**
	 * Returns the last o auth application user in the ordered set where accessToken = &#63;.
	 *
	 * @param accessToken the access token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByAccessToken_Last(String accessToken,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAccessToken(accessToken);

		List<OAuthApplicationUser> list = findByAccessToken(accessToken,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser[] findByAccessToken_PrevAndNext(long oaauId,
		String accessToken, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = getByAccessToken_PrevAndNext(session,
					oAuthApplicationUser, accessToken, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = getByAccessToken_PrevAndNext(session,
					oAuthApplicationUser, accessToken, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser getByAccessToken_PrevAndNext(
		Session session, OAuthApplicationUser oAuthApplicationUser,
		String accessToken, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

		if (accessToken == null) {
			query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_1);
		}
		else {
			if (accessToken.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_3);
			}
			else {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_2);
			}
		}

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

		if (accessToken != null) {
			qPos.add(accessToken);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users that the user has permission to view where accessToken = &#63;.
	 *
	 * @param accessToken the access token
	 * @return the matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> filterFindByAccessToken(
		String accessToken) throws SystemException {
		return filterFindByAccessToken(accessToken, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> filterFindByAccessToken(
		String accessToken, int start, int end) throws SystemException {
		return filterFindByAccessToken(accessToken, start, end, null);
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
	public List<OAuthApplicationUser> filterFindByAccessToken(
		String accessToken, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByAccessToken(accessToken, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (accessToken == null) {
			query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_1);
		}
		else {
			if (accessToken.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_3);
			}
			else {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (accessToken != null) {
				qPos.add(accessToken);
			}

			return (List<OAuthApplicationUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where accessToken = &#63;.
	 *
	 * @param oaauId the primary key of the current o auth application user
	 * @param accessToken the access token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser[] filterFindByAccessToken_PrevAndNext(
		long oaauId, String accessToken, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByAccessToken_PrevAndNext(oaauId, accessToken,
				orderByComparator);
		}

		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = filterGetByAccessToken_PrevAndNext(session,
					oAuthApplicationUser, accessToken, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = filterGetByAccessToken_PrevAndNext(session,
					oAuthApplicationUser, accessToken, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser filterGetByAccessToken_PrevAndNext(
		Session session, OAuthApplicationUser oAuthApplicationUser,
		String accessToken, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (accessToken == null) {
			query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_1);
		}
		else {
			if (accessToken.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_3);
			}
			else {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (accessToken != null) {
			qPos.add(accessToken);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findByApplicationId(long applicationId)
		throws SystemException {
		return findByApplicationId(applicationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> findByApplicationId(long applicationId,
		int start, int end) throws SystemException {
		return findByApplicationId(applicationId, start, end, null);
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
	public List<OAuthApplicationUser> findByApplicationId(long applicationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID;
			finderArgs = new Object[] { applicationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONID;
			finderArgs = new Object[] {
					applicationId,
					
					start, end, orderByComparator
				};
		}

		List<OAuthApplicationUser> list = (List<OAuthApplicationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthApplicationUser oAuthApplicationUser : list) {
				if ((applicationId != oAuthApplicationUser.getApplicationId())) {
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

			query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

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

				qPos.add(applicationId);

				list = (List<OAuthApplicationUser>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first o auth application user in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser findByApplicationId_First(long applicationId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByApplicationId_First(applicationId,
				orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationId=");
		msg.append(applicationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
	}

	/**
	 * Returns the first o auth application user in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByApplicationId_First(long applicationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OAuthApplicationUser> list = findByApplicationId(applicationId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser findByApplicationId_Last(long applicationId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByApplicationId_Last(applicationId,
				orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationId=");
		msg.append(applicationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
	}

	/**
	 * Returns the last o auth application user in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByApplicationId_Last(long applicationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByApplicationId(applicationId);

		List<OAuthApplicationUser> list = findByApplicationId(applicationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser[] findByApplicationId_PrevAndNext(long oaauId,
		long applicationId, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = getByApplicationId_PrevAndNext(session,
					oAuthApplicationUser, applicationId, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = getByApplicationId_PrevAndNext(session,
					oAuthApplicationUser, applicationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser getByApplicationId_PrevAndNext(
		Session session, OAuthApplicationUser oAuthApplicationUser,
		long applicationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

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

		qPos.add(applicationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users that the user has permission to view where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> filterFindByApplicationId(
		long applicationId) throws SystemException {
		return filterFindByApplicationId(applicationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> filterFindByApplicationId(
		long applicationId, int start, int end) throws SystemException {
		return filterFindByApplicationId(applicationId, start, end, null);
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
	public List<OAuthApplicationUser> filterFindByApplicationId(
		long applicationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByApplicationId(applicationId, start, end,
				orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(applicationId);

			return (List<OAuthApplicationUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where applicationId = &#63;.
	 *
	 * @param oaauId the primary key of the current o auth application user
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser[] filterFindByApplicationId_PrevAndNext(
		long oaauId, long applicationId, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByApplicationId_PrevAndNext(oaauId, applicationId,
				orderByComparator);
		}

		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = filterGetByApplicationId_PrevAndNext(session,
					oAuthApplicationUser, applicationId, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = filterGetByApplicationId_PrevAndNext(session,
					oAuthApplicationUser, applicationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser filterGetByApplicationId_PrevAndNext(
		Session session, OAuthApplicationUser oAuthApplicationUser,
		long applicationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the o auth application users where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of o auth application users
	 * @param end the upper bound of the range of o auth application users (not inclusive)
	 * @return the range of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findByCompanyId(long companyId,
		int start, int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the o auth application users where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of o auth application users
	 * @param end the upper bound of the range of o auth application users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findByCompanyId(long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<OAuthApplicationUser> list = (List<OAuthApplicationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthApplicationUser oAuthApplicationUser : list) {
				if ((companyId != oAuthApplicationUser.getCompanyId())) {
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

			query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

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

				list = (List<OAuthApplicationUser>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first o auth application user in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
	}

	/**
	 * Returns the first o auth application user in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OAuthApplicationUser> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last o auth application user in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
	}

	/**
	 * Returns the last o auth application user in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<OAuthApplicationUser> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the o auth application users before and after the current o auth application user in the ordered set where companyId = &#63;.
	 *
	 * @param oaauId the primary key of the current o auth application user
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser[] findByCompanyId_PrevAndNext(long oaauId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session,
					oAuthApplicationUser, companyId, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = getByCompanyId_PrevAndNext(session,
					oAuthApplicationUser, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser getByCompanyId_PrevAndNext(Session session,
		OAuthApplicationUser oAuthApplicationUser, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> filterFindByCompanyId(long companyId)
		throws SystemException {
		return filterFindByCompanyId(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the o auth application users that the user has permission to view where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of o auth application users
	 * @param end the upper bound of the range of o auth application users (not inclusive)
	 * @return the range of matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> filterFindByCompanyId(long companyId,
		int start, int end) throws SystemException {
		return filterFindByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the o auth application users that the user has permissions to view where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of o auth application users
	 * @param end the upper bound of the range of o auth application users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> filterFindByCompanyId(long companyId,
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
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			return (List<OAuthApplicationUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where companyId = &#63;.
	 *
	 * @param oaauId the primary key of the current o auth application user
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser[] filterFindByCompanyId_PrevAndNext(
		long oaauId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId_PrevAndNext(oaauId, companyId,
				orderByComparator);
		}

		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = filterGetByCompanyId_PrevAndNext(session,
					oAuthApplicationUser, companyId, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = filterGetByCompanyId_PrevAndNext(session,
					oAuthApplicationUser, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser filterGetByCompanyId_PrevAndNext(
		Session session, OAuthApplicationUser oAuthApplicationUser,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> findByUserId(long userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
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
	public List<OAuthApplicationUser> findByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<OAuthApplicationUser> list = (List<OAuthApplicationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthApplicationUser oAuthApplicationUser : list) {
				if ((userId != oAuthApplicationUser.getUserId())) {
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

			query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

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

				list = (List<OAuthApplicationUser>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first o auth application user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByUserId_First(userId,
				orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
	}

	/**
	 * Returns the first o auth application user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OAuthApplicationUser> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByUserId_Last(userId,
				orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
	}

	/**
	 * Returns the last o auth application user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<OAuthApplicationUser> list = findByUserId(userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser[] findByUserId_PrevAndNext(long oaauId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = getByUserId_PrevAndNext(session, oAuthApplicationUser,
					userId, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = getByUserId_PrevAndNext(session, oAuthApplicationUser,
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

	protected OAuthApplicationUser getByUserId_PrevAndNext(Session session,
		OAuthApplicationUser oAuthApplicationUser, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users that the user has permission to view where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> filterFindByUserId(long userId)
		throws SystemException {
		return filterFindByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<OAuthApplicationUser> filterFindByUserId(long userId,
		int start, int end) throws SystemException {
		return filterFindByUserId(userId, start, end, null);
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
	public List<OAuthApplicationUser> filterFindByUserId(long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			return (List<OAuthApplicationUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the o auth application users before and after the current o auth application user in the ordered set of o auth application users that the user has permission to view where userId = &#63;.
	 *
	 * @param oaauId the primary key of the current o auth application user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a o auth application user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser[] filterFindByUserId_PrevAndNext(long oaauId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUserId_PrevAndNext(oaauId, userId, orderByComparator);
		}

		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = filterGetByUserId_PrevAndNext(session,
					oAuthApplicationUser, userId, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = filterGetByUserId_PrevAndNext(session,
					oAuthApplicationUser, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser filterGetByUserId_PrevAndNext(
		Session session, OAuthApplicationUser oAuthApplicationUser,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users where applicationId = &#63; and authorized = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param authorized the authorized
	 * @return the matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findByA_A(long applicationId,
		boolean authorized) throws SystemException {
		return findByA_A(applicationId, authorized, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> findByA_A(long applicationId,
		boolean authorized, int start, int end) throws SystemException {
		return findByA_A(applicationId, authorized, start, end, null);
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
	public List<OAuthApplicationUser> findByA_A(long applicationId,
		boolean authorized, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_A;
			finderArgs = new Object[] { applicationId, authorized };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A_A;
			finderArgs = new Object[] {
					applicationId, authorized,
					
					start, end, orderByComparator
				};
		}

		List<OAuthApplicationUser> list = (List<OAuthApplicationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthApplicationUser oAuthApplicationUser : list) {
				if ((applicationId != oAuthApplicationUser.getApplicationId()) ||
						(authorized != oAuthApplicationUser.getAuthorized())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_A_A_APPLICATIONID_2);

			query.append(_FINDER_COLUMN_A_A_AUTHORIZED_2);

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

				qPos.add(applicationId);

				qPos.add(authorized);

				list = (List<OAuthApplicationUser>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first o auth application user in the ordered set where applicationId = &#63; and authorized = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param authorized the authorized
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser findByA_A_First(long applicationId,
		boolean authorized, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByA_A_First(applicationId,
				authorized, orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationId=");
		msg.append(applicationId);

		msg.append(", authorized=");
		msg.append(authorized);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
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
	public OAuthApplicationUser fetchByA_A_First(long applicationId,
		boolean authorized, OrderByComparator orderByComparator)
		throws SystemException {
		List<OAuthApplicationUser> list = findByA_A(applicationId, authorized,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser findByA_A_Last(long applicationId,
		boolean authorized, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByA_A_Last(applicationId,
				authorized, orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationId=");
		msg.append(applicationId);

		msg.append(", authorized=");
		msg.append(authorized);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
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
	public OAuthApplicationUser fetchByA_A_Last(long applicationId,
		boolean authorized, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByA_A(applicationId, authorized);

		List<OAuthApplicationUser> list = findByA_A(applicationId, authorized,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser[] findByA_A_PrevAndNext(long oaauId,
		long applicationId, boolean authorized,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = getByA_A_PrevAndNext(session, oAuthApplicationUser,
					applicationId, authorized, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = getByA_A_PrevAndNext(session, oAuthApplicationUser,
					applicationId, authorized, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser getByA_A_PrevAndNext(Session session,
		OAuthApplicationUser oAuthApplicationUser, long applicationId,
		boolean authorized, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_A_A_APPLICATIONID_2);

		query.append(_FINDER_COLUMN_A_A_AUTHORIZED_2);

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

		qPos.add(applicationId);

		qPos.add(authorized);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users that the user has permission to view where applicationId = &#63; and authorized = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param authorized the authorized
	 * @return the matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> filterFindByA_A(long applicationId,
		boolean authorized) throws SystemException {
		return filterFindByA_A(applicationId, authorized, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> filterFindByA_A(long applicationId,
		boolean authorized, int start, int end) throws SystemException {
		return filterFindByA_A(applicationId, authorized, start, end, null);
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
	public List<OAuthApplicationUser> filterFindByA_A(long applicationId,
		boolean authorized, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByA_A(applicationId, authorized, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_A_A_APPLICATIONID_2);

		query.append(_FINDER_COLUMN_A_A_AUTHORIZED_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(applicationId);

			qPos.add(authorized);

			return (List<OAuthApplicationUser>)QueryUtil.list(q, getDialect(),
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
	public OAuthApplicationUser[] filterFindByA_A_PrevAndNext(long oaauId,
		long applicationId, boolean authorized,
		OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByA_A_PrevAndNext(oaauId, applicationId, authorized,
				orderByComparator);
		}

		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = filterGetByA_A_PrevAndNext(session,
					oAuthApplicationUser, applicationId, authorized,
					orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = filterGetByA_A_PrevAndNext(session,
					oAuthApplicationUser, applicationId, authorized,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser filterGetByA_A_PrevAndNext(Session session,
		OAuthApplicationUser oAuthApplicationUser, long applicationId,
		boolean authorized, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_A_A_APPLICATIONID_2);

		query.append(_FINDER_COLUMN_A_A_AUTHORIZED_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationId);

		qPos.add(authorized);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public OAuthApplicationUser findByU_AP(long userId, long applicationId)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByU_AP(userId,
				applicationId);

		if (oAuthApplicationUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", applicationId=");
			msg.append(applicationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchApplicationUserException(msg.toString());
		}

		return oAuthApplicationUser;
	}

	/**
	 * Returns the o auth application user where userId = &#63; and applicationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param applicationId the application ID
	 * @return the matching o auth application user, or <code>null</code> if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser fetchByU_AP(long userId, long applicationId)
		throws SystemException {
		return fetchByU_AP(userId, applicationId, true);
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
	public OAuthApplicationUser fetchByU_AP(long userId, long applicationId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, applicationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_U_AP,
					finderArgs, this);
		}

		if (result instanceof OAuthApplicationUser) {
			OAuthApplicationUser oAuthApplicationUser = (OAuthApplicationUser)result;

			if ((userId != oAuthApplicationUser.getUserId()) ||
					(applicationId != oAuthApplicationUser.getApplicationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_U_AP_USERID_2);

			query.append(_FINDER_COLUMN_U_AP_APPLICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(applicationId);

				List<OAuthApplicationUser> list = q.list();

				result = list;

				OAuthApplicationUser oAuthApplicationUser = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AP,
						finderArgs, list);
				}
				else {
					oAuthApplicationUser = list.get(0);

					cacheResult(oAuthApplicationUser);

					if ((oAuthApplicationUser.getUserId() != userId) ||
							(oAuthApplicationUser.getApplicationId() != applicationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_U_AP,
							finderArgs, oAuthApplicationUser);
					}
				}

				return oAuthApplicationUser;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_U_AP,
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
				return (OAuthApplicationUser)result;
			}
		}
	}

	/**
	 * Returns all the o auth application users where userId = &#63; and authorized = &#63;.
	 *
	 * @param userId the user ID
	 * @param authorized the authorized
	 * @return the matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findByU_AU(long userId, boolean authorized)
		throws SystemException {
		return findByU_AU(userId, authorized, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> findByU_AU(long userId,
		boolean authorized, int start, int end) throws SystemException {
		return findByU_AU(userId, authorized, start, end, null);
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
	public List<OAuthApplicationUser> findByU_AU(long userId,
		boolean authorized, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AU;
			finderArgs = new Object[] { userId, authorized };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_AU;
			finderArgs = new Object[] {
					userId, authorized,
					
					start, end, orderByComparator
				};
		}

		List<OAuthApplicationUser> list = (List<OAuthApplicationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthApplicationUser oAuthApplicationUser : list) {
				if ((userId != oAuthApplicationUser.getUserId()) ||
						(authorized != oAuthApplicationUser.getAuthorized())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_U_AU_USERID_2);

			query.append(_FINDER_COLUMN_U_AU_AUTHORIZED_2);

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

				qPos.add(authorized);

				list = (List<OAuthApplicationUser>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first o auth application user in the ordered set where userId = &#63; and authorized = &#63;.
	 *
	 * @param userId the user ID
	 * @param authorized the authorized
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth application user
	 * @throws com.liferay.portal.oauth.NoSuchApplicationUserException if a matching o auth application user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser findByU_AU_First(long userId,
		boolean authorized, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByU_AU_First(userId,
				authorized, orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", authorized=");
		msg.append(authorized);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
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
	public OAuthApplicationUser fetchByU_AU_First(long userId,
		boolean authorized, OrderByComparator orderByComparator)
		throws SystemException {
		List<OAuthApplicationUser> list = findByU_AU(userId, authorized, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser findByU_AU_Last(long userId,
		boolean authorized, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = fetchByU_AU_Last(userId,
				authorized, orderByComparator);

		if (oAuthApplicationUser != null) {
			return oAuthApplicationUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", authorized=");
		msg.append(authorized);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationUserException(msg.toString());
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
	public OAuthApplicationUser fetchByU_AU_Last(long userId,
		boolean authorized, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByU_AU(userId, authorized);

		List<OAuthApplicationUser> list = findByU_AU(userId, authorized,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public OAuthApplicationUser[] findByU_AU_PrevAndNext(long oaauId,
		long userId, boolean authorized, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = getByU_AU_PrevAndNext(session, oAuthApplicationUser,
					userId, authorized, orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = getByU_AU_PrevAndNext(session, oAuthApplicationUser,
					userId, authorized, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser getByU_AU_PrevAndNext(Session session,
		OAuthApplicationUser oAuthApplicationUser, long userId,
		boolean authorized, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_U_AU_USERID_2);

		query.append(_FINDER_COLUMN_U_AU_AUTHORIZED_2);

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

		qPos.add(authorized);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users that the user has permission to view where userId = &#63; and authorized = &#63;.
	 *
	 * @param userId the user ID
	 * @param authorized the authorized
	 * @return the matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> filterFindByU_AU(long userId,
		boolean authorized) throws SystemException {
		return filterFindByU_AU(userId, authorized, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> filterFindByU_AU(long userId,
		boolean authorized, int start, int end) throws SystemException {
		return filterFindByU_AU(userId, authorized, start, end, null);
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
	public List<OAuthApplicationUser> filterFindByU_AU(long userId,
		boolean authorized, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByU_AU(userId, authorized, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_U_AU_USERID_2);

		query.append(_FINDER_COLUMN_U_AU_AUTHORIZED_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(authorized);

			return (List<OAuthApplicationUser>)QueryUtil.list(q, getDialect(),
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
	public OAuthApplicationUser[] filterFindByU_AU_PrevAndNext(long oaauId,
		long userId, boolean authorized, OrderByComparator orderByComparator)
		throws NoSuchApplicationUserException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByU_AU_PrevAndNext(oaauId, userId, authorized,
				orderByComparator);
		}

		OAuthApplicationUser oAuthApplicationUser = findByPrimaryKey(oaauId);

		Session session = null;

		try {
			session = openSession();

			OAuthApplicationUser[] array = new OAuthApplicationUserImpl[3];

			array[0] = filterGetByU_AU_PrevAndNext(session,
					oAuthApplicationUser, userId, authorized,
					orderByComparator, true);

			array[1] = oAuthApplicationUser;

			array[2] = filterGetByU_AU_PrevAndNext(session,
					oAuthApplicationUser, userId, authorized,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthApplicationUser filterGetByU_AU_PrevAndNext(
		Session session, OAuthApplicationUser oAuthApplicationUser,
		long userId, boolean authorized, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_U_AU_USERID_2);

		query.append(_FINDER_COLUMN_U_AU_AUTHORIZED_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2);
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
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, OAuthApplicationUserImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, OAuthApplicationUserImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(authorized);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(oAuthApplicationUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OAuthApplicationUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the o auth application users.
	 *
	 * @return the o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public List<OAuthApplicationUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<OAuthApplicationUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<OAuthApplicationUser> findAll(int start, int end,
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

		List<OAuthApplicationUser> list = (List<OAuthApplicationUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OAUTHAPPLICATIONUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OAUTHAPPLICATIONUSER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<OAuthApplicationUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<OAuthApplicationUser>)QueryUtil.list(q,
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
	 * Removes all the o auth application users where accessToken = &#63; from the database.
	 *
	 * @param accessToken the access token
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAccessToken(String accessToken)
		throws SystemException {
		for (OAuthApplicationUser oAuthApplicationUser : findByAccessToken(
				accessToken)) {
			remove(oAuthApplicationUser);
		}
	}

	/**
	 * Removes all the o auth application users where applicationId = &#63; from the database.
	 *
	 * @param applicationId the application ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByApplicationId(long applicationId)
		throws SystemException {
		for (OAuthApplicationUser oAuthApplicationUser : findByApplicationId(
				applicationId)) {
			remove(oAuthApplicationUser);
		}
	}

	/**
	 * Removes all the o auth application users where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (OAuthApplicationUser oAuthApplicationUser : findByCompanyId(
				companyId)) {
			remove(oAuthApplicationUser);
		}
	}

	/**
	 * Removes all the o auth application users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (OAuthApplicationUser oAuthApplicationUser : findByUserId(userId)) {
			remove(oAuthApplicationUser);
		}
	}

	/**
	 * Removes all the o auth application users where applicationId = &#63; and authorized = &#63; from the database.
	 *
	 * @param applicationId the application ID
	 * @param authorized the authorized
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByA_A(long applicationId, boolean authorized)
		throws SystemException {
		for (OAuthApplicationUser oAuthApplicationUser : findByA_A(
				applicationId, authorized)) {
			remove(oAuthApplicationUser);
		}
	}

	/**
	 * Removes the o auth application user where userId = &#63; and applicationId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param applicationId the application ID
	 * @return the o auth application user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public OAuthApplicationUser removeByU_AP(long userId, long applicationId)
		throws NoSuchApplicationUserException, SystemException {
		OAuthApplicationUser oAuthApplicationUser = findByU_AP(userId,
				applicationId);

		return remove(oAuthApplicationUser);
	}

	/**
	 * Removes all the o auth application users where userId = &#63; and authorized = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param authorized the authorized
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_AU(long userId, boolean authorized)
		throws SystemException {
		for (OAuthApplicationUser oAuthApplicationUser : findByU_AU(userId,
				authorized)) {
			remove(oAuthApplicationUser);
		}
	}

	/**
	 * Removes all the o auth application users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (OAuthApplicationUser oAuthApplicationUser : findAll()) {
			remove(oAuthApplicationUser);
		}
	}

	/**
	 * Returns the number of o auth application users where accessToken = &#63;.
	 *
	 * @param accessToken the access token
	 * @return the number of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAccessToken(String accessToken) throws SystemException {
		Object[] finderArgs = new Object[] { accessToken };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACCESSTOKEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

			if (accessToken == null) {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_1);
			}
			else {
				if (accessToken.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (accessToken != null) {
					qPos.add(accessToken);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACCESSTOKEN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o auth application users that the user has permission to view where accessToken = &#63;.
	 *
	 * @param accessToken the access token
	 * @return the number of matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByAccessToken(String accessToken)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByAccessToken(accessToken);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

		if (accessToken == null) {
			query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_1);
		}
		else {
			if (accessToken.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_3);
			}
			else {
				query.append(_FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (accessToken != null) {
				qPos.add(accessToken);
			}

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
	 * Returns the number of o auth application users where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the number of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByApplicationId(long applicationId)
		throws SystemException {
		Object[] finderArgs = new Object[] { applicationId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o auth application users that the user has permission to view where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the number of matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByApplicationId(long applicationId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByApplicationId(applicationId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(applicationId);

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
	 * Returns the number of o auth application users where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

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
	 * Returns the number of o auth application users that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCompanyId(long companyId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCompanyId(companyId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplicationUser.class.getName(),
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
	 * Returns the number of o auth application users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

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
	 * Returns the number of o auth application users that the user has permission to view where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByUserId(long userId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByUserId(userId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplicationUser.class.getName(),
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
	 * Returns the number of o auth application users where applicationId = &#63; and authorized = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param authorized the authorized
	 * @return the number of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByA_A(long applicationId, boolean authorized)
		throws SystemException {
		Object[] finderArgs = new Object[] { applicationId, authorized };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_A_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_A_A_APPLICATIONID_2);

			query.append(_FINDER_COLUMN_A_A_AUTHORIZED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationId);

				qPos.add(authorized);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_A, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o auth application users that the user has permission to view where applicationId = &#63; and authorized = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param authorized the authorized
	 * @return the number of matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByA_A(long applicationId, boolean authorized)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByA_A(applicationId, authorized);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_A_A_APPLICATIONID_2);

		query.append(_FINDER_COLUMN_A_A_AUTHORIZED_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(applicationId);

			qPos.add(authorized);

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
	 * Returns the number of o auth application users where userId = &#63; and applicationId = &#63;.
	 *
	 * @param userId the user ID
	 * @param applicationId the application ID
	 * @return the number of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_AP(long userId, long applicationId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, applicationId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_AP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_U_AP_USERID_2);

			query.append(_FINDER_COLUMN_U_AP_APPLICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(applicationId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_AP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o auth application users where userId = &#63; and authorized = &#63;.
	 *
	 * @param userId the user ID
	 * @param authorized the authorized
	 * @return the number of matching o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_AU(long userId, boolean authorized)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, authorized };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_AU,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

			query.append(_FINDER_COLUMN_U_AU_USERID_2);

			query.append(_FINDER_COLUMN_U_AU_AUTHORIZED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(authorized);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_AU,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of o auth application users that the user has permission to view where userId = &#63; and authorized = &#63;.
	 *
	 * @param userId the user ID
	 * @param authorized the authorized
	 * @return the number of matching o auth application users that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByU_AU(long userId, boolean authorized)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByU_AU(userId, authorized);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE);

		query.append(_FINDER_COLUMN_U_AU_USERID_2);

		query.append(_FINDER_COLUMN_U_AU_AUTHORIZED_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				OAuthApplicationUser.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(authorized);

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
	 * Returns the number of o auth application users.
	 *
	 * @return the number of o auth application users
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OAUTHAPPLICATIONUSER);

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
	 * Initializes the o auth application user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portal.oauth.model.OAuthApplicationUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OAuthApplicationUser>> listenersList = new ArrayList<ModelListener<OAuthApplicationUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OAuthApplicationUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OAuthApplicationUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = OAuthApplicationPersistence.class)
	protected OAuthApplicationPersistence oAuthApplicationPersistence;
	@BeanReference(type = OAuthApplicationUserPersistence.class)
	protected OAuthApplicationUserPersistence oAuthApplicationUserPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_OAUTHAPPLICATIONUSER = "SELECT oAuthApplicationUser FROM OAuthApplicationUser oAuthApplicationUser";
	private static final String _SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE = "SELECT oAuthApplicationUser FROM OAuthApplicationUser oAuthApplicationUser WHERE ";
	private static final String _SQL_COUNT_OAUTHAPPLICATIONUSER = "SELECT COUNT(oAuthApplicationUser) FROM OAuthApplicationUser oAuthApplicationUser";
	private static final String _SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE = "SELECT COUNT(oAuthApplicationUser) FROM OAuthApplicationUser oAuthApplicationUser WHERE ";
	private static final String _FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_1 = "oAuthApplicationUser.accessToken IS NULL";
	private static final String _FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_2 = "oAuthApplicationUser.accessToken = ?";
	private static final String _FINDER_COLUMN_ACCESSTOKEN_ACCESSTOKEN_3 = "(oAuthApplicationUser.accessToken IS NULL OR oAuthApplicationUser.accessToken = ?)";
	private static final String _FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2 = "oAuthApplicationUser.applicationId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "oAuthApplicationUser.companyId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "oAuthApplicationUser.userId = ?";
	private static final String _FINDER_COLUMN_A_A_APPLICATIONID_2 = "oAuthApplicationUser.applicationId = ? AND ";
	private static final String _FINDER_COLUMN_A_A_AUTHORIZED_2 = "oAuthApplicationUser.authorized = ?";
	private static final String _FINDER_COLUMN_U_AP_USERID_2 = "oAuthApplicationUser.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_AP_APPLICATIONID_2 = "oAuthApplicationUser.applicationId = ?";
	private static final String _FINDER_COLUMN_U_AU_USERID_2 = "oAuthApplicationUser.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_AU_AUTHORIZED_2 = "oAuthApplicationUser.authorized = ?";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "oAuthApplicationUser.oaauId";
	private static final String _FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_WHERE = "SELECT DISTINCT {oAuthApplicationUser.*} FROM OAuthApplicationUser oAuthApplicationUser WHERE ";
	private static final String _FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {OAuthApplicationUser.*} FROM (SELECT DISTINCT oAuthApplicationUser.oaauId FROM OAuthApplicationUser oAuthApplicationUser WHERE ";
	private static final String _FILTER_SQL_SELECT_OAUTHAPPLICATIONUSER_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN OAuthApplicationUser ON TEMP_TABLE.oaauId = OAuthApplicationUser.oaauId";
	private static final String _FILTER_SQL_COUNT_OAUTHAPPLICATIONUSER_WHERE = "SELECT COUNT(DISTINCT oAuthApplicationUser.oaauId) AS COUNT_VALUE FROM OAuthApplicationUser oAuthApplicationUser WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "oAuthApplicationUser";
	private static final String _FILTER_ENTITY_TABLE = "OAuthApplicationUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "oAuthApplicationUser.";
	private static final String _ORDER_BY_ENTITY_TABLE = "OAuthApplicationUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OAuthApplicationUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OAuthApplicationUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OAuthApplicationUserPersistenceImpl.class);
	private static OAuthApplicationUser _nullOAuthApplicationUser = new OAuthApplicationUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OAuthApplicationUser> toCacheModel() {
				return _nullOAuthApplicationUserCacheModel;
			}
		};

	private static CacheModel<OAuthApplicationUser> _nullOAuthApplicationUserCacheModel =
		new CacheModel<OAuthApplicationUser>() {
			public OAuthApplicationUser toEntityModel() {
				return _nullOAuthApplicationUser;
			}
		};
}