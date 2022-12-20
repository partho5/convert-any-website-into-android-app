package com.example.websitetoapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    String websiteUrl = "https://www.flipkart.com";

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide(); /* makes the app fullscreen */

        webView = findViewById(R.id.mainWV);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(websiteUrl);
        webView.setWebViewClient(new WebViewClient());

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch (keyCode){
                case KeyEvent.KEYCODE_BACK:
                    if(webView.canGoBack()){
                        webView.goBack();
                    }else{
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}