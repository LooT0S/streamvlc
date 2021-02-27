package com.ziuman.streamvlc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                finish();
            }
        };
        h.postDelayed(r, 5000);
    }
}