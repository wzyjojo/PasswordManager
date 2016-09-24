package com.wzy.passwordmanager.mvp.ui.activity.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.app.BaseApplication;

/**
 * =================================================================
 * <p>
 * 版    权：WZY 版权所有 (c) 2015
 * <p>
 * 作    者：lmejojo
 * <p>
 * 版    本：1.0
 * <p>
 * 创建日期： 2016/4/22 0022 22:19
 * <p>
 * 描    述：
 * <p>
 * 修订历史：
 * <p>
 * =================================================================
 **/
public abstract class BaseAppCompatActivity extends AppCompatActivity {
    protected static String TAG_LOG = null;
    protected Context mContext = null;
    public static final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4, SCALE = 5, FADE = 6, ZOOM = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch (getOverridePendingTransitionMode()) {
            case LEFT:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case RIGHT:
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                break;
            case TOP:
                overridePendingTransition(R.anim.top_in, R.anim.top_out);
                break;
            case BOTTOM:
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                break;
            case SCALE:
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                break;
            case FADE:
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case ZOOM:
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                break;
            default:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
        }
        super.onCreate(savedInstanceState);

        mContext = this;
        TAG_LOG = this.getClass().getSimpleName();
        ((BaseApplication)getApplication()).pAppManager.addActivity(this);

    }


    @Override
    public void finish() {
        super.finish();
        //((BaseApplication)getApplication()).pAppManager.finishActivity(this);
        switch (getOverridePendingTransitionMode()) {
            case LEFT:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case RIGHT:
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                break;
            case TOP:
                overridePendingTransition(R.anim.top_in, R.anim.top_out);
                break;
            case BOTTOM:
                overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                break;
            case SCALE:
                overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                break;
            case FADE:
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            default:
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // 当新设置中，屏幕布局模式为横排时
        if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            //TODO 某些操作
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DetoryViewAndThing();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ResumeViewAndThing();
    }

    protected abstract int getContentView();

    protected abstract int getOverridePendingTransitionMode();

    protected abstract void DetoryViewAndThing();

    protected abstract void ResumeViewAndThing();
}