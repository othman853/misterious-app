package com.example.yasser.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.data.Poetry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yasser on 10/28/15.
 */
public class PoetryListAdapter extends BaseAdapter {

    private List<Poetry> poetries;
    private LayoutInflater inflater;
    private Activity activity;

    public PoetryListAdapter(Activity activity) {
        this.activity = activity;

        String [] serializedPoetries = activity.getResources().getStringArray(R.array.poetries);
        poetries = new ArrayList<>();

        for (String serializedPoetry : serializedPoetries) {
            poetries.add(new Poetry().deserialize(serializedPoetry));
        }
    }

    @Override
    public int getCount() {
        return poetries.size();
    }

    @Override
    public Object getItem(int position) {
        return poetries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.poetry_list_item, null);
        }

        Poetry poetry = poetries.get(position);

        TextView poetryTitle = (TextView) convertView.findViewById(R.id.poetry_title);

        poetryTitle.setText(poetry.getTitle());

        return convertView;
    }

}
