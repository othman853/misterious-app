package com.example.yasser.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.yasser.myapplication.util.Animations;

public class SplashScreen extends Activity {

    private static final int TIMEOUT_IN_MILISECONDS = 3000;


    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.splash_screen);

        TextView w = (TextView)findViewById(R.id.w);
        TextView congratulations = (TextView)findViewById(R.id.congratulations);

        w.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        w.setShadowLayer(10, 1, 1, Color.BLACK);

//        UiHelper.hide(getWindow(), getActionBar());

        Animations.fadeIn(congratulations, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainActivityCall = new Intent(SplashScreen.this, MainActivity.class);

                startActivity(mainActivityCall);

                finish();
            }
        }, TIMEOUT_IN_MILISECONDS);
    }

}
