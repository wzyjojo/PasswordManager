package com.wzy.passwordmanager.mvp.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;

import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.domain.CustomIcon;
import com.wzy.passwordmanager.mvp.model.ConstanTs;
import com.wzy.passwordmanager.mvp.ui.adapter.base.BaseBindRecyclerAdapter;
import com.wzy.passwordmanager.mvp.ui.adapter.base.MainBindRecyclerHolder;
import com.wzy.passwordmanager.utils.DrawableProvider;
import com.wzy.passwordmanager.utils.SPUtils;
import com.wzy.pdmanager.AccountInfo;

import java.util.Collection;

/**
 * Created by lmejojo on 2016/4/27 0027.
 */
public class MainRecyclerViewAdapter extends BaseBindRecyclerAdapter<AccountInfo>{

    private Context mContext;
    private CustomIcon mCustonIcon;
    private DrawableProvider mProvider;

    public MainRecyclerViewAdapter(RecyclerView v, Collection<AccountInfo> datas , Context context){
        super(v, datas, R.layout.item_main);
        this.mContext = context;
        mProvider = new DrawableProvider(context);
        getIconSetting();
    }

    @Override
    public void convert(MainBindRecyclerHolder holder, AccountInfo item, int position, boolean isScrolling) {
        if(item.getICO()>=0 && item.getICO()<ConstanTs.icons.length){
            holder.setImageResource(R.id.iv_ico,ConstanTs.icons[item.getICO()]);
        }else{
            holder.setImageDrawable(R.id.iv_ico,getIcoDrawable(item.getTitle()));
        }
        holder.getItemMainBinding().setAccount(item);
    }

    /**
     * 获取图标设置信息
     */
    public void getIconSetting() {
        mCustonIcon = new CustomIcon();
        mCustonIcon.setIconShape((Integer) SPUtils.get(mContext, "IconShape", ConstanTs.ICON_ROUND));
        mCustonIcon.setRoundSize((Integer) SPUtils.get(mContext, "RoundSize", 0));
        mCustonIcon.setBorder((Integer) SPUtils.get(mContext, "Border", 0));
        mCustonIcon.setTextSize((Integer) SPUtils.get(mContext,"TextSize",15));
        mCustonIcon.setTextBold((Boolean) SPUtils.get(mContext,"TextBold",false));
    }

    public Drawable getIcoDrawable(String title){
        Drawable drawable = null;
        String text ;
        if(title.length()<=2){
            text = title;
        }else{
            text = String.valueOf(title.charAt(0));
        }
        switch (mCustonIcon.getIconShape()) {
            case ConstanTs.ICON_ROUND:
                drawable = mProvider.getRound(text , mCustonIcon);
                break;
            case  ConstanTs.ICON_ROUNDCORNER:
                drawable = mProvider.getRoundRect(text,mCustonIcon);
                break;
        }

        return drawable;
    }
}
