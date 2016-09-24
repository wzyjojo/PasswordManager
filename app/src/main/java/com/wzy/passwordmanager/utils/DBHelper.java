package com.wzy.passwordmanager.utils;

import com.wzy.passwordmanager.mvp.model.db.AccountBdManager;
import com.wzy.passwordmanager.mvp.model.db.PwBdManager;

/**
 * =================================================================
 * <p/>
 * 版    权：WZY 版权所有 (c) 2015
 * <p/>
 * 作    者：lmejojo
 * <p/>
 * 版    本：1.0
 * <p/>
 * 创建日期： 2016/4/22 0022 17:42
 * <p/>
 * 描    述：
 * <p/>
 * 修订历史：
 * <p/>
 * =================================================================
 **/
public class DBHelper {
    public static AccountBdManager getAccountBdManager(){
        return new AccountBdManager();
    }
    public static PwBdManager getPwBdManager(){
        return new PwBdManager();
    }
}
