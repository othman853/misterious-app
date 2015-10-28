package com.example.yasser.myapplication.sections;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.adapters.ForestListAdapter;

import java.util.List;

/**
 * Created by yasser on 10/27/15.
 */
public class ForestFragment extends Fragment implements AdapterView.OnItemClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forest_fragment, container,false);

        ListView forestListView = (ListView) view.findViewById(R.id.forest_list_view);
        forestListView.setAdapter(new ForestListAdapter(getActivity()));
        forestListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("sup", "Forest Click");
    }
}
