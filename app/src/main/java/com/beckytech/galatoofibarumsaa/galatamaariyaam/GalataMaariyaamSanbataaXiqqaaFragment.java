package com.beckytech.galatoofibarumsaa.galatamaariyaam;

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
import com.beckytech.galatoofibarumsaa.galatamaariyaam.services.GmYerooHundaaService;

public class GalataMaariyaamSanbataaXiqqaaFragment extends Fragment {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galata_maariyaam_sanbataa_xiqqaa, container, false);
        ImageView playMusic = view.findViewById(R.id.imageView_playMusic);

        playMusic.setOnClickListener(view1 -> {
            if (isServiceRunning(GmSanbataaXiqqaaService.class)) {
                getActivity().stopService(new Intent(getActivity(), GmSanbataaXiqqaaService.class));
                playMusic.setImageResource(R.drawable.ic_play);
                Toast.makeText(getActivity(), "Stopped!", Toast.LENGTH_SHORT).show();
            }
            else {
                getActivity().startService(new Intent(getActivity(), GmSanbataaXiqqaaService.class));
                playMusic.setImageResource(R.drawable.ic_pause);
                Toast.makeText(getActivity(), "Play", Toast.LENGTH_SHORT).show();
            }
        });

        WebView webView = view.findViewById(R.id.webView_galataMaariyaamSanbataaXiqqaa);
        webView.loadUrl("file:///android_asset/galatamaariyaam/sanbataa.html");
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