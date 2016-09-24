/**
 * Copyright (c) 2016, ZhouYang Wu 吴洲洋.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wzy.passwordmanager.mvp.ui.adapter.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * RecyclerView的万能适配器，适配任何一个RecyclerView
 *
 * Created by lmejojo on 2016/04/26.
 */
public abstract class BaseBindRecyclerAdapter<T> extends RecyclerView.Adapter<MainBindRecyclerHolder>{
    protected List<T> realDatas;
    protected final int mItemLayoutId;
    protected boolean isScrolling;
    protected Context cxt;
    protected boolean isLoadImage;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View view, Object data, int position);
    }

    public BaseBindRecyclerAdapter(RecyclerView v, Collection<T> datas, int itemLayoutId) {
        if (datas == null) {
            realDatas = new ArrayList<>();
        } else if (datas instanceof List) {
            realDatas = (List<T>) datas;
        } else {
            realDatas = new ArrayList<>(datas);
        }
        mItemLayoutId = itemLayoutId;
        cxt = v.getContext();
        v.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                isScrolling = !(newState == RecyclerView.SCROLL_STATE_IDLE);
                if (!isScrolling) {
                    //notifyDataSetChanged();
                }
            }
        });
    }

    /**
     * Recycler适配器填充方法
     *
     * @param holder      viewholder
     * @param item        javabean
     * @param isScrolling RecyclerView是否正在滚动
     */
    public abstract void convert(MainBindRecyclerHolder holder, T item, int position, boolean isScrolling);

    @Override
    public MainBindRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cxt);
        View root = inflater.inflate(mItemLayoutId, parent, false);
        return new MainBindRecyclerHolder(root);
    }

    @Override
    public void onBindViewHolder(MainBindRecyclerHolder holder, int position) {
        convert(holder, realDatas.get(position), position, isScrolling);
        holder.itemView.setOnClickListener(getOnClickListener(position));
    }

    @Override
    public int getItemCount() {
        return realDatas.size();
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        listener = l;
    }

    public View.OnClickListener getOnClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(@Nullable View v) {
                if (listener != null && v != null) {
                    listener.onItemClick(v, realDatas.get(position), position);
                }
            }
        };
    }

    public BaseBindRecyclerAdapter<T> refresh(Collection<T> datas) {
        if (datas == null) {
            realDatas = new ArrayList<>();
        } else if (datas instanceof List) {
            realDatas = (List<T>) datas;
        } else {
            realDatas = new ArrayList<>(datas);
        }
        return this;
    }
}
