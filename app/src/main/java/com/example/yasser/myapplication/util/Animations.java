package com.example.yasser.myapplication.util;

import android.view.View;
import android.view.animation.AlphaAnimation;

/**
 * Created by yasser on 25/09/15.
 */
public class Animations {

    public static final int FADE_LONG = 1200;
    public static final int FADE_SHORT = 900;

    public static void fadeIn(View view){
        fadeIn(view, FADE_SHORT);
    }

    public static void fadeOut(View view){
        fadeOut(view, FADE_SHORT);
    }

    public static void fadeIn(View view, int duration){
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        fadeIn.setDuration(duration);
        fadeIn.setFillAfter(true);

        view.startAnimation(fadeIn);
    }

    public static void fadeOut(View view, int duration){
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f , 0.0f ) ;
        fadeOut.setDuration(duration);
        fadeOut.setFillAfter(true);

        view.startAnimation(fadeOut);
    }
}
