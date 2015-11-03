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

import java.io.Serializable;

/**
 * Created by yasser on 10/27/15.
 */
public class PetsFragment extends Fragment implements AdapterView.OnItemClickListener{

    PetsListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pets_fragment, container,false);

        adapter = new PetsListAdapter(getActivity());

        ListView petsListView = (ListView) view.findViewById(R.id.pets_list_view);
        petsListView.setAdapter(adapter);
        petsListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment internal = new PetsInternalFragment();

        Bundle arguments = new Bundle();
        arguments.putSerializable("pet", (Serializable) adapter.getItem(position));

        internal.setArguments(arguments);

        transaction
                .replace(R.id.main_content, internal)
                .addToBackStack(Constants.FragmentTags.PETS)
                .commit();
        Log.i("suo", "A pet click");
    }
}
