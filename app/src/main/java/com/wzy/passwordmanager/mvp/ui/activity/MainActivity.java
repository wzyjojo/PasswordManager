package com.wzy.passwordmanager.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.databinding.ActivityMainBinding;
import com.wzy.passwordmanager.mvp.presenter.impl.MainImpl;
import com.wzy.passwordmanager.mvp.ui.activity.base.BaseActivity;
import com.wzy.passwordmanager.mvp.ui.adapter.MainRecyclerViewAdapter;
import com.wzy.passwordmanager.mvp.ui.view.MainView;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.rv_pwdlist)
    RecyclerView rvPwdlist;

    private MainImpl mMainImpl;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = (ActivityMainBinding) super.mDataBinding;

        mMainImpl = new MainImpl(this, this, mainBinding);
        mMainImpl.onCreate(savedInstanceState);



    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        if (mMainImpl.onBackPress()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        ((SearchView)MenuItemCompat.getActionView(searchItem)).setOnQueryTextListener(mMainImpl);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 显示Snackbar的控件
     *
     * @return view
     */
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
    }

    /**
     * 初始化侧滑菜单
     */
    @Override
    public void inintDrawerToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }


    /**
     * 初始化RecyclerView数据
     */
    @Override
    public void initRecyclerView(LinearLayoutManager layoutManager, MainRecyclerViewAdapter mainRecyclerViewAdapter) {
        rvPwdlist.setHasFixedSize(true);
        rvPwdlist.setLayoutManager(layoutManager);
        rvPwdlist.setAdapter(mainRecyclerViewAdapter);
    }

    @Override
    public void rdGo(Class<?> clazz,Bundle bundle) {
        readyGo(clazz,bundle);
    }

    /**
     * 关闭当前界面
     */
    @Override
    public void mFinish() {
        finish();
    }

    /**
     * 显示SnackToast
     *
     * @param msg 显示内容
     */
    @Override
    public void showSnackToast(String msg) {
        super.showToast(msg);
    }

    @Override
    protected boolean isApplyButterKnife() {
        return true;
    }

    @Override
    protected int getOverridePendingTransitionMode() {
        return 7;
    }

    @Override
    protected void DetoryViewAndThing() {

    }

    @Override
    protected void ResumeViewAndThing() {

    }
}
