package com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TableLayout;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.material.tabs.TabLayout;

public class FaaruuDaawitActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FaaruuDaawitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_faaruu_daawit);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FaaruuDaawitAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Faaruu 24"));
        tabLayout.addTab(tabLayout.newTab().setText("Faaruu 50"));
        tabLayout.addTab(tabLayout.newTab().setText("Faaruu 90"));
        tabLayout.addTab(tabLayout.newTab().setText("Faaruu 101"));
        tabLayout.addTab(tabLayout.newTab().setText("Faaruu 135"));

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