package com.example.yasser.myapplication.sections;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yasser.myapplication.R;
import com.example.yasser.myapplication.util.Animations;

/**
 * Created by yasser on 03/11/15.
 */
public class SplashFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_screen, container,false);

        Animations.fadeIn(view.findViewById(R.id.w),2000);
        Animations.fadeIn(view.findViewById(R.id.congratulations), 3000);
        return view;
    }
}
