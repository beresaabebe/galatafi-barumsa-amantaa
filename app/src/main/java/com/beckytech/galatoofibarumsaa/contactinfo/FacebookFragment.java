package com.beckytech.galatoofibarumsaa.contactinfo;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.beckytech.galatoofibarumsaa.R;

public class FacebookFragment extends Fragment {

    WebView webView;
    View view;
    ProgressDialog progressDialog;
    SwipeRefreshLayout swipeRefreshLayout;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_facebook, container, false);
        webView = view.findViewById(R.id.webView);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        webView.loadUrl("https://www.facebook.com/orthdoxmezmurofficial");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(getActivity());
                    progressDialog.setMessage("Loading please wait...");
                    progressDialog.show();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                swipeRefreshLayout.setRefreshing(false);
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }
        });

        webView.canGoBack();
        webView.setOnKeyListener((view1, keyCode, keyEvent) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getAction() ==
                    MotionEvent.ACTION_UP && webView.canGoBack()) {
                webView.goBack();
                return true;
            }
            return false;
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
            webView.reload();
        });

        return view;
    }
}