package com.wzy.passwordmanager.mvp.ui.view;

/**
 * =================================================================
 * <p>
 * 版    权：WZY 版权所有 (c) 2015
 * <p>
 * 作    者：lmejojo
 * <p>
 * 版    本：1.0
 * <p>
 * 创建日期： 2016/4/21 0021 14:37
 * <p>
 * 描    述：
 * <p>
 * 修订历史：
 * <p>
 * =================================================================
 **/
public interface LockView extends BaseView{

    void initBlurLockView(String pw);
    void rdGoThenKill(Class<?> clazz);


}
