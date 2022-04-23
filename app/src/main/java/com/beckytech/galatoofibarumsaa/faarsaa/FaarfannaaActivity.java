package com.beckytech.galatoofibarumsaa.faarsaa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FaarfannaaActivity extends AppCompatActivity {

    WebView webView;

    private static final String TAG = "FaaruuDaawitActivity";

    private AdView mAdView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faarfannaa);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        webView = findViewById(R.id.faarfanaaWeb);
        webView.loadUrl("https://www.youtube.com/c/RoobaaNuuf");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                webView.loadUrl("file:///android_asset/error.html");
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        }
    }
}