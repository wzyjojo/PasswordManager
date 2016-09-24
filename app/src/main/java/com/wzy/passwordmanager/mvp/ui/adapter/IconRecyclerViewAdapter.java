package com.wzy.passwordmanager.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;

import com.wzy.passwordmanager.R;
import com.wzy.passwordmanager.mvp.model.ConstanTs;
import com.wzy.passwordmanager.mvp.ui.adapter.base.BaseRecyclerAdapter;
import com.wzy.passwordmanager.mvp.ui.adapter.base.RecyclerViewHolder;

import java.util.Collection;


/**
 * Created by lmejojo on 2016/5/15 0015.
 */
public class IconRecyclerViewAdapter extends BaseRecyclerAdapter<Integer> {

    public IconRecyclerViewAdapter(RecyclerView v, Collection<Integer> datas, int itemLayoutId ) {
        super(v, datas, itemLayoutId);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Integer item, int position, boolean isScrolling) {
        holder.setImageResource(R.id.image, ConstanTs.icons[position]);
    }


}
