package com.wzy.passwordmanager.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wzy.passwordmanager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmejojo on 2016/5/12 0012.
 */
public class SpinnerAdapter extends BaseAdapter {

    private List contents = new ArrayList();
    private Context mContext;


    public SpinnerAdapter(Context context, List contents) {
        this.mContext = context;
        this.contents = contents;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public String getItem(int position) {
        if ((position >= 0) && (position < this.contents.size()))
            return (String) this.contents.get(position);
        return "";
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View type;
        if (convertView != null) {
            type = convertView;
            if (convertView.getTag().toString().equals("DROPDOWN")) ;
        } else {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            type = inflater.inflate(R.layout.spinner_item_actionbar, parent, false);
            type.setTag("DROPDOWN");
        }
        ((TextView) type.findViewById(R.id.text1)).setText(getItem(position));
        return type;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View type;
        if (convertView != null) {
            type = convertView;
            if (convertView.getTag().toString().equals("NON_DROPDOWN")) ;
        } else {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            type = inflater.inflate(R.layout.spinner_item_dropdown, parent, false);
            type.setTag("NON_DROPDOWN");
        }
        ((TextView) type.findViewById(R.id.text1)).setText(getItem(position));
        return type;
    }
}
