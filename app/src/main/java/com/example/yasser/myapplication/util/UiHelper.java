package com.example.yasser.myapplication.util;

import android.app.ActionBar;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;

/**
 * Created by yasser on 16/09/15.
 */
public class UiHelper {

    public static void hide(Window window, ActionBar actionBar){
        int uiOptions = window.getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled =
                ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);

        if (isImmersiveModeEnabled) {
            Log.i("UI_HIDE", "Turning immersive mode mode off. ");
        } else {
            Log.i("UI_HIDE", "Turning immersive mode mode on.");
        }

        // Navigation bar hiding:  Backwards compatible to ICS.
        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        // Status bar hiding: Backwards compatible to Jellybean
        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }

        // Immersive mode: Backward compatible to KitKat.
        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }

        window.getDecorView().setSystemUiVisibility(newUiOptions);
        actionBar.hide();
    }

}
