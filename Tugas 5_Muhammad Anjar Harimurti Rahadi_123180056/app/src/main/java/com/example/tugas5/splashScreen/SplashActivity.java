package com.example.tugas5.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.tugas5.MainActivity;
import com.example.tugas5.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(homeIntent);
            finish();
        }, SPLASH_TIME_OUT);
    }
}