package com.wzy.pdmanager;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig pwInfoDaoConfig;
    private final DaoConfig accountInfoDaoConfig;

    private final PwInfoDao pwInfoDao;
    private final AccountInfoDao accountInfoDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        pwInfoDaoConfig = daoConfigMap.get(PwInfoDao.class).clone();
        pwInfoDaoConfig.initIdentityScope(type);

        accountInfoDaoConfig = daoConfigMap.get(AccountInfoDao.class).clone();
        accountInfoDaoConfig.initIdentityScope(type);

        pwInfoDao = new PwInfoDao(pwInfoDaoConfig, this);
        accountInfoDao = new AccountInfoDao(accountInfoDaoConfig, this);

        registerDao(PwInfo.class, pwInfoDao);
        registerDao(AccountInfo.class, accountInfoDao);
    }
    
    public void clear() {
        pwInfoDaoConfig.getIdentityScope().clear();
        accountInfoDaoConfig.getIdentityScope().clear();
    }

    public PwInfoDao getPwInfoDao() {
        return pwInfoDao;
    }

    public AccountInfoDao getAccountInfoDao() {
        return accountInfoDao;
    }

}
