package com.wzy.passwordmanager.mvp.presenter.impl;

import android.content.Intent;
import android.os.Bundle;

import com.wzy.lmeframe.utils.LMELoger;
import com.wzy.passwordmanager.mvp.presenter.ActivityPresenter;
import com.wzy.passwordmanager.mvp.ui.activity.MainActivity;
import com.wzy.passwordmanager.mvp.ui.view.LockView;
import com.nightonke.blurlockview.BlurLockView;

/**
 * =================================================================
 * <p>
 * 版    权：WZY 版权所有 (c) 2015
 * <p>
 * 作    者：lmejojo
 * <p>
 * 版    本：1.0
 * <p>
 * 创建日期： 2016/4/21 0021 17:07
 * <p>
 * 描    述：
 * <p>
 * 修订历史：
 * <p>
 * =================================================================
 **/
public class LockImpl implements ActivityPresenter, BlurLockView.OnPasswordInputListener{

    private LockView mLockView ;

    public LockImpl(LockView lockView){
        mLockView = lockView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mLockView.initBlurLockView("1234");
    }

    @Override
    public void getIntent(Intent intent) {

    }

    @Override
    public void correct(String inputPassword) {
        mLockView.rdGoThenKill(MainActivity.class);
    }

    @Override
    public void incorrect(String inputPassword) {
        mLockView.showSnackToast("密码错误！");
    }

    @Override
    public void input(String inputPassword) {
        LMELoger.debug(inputPassword);
    }
}
