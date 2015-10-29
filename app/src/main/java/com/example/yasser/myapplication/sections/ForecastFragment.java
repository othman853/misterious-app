package com.example.yasser.myapplication.sections;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.yasser.myapplication.R;

/**
 * Created by yasser on 10/28/15.
 */
public class ForecastFragment extends Fragment implements View.OnClickListener {

    private ImageView forecastIcon;
    private ToggleButton forecastToggle;
    private TextView forecastText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forecast_fragment, container,false);
        forecastToggle = (ToggleButton) view.findViewById(R.id.forecast_toggle);
        forecastToggle.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        ToggleButton button = (ToggleButton) v;
        boolean checked = button.isChecked();

        forecastIcon = (ImageView) getActivity().findViewById(R.id.forecast_icon);
        forecastText = (TextView) getActivity().findViewById(R.id.forecast_text);

        if(checked){
            forecastIcon.setImageResource(R.drawable.sun);
            forecastText.setText(getActivity().getString(R.string.day_forecast));
        } else {
            forecastIcon.setImageResource(R.drawable.star);
            forecastText.setText(getActivity().getString(R.string.night_forecast));
        }

    }
}
