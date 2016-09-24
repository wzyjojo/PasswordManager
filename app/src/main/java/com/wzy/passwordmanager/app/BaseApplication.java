package com.wzy.passwordmanager.app;

import android.app.Application;

import com.google.gson.Gson;
import com.wzy.passwordmanager.mvp.model.db.sql.AbstractDatabaseManager;
import com.wzy.passwordmanager.utils.AppManager;

/**
 * =================================================================
 * <p/>
 * 版    权：WZY 版权所有 (c) 2015
 * <p/>
 * 作    者：lmejojo
 * <p/>
 * 版    本：1.0
 * <p/>
 * 创建日期： 2016/4/22 0022 14:03
 * <p/>
 * 描    述：
 * <p/>
 * 修订历史：
 * <p/>
 * =================================================================
 **/
public class BaseApplication extends Application{
    public AppManager pAppManager;
    public Gson pGson;

    @Override
    public void onCreate() {
        pAppManager = AppManager.getAppManager();
        pGson = new Gson();
        AbstractDatabaseManager.initOpenHelper(getApplicationContext());//初始化数据库
        super.onCreate();
    }

    /**
     * 获取gson工具类
     * @return
     */
    Gson getpGson(){
        return pGson;
    }
}
