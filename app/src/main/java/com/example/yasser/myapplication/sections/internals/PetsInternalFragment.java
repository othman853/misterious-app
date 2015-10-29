package com.example.yasser.myapplication.sections.internals;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yasser.myapplication.R;

/**
 * Created by yasser on 10/29/15.
 */
public class PetsInternalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pets_internal, container, false);

        return view;
    }
}
