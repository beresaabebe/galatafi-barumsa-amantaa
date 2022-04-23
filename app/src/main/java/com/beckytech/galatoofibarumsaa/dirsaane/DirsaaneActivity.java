package com.beckytech.galatoofibarumsaa.dirsaane;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;

public class DirsaaneActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    private static final String TAG = "FaaruuDaawitActivity";

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dirsaane);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Mikaa'el"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Gabri'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Faanu'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Raagu'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Rufaa'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Saaqu'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Qulqulluu Afinin"));
        tabLayout.addTab(tabLayout.newTab().setText("Ergamaa Waldaa Qulqulluu Ergamoota"));

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

    }
}