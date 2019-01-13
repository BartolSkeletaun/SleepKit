package com.sleepkit.app.sleepkit;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import static android.media.AudioAttributes.CONTENT_TYPE_MUSIC;
import static android.media.AudioAttributes.USAGE_MEDIA;

public class Home extends AppCompatActivity {

    // We will use a soundPool to handle Audio

    SoundPool soundPool;

    //Declare an integer variable for the SoundPool to play representing the Audio in raw folder

    private int sound1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Some version control

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            // new Audio Attributes builder to assign audio type

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(USAGE_MEDIA)
                    .setContentType(CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {

            //Some more version control

            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }

        //Load our audio from raw folder to sound1 integer

        sound1 = soundPool.load(this, R.raw.bs1, 1);


    }

    //On click method to start Audio - loop set to -1 for infinite looping

    public void playAudio(View view) {

        switch (view.getId()) {
            case R.id.button_play:
                soundPool.play(1, 1, 1, 0, -
                        1, 1);
                break;
        }

        //Some code to handle user input to edit text view count dowm timer

        TextView countdownText1 = findViewById(R.id.text_countdown);

        // declare string to accept user time input

        String myString = ((TextView)countdownText1).getText().toString();

        //create new variable countdownText1 to parse string

        int countdownMillis = Integer.parseInt(myString) * 1000;

        //parse input string to integer and multiply * 1000 for conversion to miliseconds

        //declare new countdown timer - pass the number of millis to the count down timer

            new CountDownTimer(countdownMillis, 1000) {
              TextView countdownText = findViewById(R.id.text_countdown);
                public void onTick(long millisUntilFinished) {
                    countdownText.setText("seconds remaining: " + millisUntilFinished / 1000);
                }

         // calling the onFinish method = on calling this method pause(stop) the audio stream

               public void onFinish() {
                    countdownText.setText("done!");
                    soundPool.autoPause();
                }
            }.start();




    }

    //code to handle pause button press

    public void pauseAudio(View view1) {
        switch (view1.getId()) {
            case R.id.button_pause:
            soundPool.autoPause();
            break;
        }
    }
}