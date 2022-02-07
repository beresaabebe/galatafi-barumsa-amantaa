package com.beckytech.galatoofibarumsaa.galatamaariyaam;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.beckytech.galatoofibarumsaa.R;
import com.beckytech.galatoofibarumsaa.galatamaariyaam.services.GmYerooHundaaService;

public class GalataMaariyaamYerooHundaaFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galata_maariyaam_yeroo_hundaa, container, false);

        ImageView playMusic = view.findViewById(R.id.imageView_playMusic);

        playMusic.setOnClickListener(view1 -> {
            if (isServiceRunning(GmYerooHundaaService.class)) {
                getActivity().stopService(new Intent(getActivity(), GmYerooHundaaService.class));
                playMusic.setImageResource(R.drawable.ic_play);
                Toast.makeText(getActivity(), "Stopped!", Toast.LENGTH_SHORT).show();
            }
            else {
                getActivity().startService(new Intent(getActivity(), GmYerooHundaaService.class));
                playMusic.setImageResource(R.drawable.ic_pause);
                Toast.makeText(getActivity(), "Play", Toast.LENGTH_SHORT).show();
            }
        });

        WebView webView = view.findViewById(R.id.webView_galataMaariyaamYerooHundaa);
        webView.loadUrl("file:///android_asset/galatamaariyaam/kadhannaayeroohundaa.html");
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                webView.loadUrl("file:///android_asset/error.html");
                playMusic.setVisibility(View.GONE);
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