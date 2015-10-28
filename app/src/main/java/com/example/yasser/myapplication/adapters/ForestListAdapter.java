package com.example.yasser.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.data.ForestSpot;
import com.example.yasser.myapplication.data.Poetry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yasser on 10/28/15.
 */
public class ForestListAdapter extends BaseAdapter{

    private List<ForestSpot> forestSpots;
    private Activity activity;
    private LayoutInflater inflater;

    public ForestListAdapter(Activity activity) {
        this.activity = activity;
        forestSpots = new ArrayList<>();

        String [] spots = activity.getResources().getStringArray(R.array.forest_spots);

        for (String spot : spots) {
            forestSpots.add(new ForestSpot().deserialize(spot));
        }
    }

    @Override
    public int getCount() {
        return forestSpots.size();
    }

    @Override
    public Object getItem(int position) {
        return forestSpots.get(position);
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
            convertView = inflater.inflate(R.layout.forest_list_item, null);
        }

        ForestSpot spot = forestSpots.get(position);

        TextView forestSpotName = (TextView) convertView.findViewById(R.id.forest_spot_name);

        forestSpotName.setText(spot.getName());

        return convertView;
    }
}
