package com.wzy.passwordmanager.mvp.model.db;

import com.wzy.passwordmanager.mvp.model.db.sql.AbstractDatabaseManager;
import com.wzy.pdmanager.PwInfo;

import de.greenrobot.dao.AbstractDao;

/**
 * =================================================================
 * <p/>
 * 版    权：WZY 版权所有 (c) 2015
 * <p/>
 * 作    者：lmejojo
 * <p/>
 * 版    本：1.0
 * <p/>
 * 创建日期： 2016/4/22 0022 20:18
 * <p/>
 * 描    述：
 * <p/>
 * 修订历史：
 * <p/>
 * =================================================================
 **/
public class PwBdManager extends AbstractDatabaseManager<PwInfo,Long> {


    @Override
    public AbstractDao<PwInfo, Long> getAbstractDao() {
        return daoSession.getPwInfoDao();
    }
}

