package com.beckytech.galatoofibarumsaa;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.beckytech.galatoofibarumsaa.dirsaane.DirsaaneActivity;
import com.beckytech.galatoofibarumsaa.ergamoota.ErgamootaActivity;
import com.beckytech.galatoofibarumsaa.galatagooftaa.GalataGooftaaActivity;
import com.beckytech.galatoofibarumsaa.galatamaariyaam.GalataMaariyaam;
import com.beckytech.galatoofibarumsaa.hibuat.HibuatActivity;
import com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso.FaaruuDaawitActivity;
import com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso.KadhannaaBarbaachisoActivity;
import com.beckytech.galatoofibarumsaa.lixoonii.LixoonniiActivity;
import com.beckytech.galatoofibarumsaa.malkaa.MalkaaActivity;
import com.beckytech.galatoofibarumsaa.raajotagurguddoo.RaajotaGurgudooActivity;
import com.beckytech.galatoofibarumsaa.raajotaxixiqqoo.RaajotaXixiqqooActivity;
import com.beckytech.galatoofibarumsaa.seeralaphee.SeeraLapheeActivity;
import com.beckytech.galatoofibarumsaa.seeraooritii.SeeraaOoritiiActivity;
import com.beckytech.galatoofibarumsaa.waadaa.WaadaaActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeFragment extends Fragment {

    View view;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConnectivityManager cm = (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable() && !networkInfo.isFailover()) {
            view = inflater.inflate(R.layout.fragment_home, container, false);

            SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

            webView = view.findViewById(R.id.webViw_HomePage);
            webView.loadUrl("https://afanoromobatch.wordpress.com");
            webView.setVerticalScrollBarEnabled(true);
            webView.setHorizontalScrollBarEnabled(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });

            webView.canGoBack();
            webView.setOnKeyListener((view, keyCode, keyEvent) -> {
                if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getAction() ==
                        MotionEvent.ACTION_UP && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            });

            swipeRefreshLayout.setOnRefreshListener(() -> webView.reload());
        }
        else {
            view = inflater.inflate(R.layout.fragment_home_listview, container, false);

            String[] item = {"Galata Maariyaam", "Galataa Gooftaa",
                    "Galata Lixonii", "Galata Addaa - Malkaa",
                    "Kadhannaa Waadaa", "Kadhannaa Barbaachisoo",
                    "Faaruu Daawit",
                    "Dirsaane Ergamoota", "Ergamoota Qulqulluu",
                    "Barumsaa Hibuat", "Abboota Bara Seeraa Laphee",
                    "Abboota Bara Seeraa Ooritii", "Raajota Gurguddoo",
                    "Raajota Xixiqqoo"};

            ArrayList<String> listItem = new ArrayList<>(Arrays.asList(item));

            ListView listView = view.findViewById(R.id.listView_homePage);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, listItem);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener((adapterView, view1, position, length) -> {
                if (position == 0) {
                    startActivity(new Intent(getActivity(), GalataMaariyaam.class));
                }
                if (position == 1) {
                    startActivity(new Intent(getActivity(), GalataGooftaaActivity.class));
                }

                if (position == 2) {
                    startActivity(new Intent(getActivity(), LixoonniiActivity.class));
                }

                if (position == 3) {
                    startActivity(new Intent(getActivity(), MalkaaActivity.class));
                }

                if (position == 4) {
                    startActivity(new Intent(getActivity(), WaadaaActivity.class));
                }

                if (position == 5) {
                    startActivity(new Intent(getActivity(), KadhannaaBarbaachisoActivity.class));
                }

                if (position == 6) {
                    startActivity(new Intent(getActivity(), FaaruuDaawitActivity.class));
                }

                if (position == 7) {
                    startActivity(new Intent(getActivity(), DirsaaneActivity.class));
                }

                if (position == 8) {
                    startActivity(new Intent(getActivity(), ErgamootaActivity.class));
                }

                if (position == 9) {
                    startActivity(new Intent(getActivity(), HibuatActivity.class));
                }

                if (position == 10) {
                    startActivity(new Intent(getActivity(), SeeraLapheeActivity.class));
                }

                if (position == 11) {
                    startActivity(new Intent(getActivity(), SeeraaOoritiiActivity.class));
                }

                if (position == 12) {
                    startActivity(new Intent(getActivity(), RaajotaGurgudooActivity.class));
                }
                if (position == 13) {
                    startActivity(new Intent(getActivity(), RaajotaXixiqqooActivity.class));
                }
            });
        }
        return view;
    }
}