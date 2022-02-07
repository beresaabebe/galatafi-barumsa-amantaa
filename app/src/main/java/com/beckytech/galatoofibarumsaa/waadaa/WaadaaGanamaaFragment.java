package com.beckytech.galatoofibarumsaa.waadaa;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.beckytech.galatoofibarumsaa.R;

public class WaadaaGanamaaFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waadaa_ganamaa, container, false);

        WebView webView = view.findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/waadaa/ganama.html");
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                webView.loadUrl("file:///android_asset/error.html");
            }
        });
        return view;
    }
}