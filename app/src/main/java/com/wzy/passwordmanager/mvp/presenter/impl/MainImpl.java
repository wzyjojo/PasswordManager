package com.wzy.passwordmanager.mvp.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;

import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.databinding.ActivityMainBinding;
import com.wzy.passwordmanager.mvp.model.db.AccountBdManager;
import com.wzy.passwordmanager.mvp.presenter.ActivityPresenter;
import com.wzy.passwordmanager.mvp.ui.activity.AddActivity;
import com.wzy.passwordmanager.mvp.ui.adapter.MainRecyclerViewAdapter;
import com.wzy.passwordmanager.mvp.ui.view.MainView;
import com.wzy.pdmanager.AccountInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * =================================================================
 * <p/>
 * 版    权：WZY 版权所有 (c) 2015
 * <p/>
 * 作    者：lmejojo
 * <p/>
 * 版    本：1.0
 * <p/>
 * 创建日期： 2016/4/25 0025 14:00
 * <p/>
 * 描    述：
 * <p/>
 * 修订历史：
 * <p/>
 * =================================================================
 **/
public class MainImpl implements ActivityPresenter,NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener,SearchView.OnQueryTextListener {

    private static long DOUBLE_CLICK_TIME = 0L;
    private MainView mMainView;
    private ActivityMainBinding mainBinding;
    private final Context mContext;
    private AccountBdManager accountBdManager ;

    public MainImpl(Context context, MainView mainView, ActivityMainBinding mainBinding){
        this.mContext = context;
        this.mMainView = mainView;
        this.mainBinding = mainBinding;
        accountBdManager = new AccountBdManager();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mMainView.inintDrawerToggle();

        onFirstUserVisible();

        mainBinding.fab.setOnClickListener(this);
        mainBinding.navView.setNavigationItemSelectedListener(this);
    }

    private void onFirstUserVisible() {
        accountBdManager.loadAll();
        List<AccountInfo> list = new ArrayList<AccountInfo>();
        list.add(new AccountInfo(null, "测试1", -1, null, "淘宝", "123", "", "",null));
        list.add(new AccountInfo(null, "测试2", -1, null, "迅雷", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        list.add(new AccountInfo(null, "测试3", -1, null, "京东", "123", "", "",null));
        mMainView.initRecyclerView(new LinearLayoutManager(mContext),
                new MainRecyclerViewAdapter(mainBinding.rvPwdlist,list,mContext));
    }


    @Override
    public void getIntent(Intent intent) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        mainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Bundle bundle = new Bundle();
                bundle.putInt("Type",1);
                mMainView.rdGo(AddActivity.class,bundle);
                break;

        }
    }

    public boolean onBackPress() {
        if (mainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainBinding.drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        }

        if (System.currentTimeMillis() - DOUBLE_CLICK_TIME > 2000) {
            DOUBLE_CLICK_TIME = System.currentTimeMillis();
            mMainView.showSnackToast("再按一次退出~~");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return false;
    }
}
