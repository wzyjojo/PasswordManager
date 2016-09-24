package com.wzy.passwordmanager.mvp.presenter.impl;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.databinding.ActivityAddBinding;
import com.wzy.passwordmanager.mvp.model.db.AccountBdManager;
import com.wzy.passwordmanager.mvp.presenter.ActivityPresenter;
import com.wzy.passwordmanager.mvp.ui.activity.IconsActivity;
import com.wzy.passwordmanager.mvp.ui.view.AddView;
import com.wzy.passwordmanager.utils.AESUtils;
import com.wzy.pdmanager.AccountInfo;

/**
 * Created by lmejojo on 2016/5/12 0012.
 */
public class AddImpl implements ActivityPresenter, View.OnClickListener {

    private AddView mAddView;
    private ActivityAddBinding addBinding;
    private AccountBdManager bdManager;
    private Context mContext;

    public AddImpl(AddView addView, Context context, ActivityAddBinding addBinding) {
        this.mAddView = addView;
        this.addBinding = addBinding;
        this.mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mAddView.init();
    }

    @Override
    public void getIntent(Intent intent) {
        new AccountBdManager().insert(new AccountInfo(null, "测试2", -1, null, "淘宝", "123", "", "",null));
        new AccountBdManager().insert(new AccountInfo(null, "测试3", -1, null, "淘宝", "123", "", "",null));
        new AccountBdManager().insert(new AccountInfo(null, "测试4", -1, null, "淘宝", "123", "", "",null));
        Bundle bundle = intent.getExtras();
        if (bundle.getInt("Type") == 1) {
            //addBinding.setAccount(new AccountInfo(null, "测试1", -1, null, "淘宝", "123", "", "",null));
        } else {
            mAddView.setToolbarTitle("编辑");

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_select:
                mAddView.rdGoForResult(IconsActivity.class,101);
                break;
            case R.id.iv_help:
                new AlertDialog.Builder(mContext)
                        .setMessage(mContext.getResources().getString(R.string.iv_help_tip))
                        .setPositiveButton(mContext.getResources().getString(R.string.btn_ok), null)
                        .show();
                break;
            case R.id.btn_generate_pwd:
                addBinding.edtPassword.setText(AESUtils.getGeneratePwd());
                break;
            case R.id.btn_confirm:

                break;
        }
    }
}
