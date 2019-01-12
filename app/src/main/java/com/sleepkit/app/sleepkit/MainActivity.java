package com.sleepkit.app.sleepkit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button_Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openActivity2();

            }

        });

        button_Home = findViewById(R.id.button_home);
        ((View) button_Home).setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                openActivity3();
            }

        });



    }


    public void openActivity2() {
        Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);


    }

    public void openActivity3() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);


    }

}