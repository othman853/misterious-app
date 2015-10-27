package com.example.yasser.myapplication.sections;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.listeners.GenerateLuckNumberButtonClickListener;

/**
 * Created by yasser on 10/27/15.
 */
public class NumbersFragment extends Fragment {
    private GenerateLuckNumberButtonClickListener generateNumberButtonListener;
    private View generateNumberButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numbers_fragment, container,false);

        generateNumberButtonListener = new GenerateLuckNumberButtonClickListener(view);
        generateNumberButton = view.findViewById(R.id.btn_generate_luck_number);
        generateNumberButton.setOnClickListener(generateNumberButtonListener);

        return view;
    }
}
