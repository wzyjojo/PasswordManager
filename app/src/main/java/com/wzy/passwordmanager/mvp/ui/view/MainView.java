package com.wzy.passwordmanager.mvp.ui.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.wzy.passwordmanager.mvp.ui.adapter.MainRecyclerViewAdapter;

/**
 * =================================================================
 * <p/>
 * 版    权：WZY 版权所有 (c) 2015
 * <p/>
 * 作    者：lmejojo
 * <p/>
 * 版    本：1.0
 * <p/>
 * 创建日期： 2016/4/25 0025 14:01
 * <p/>
 * 描    述：
 * <p/>
 * 修订历史：
 * <p/>
 * =================================================================
 **/
public interface MainView extends BaseView{
    void inintDrawerToggle();
    void initRecyclerView(LinearLayoutManager layoutManager , MainRecyclerViewAdapter mainRecyclerViewAdapter);
    void rdGo(Class<?> clazz, Bundle bundle);
}
