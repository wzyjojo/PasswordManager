package com.wzy.passwordmanager.mvp.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.nightonke.blurlockview.BlurLockView;
import com.nightonke.blurlockview.Password;
import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.mvp.presenter.impl.LockImpl;
import com.wzy.passwordmanager.mvp.ui.activity.base.BaseActivity;
import com.wzy.passwordmanager.mvp.ui.view.LockView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LockActivity extends BaseActivity implements LockView{

    @Bind(R.id.iv_lock_bg)
    ImageView ivLockBg;
    @Bind(R.id.blurlockview)
    BlurLockView blurlockview;

    private LockImpl mLockImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mLockImpl = new LockImpl(this);
        mLockImpl.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    @Override protected int getContentView() {
        return R.layout.activity_lock;
    }

    @Override
    protected int getOverridePendingTransitionMode() {
        return 6;
    }

    @Override
    protected void DetoryViewAndThing() {

    }

    @Override
    protected void ResumeViewAndThing() {

    }

    @Override
    public void rdGoThenKill(Class<?> clazz) {
        readyGoThenKill(clazz);
    }

    @Override
    public void initBlurLockView(String pw) {
        blurlockview.setBlurredView(ivLockBg);
        blurlockview.setTitle(getResources().getString(R.string.blockview_tip));
        blurlockview.setCorrectPassword(pw);
        blurlockview.setTypeface(Typeface.DEFAULT);
        blurlockview.setType(Password.NUMBER,false);
        blurlockview.getLeftButton().setVisibility(View.GONE);
        blurlockview.setOnPasswordInputListener(mLockImpl);
    }


    @Override
    public void mFinish() {
        finish();
    }

    @Override
    public void showSnackToast(String msg) {
        showToast(msg);
    }

    @Override
    protected View getLoadingTargetView() {
        return blurlockview;
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected boolean isApplyButterKnife() {
        return false;
    }

}
