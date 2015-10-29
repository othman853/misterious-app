package com.example.yasser.myapplication.sections;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.yasser.myapplication.R;

/**
 * Created by yasser on 29/10/15.
 */
public class SurpriseVideoFragment extends Fragment {

    private MediaController videoControls;
    private VideoView video;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.surprise_video, container,false);

        if (videoControls == null) {
            videoControls = new MediaController(getActivity());
        }

        video = (VideoView) view.findViewById(R.id.suprise_video);

        try {
            video.setMediaController(videoControls);
            video.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video));
        } catch (Exception ex) {
            Log.e("Video Player", "Msg: " + ex.getMessage());
        }

        video.requestFocus();

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video.seekTo(0);
                video.start();
            }
        });

        return view;
    }
}
