package com.example.midtermtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wb = findViewById(R.id.webView);
        // wb.loadUrl("https://www.ais.ac.nz/");
        // AIS website not working; workaround is google.com
        wb.loadUrl("https://www.google.com/");
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());
    }
}