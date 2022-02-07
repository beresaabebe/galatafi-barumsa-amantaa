package com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.beckytech.galatoofibarumsaa.R;
import com.beckytech.galatoofibarumsaa.galatamaariyaam.services.GmSanbataaXiqqaaService;
import com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso.services.Faaruu135Service;
import com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso.services.Faaruu24Service;
import com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso.services.YaaAbbaaKeenyaService;


public class Faaruu135Fragment extends Fragment {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faaruu135, container, false);

        ImageView playMusic = view.findViewById(R.id.playMusic);
        playMusic.setOnClickListener(view1 -> {
            if (isServiceRunning(Faaruu135Service.class)) {
                getActivity().stopService(new Intent(getActivity(), Faaruu135Service.class));
                playMusic.setImageResource(R.drawable.ic_play);
            }
            else {
                getActivity().startService(new Intent(getActivity(), Faaruu135Service.class));
                playMusic.setImageResource(R.drawable.ic_pause);
            }
        });
        WebView webView = view.findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/kadhannaabarbaachiso/faaruu135.html");
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
    private boolean isServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo serviceInfo : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(serviceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}