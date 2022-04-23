package com.beckytech.galatoofibarumsaa.ergamoota;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;

public class ErgamootaFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    com.beckytech.galatoofibarumsaa.ergamoota.FragmentAdapter adapter;

    private static final String TAG = "FaaruuDaawitActivity";

    private AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ergamoota, container, false);

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager2 = view.findViewById(R.id.viewPager);

        FragmentManager fm = getFragmentManager();
        adapter = new com.beckytech.galatoofibarumsaa.ergamoota.FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Mika'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Gabri'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Faanu'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Rufaa'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Uraa'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Raagu'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Surafeel - Luboota samii 24'n"));
        tabLayout.addTab(tabLayout.newTab().setText("Kiruubel"));


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