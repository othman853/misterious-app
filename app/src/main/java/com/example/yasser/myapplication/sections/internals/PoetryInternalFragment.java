package com.example.yasser.myapplication.sections.internals;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.data.Poetry;

/**
 * Created by yasser on 29/10/15.
 */
public class PoetryInternalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.poetry_internal, container, false);

        Poetry poetry = (Poetry) getArguments().getSerializable("poetry");

        ((TextView) view.findViewById(R.id.poetry_title)).setText(poetry.getTitle());
        ((TextView) view.findViewById(R.id.poetry_content)).setText(poetry.getContent());

        return view;
    }
}
