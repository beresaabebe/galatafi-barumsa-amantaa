package com.beckytech.galatoofibarumsaa.seeraooritii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.material.tabs.TabLayout;

public class SeeraaOoritiiActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_seeraa_ooritii);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);


        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Musee"));
        tabLayout.addTab(tabLayout.newTab().setText("Ruut"));
        tabLayout.addTab(tabLayout.newTab().setText("Yoodit"));
        tabLayout.addTab(tabLayout.newTab().setText("Naabutee"));
        tabLayout.addTab(tabLayout.newTab().setText("Raajaa Eeliyaas"));
        tabLayout.addTab(tabLayout.newTab().setText("Raajaa Eelsaa"));
        tabLayout.addTab(tabLayout.newTab().setText("Iyyoob"));
        tabLayout.addTab(tabLayout.newTab().setText("Soosinnaa"));
        tabLayout.addTab(tabLayout.newTab().setText("Asteer"));

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