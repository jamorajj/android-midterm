package com.example.midtermtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView tvDevelopedBy;
    private Handler handler;
    private Runnable runnable;
    private boolean hasResumed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tvDevelopedBy = findViewById(R.id.tvSplashDevBy);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };

        tvDevelopedBy.setOnClickListener(view -> {
            Intent intent = new Intent(SplashActivity.this, WebViewActivity.class);
            startActivity(intent);

            handler.removeCallbacks(runnable);
        });

        handler.postDelayed(runnable, 5000);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(hasResumed){
            handler.postDelayed(runnable, 5000);
        }
        hasResumed = true;
    }
}