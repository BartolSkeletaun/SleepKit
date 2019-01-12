package com.sleepkit.app.sleepkit;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;

import java.lang.annotation.Target;

import static android.media.AudioAttributes.CONTENT_TYPE_MUSIC;
import static android.media.AudioAttributes.USAGE_MEDIA;

public class Home extends AppCompatActivity {

    SoundPool soundPool;
    private int sound1;


    public void pauseAudio(View view) {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(USAGE_MEDIA)
                    .setContentType(CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }
        sound1 = soundPool.load(this, R.raw.bs1, 1);



    }


    public void playAudio(View view) {
        switch (view.getId()) {
            case R.id.button_play:
                soundPool.play(1, 1, 1, 0, -
                        1, 1);
                break;
        }


    }
}