package com.beckytech.galatoofibarumsaa.galatamaariyaam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;

public class GalataMaariyaamFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    private static final String TAG = "FaaruuDaawitActivity";

    private AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galata_maariyaam, container, false);

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        tabLayout = view.findViewById(R.id.tab_galataMaariyaam);
        viewPager2 = view.findViewById(R.id.viewPager_galataMaariyaam);

        FragmentManager fm = getFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Kadhannaa Yeroo Hundaa"));
        tabLayout.addTab(tabLayout.newTab().setText("Kadhannaa Kan Wiixata"));
        tabLayout.addTab(tabLayout.newTab().setText("Kadhannaa Kan Kibxataa"));
        tabLayout.addTab(tabLayout.newTab().setText("Kadhannaa Kan Roobii"));
        tabLayout.addTab(tabLayout.newTab().setText("Kadhannaa Kan Kamisaa"));
        tabLayout.addTab(tabLayout.newTab().setText("Kadhannaa Kan Jimaata"));
        tabLayout.addTab(tabLayout.newTab().setText("Kadhannaa Kan Sanbataa Xiqqaa"));
        tabLayout.addTab(tabLayout.newTab().setText("Kadhannaa Kan Dilbataa"));
        tabLayout.addTab(tabLayout.newTab().setText("Baha Ifaa"));
        tabLayout.addTab(tabLayout.newTab().setText("Galata Ergamoota"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return view;
    }
}