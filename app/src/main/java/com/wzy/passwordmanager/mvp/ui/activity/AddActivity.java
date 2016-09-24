package com.wzy.passwordmanager.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.databinding.ActivityAddBinding;
import com.wzy.passwordmanager.mvp.model.ConstanTs;
import com.wzy.passwordmanager.mvp.presenter.impl.AddImpl;
import com.wzy.passwordmanager.mvp.ui.activity.base.BaseActivity;
import com.wzy.passwordmanager.mvp.ui.adapter.SpinnerAdapter;
import com.wzy.passwordmanager.mvp.ui.view.AddView;

import butterknife.Bind;

/**
 * Created by lmejojo on 2016/5/12 0012.
 */
public class AddActivity extends BaseActivity implements AddView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.sp_type)
    Spinner spType;
    @Bind(R.id.iv_select)
    ImageView ivSelect;
    @Bind(R.id.btn_generate_pwd)
    Button btnGeneratePwd;
    @Bind(R.id.iv_help)
    ImageView ivHelp;
    @Bind(R.id.btn_confirm)
    Button btnConfirm;
    @Bind(R.id.edt_password)
    MaterialEditText edtPassword;
    @Bind(R.id.edt_title)
    MaterialEditText edtTitle;
    @Bind(R.id.edt_account)
    MaterialEditText edtAccount;
    @Bind(R.id.edt_note)
    MaterialEditText edtNote;

    private AddImpl mAddImpl;
    private ActivityAddBinding addBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addBinding = (ActivityAddBinding) super.mDataBinding;
        mAddImpl = new AddImpl(this, this, addBinding);
        mAddImpl.onCreate(savedInstanceState);
        mAddImpl.getIntent(getIntent());

        SpinnerAdapter madapter = new SpinnerAdapter(this, ConstanTs.getTypes());
        spType.setAdapter(madapter);
    }

    @Override
    protected View getLoadingTargetView() {
        return toolbar;
    }

    /**
     * Toolbar初始化
     */
    @Override
    protected void initToolbar() {
        super.initToolBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.add_title));
    }

    @Override
    protected boolean isApplyButterKnife() {
        return true;
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_add;
    }

    @Override
    protected int getOverridePendingTransitionMode() {
        return 4;
    }

    @Override
    protected void DetoryViewAndThing() {

    }

    @Override
    protected void ResumeViewAndThing() {

    }

    @Override
    public void init() {
        ivSelect.setOnClickListener(mAddImpl);
        btnGeneratePwd.setOnClickListener(mAddImpl);
        btnConfirm.setOnClickListener(mAddImpl);
        ivHelp.setOnClickListener(mAddImpl);
    }

    @Override
    public void setToolbarTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void rdGoForResult(Class<?> clazz, int requestCode) {
        readyGoForResult(clazz, requestCode);
    }

    @Override
    public void hideKeyBoard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(edtPassword.getWindowToken(), 0);
    }

    @Override
    public String getTitleName() {
        return edtTitle.getText().toString().trim();
    }

    @Override
    public String getUserName() {
        return edtAccount.getText().toString().trim();
    }

    @Override
    public String getPassWord() {
        return edtPassword.getText().toString().trim();
    }

    @Override
    public String getNoteInfo() {
        return edtNote.getText().toString().trim();
    }

    @Override
    public int getIconPosition() {
        return (int)ivSelect.getTag();
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 102) {
            ivSelect.setImageResource(ConstanTs.icons[data.getIntExtra("ico", -1)]);
            ivSelect.setTag(data.getIntExtra("ico", -1));
            ivSelect.setBackground(null);
            ivSelect.setPadding(0, 0, 0, 0);
        }
    }
}
