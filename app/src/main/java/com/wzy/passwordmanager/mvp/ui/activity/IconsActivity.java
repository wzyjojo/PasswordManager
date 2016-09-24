package com.wzy.passwordmanager.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.mvp.model.ConstanTs;
import com.wzy.passwordmanager.mvp.ui.activity.base.BaseActivity;
import com.wzy.passwordmanager.mvp.ui.adapter.IconRecyclerViewAdapter;
import com.wzy.passwordmanager.mvp.ui.adapter.base.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * Created by lmejojo on 2016/5/15 0015.
 */
public class IconsActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_icons)
    RecyclerView rvIcons;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent();
            intent.putExtra("ico",(int)msg.obj);
            setResult(102,intent);
            finish();
        }
    };

    @Override
    protected View getLoadingTargetView() {
        return toolbar;
    }

    @Override
    protected void initToolbar() {
        super.initToolBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.title_choose_icon));
    }

    @Override
    protected boolean isApplyButterKnife() {
        return true;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_icon;
    }

    @Override
    protected int getOverridePendingTransitionMode() {
        return 0;
    }

    @Override
    protected void DetoryViewAndThing() {

    }

    @Override
    protected void ResumeViewAndThing() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rvIcons.setLayoutManager(new GridLayoutManager(this,5));
        IconRecyclerViewAdapter iconRecyclerViewAdapter = new IconRecyclerViewAdapter(rvIcons, getIconList(),R.layout.item_icon);
        iconRecyclerViewAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object data, int position) {
                Message msg = mHandler.obtainMessage(1,position);
                mHandler.sendMessage(msg);
            }
        });
        rvIcons.setAdapter(iconRecyclerViewAdapter);

    }

    public List getIconList(){
        List iconList = new ArrayList();
        for (int ico : ConstanTs.icons){
            iconList.add(ico);
        }
        return iconList;
    }
}
