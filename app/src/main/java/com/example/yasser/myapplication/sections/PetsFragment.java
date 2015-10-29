package com.example.yasser.myapplication.sections;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.adapters.PetsListAdapter;
import com.example.yasser.myapplication.sections.internals.PetsInternalFragment;
import com.example.yasser.myapplication.sections.internals.PoetryInternalFragment;
import com.example.yasser.myapplication.util.Constants;

/**
 * Created by yasser on 10/27/15.
 */
public class PetsFragment extends Fragment implements AdapterView.OnItemClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pets_fragment, container,false);

        ListView petsListView = (ListView) view.findViewById(R.id.pets_list_view);
        petsListView.setAdapter(new PetsListAdapter(getActivity()));
        petsListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction
                .replace(R.id.main_content, new PetsInternalFragment())
                .addToBackStack(Constants.FragmentTags.PETS)
                .commit();
        Log.i("suo", "A pet click");
    }
}
