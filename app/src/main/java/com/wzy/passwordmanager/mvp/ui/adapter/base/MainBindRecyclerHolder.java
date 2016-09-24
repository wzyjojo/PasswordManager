package com.wzy.passwordmanager.mvp.ui.adapter.base;

import android.view.View;

import com.wzy.passwordmanager.databinding.ItemMainBinding;

/**
 * Created by lmejojo on 2016/4/27 0027.
 */
public class MainBindRecyclerHolder extends RecyclerViewHolder{
    private ItemMainBinding itemMainBinding;

    public MainBindRecyclerHolder(View itemView) {
        super(itemView);
        itemMainBinding = ItemMainBinding.bind(itemView);
    }

    public ItemMainBinding getItemMainBinding(){
        return itemMainBinding;
    }
}
