package com.example.yasser.myapplication.sections;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yasser.myapplication.R;

/**
 * Created by yasser on 10/27/15.
 */
public class HappyBirthdayFragment extends android.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.happy_birthday_fragment, container,false);

        return view;
    }
}
