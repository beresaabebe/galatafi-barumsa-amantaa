package com.beckytech.galatoofibarumsaa.seeralaphee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.material.tabs.TabLayout;

public class SeeraLapheeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_seera_laphee);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Adaamiifi Hewaan"));
        tabLayout.addTab(tabLayout.newTab().setText("Abeel"));
        tabLayout.addTab(tabLayout.newTab().setText("Heenok"));
        tabLayout.addTab(tabLayout.newTab().setText("Nooh"));
        tabLayout.addTab(tabLayout.newTab().setText("Luba Melkeseedeeq"));
        tabLayout.addTab(tabLayout.newTab().setText("Abraham"));
        tabLayout.addTab(tabLayout.newTab().setText("Loox"));
        tabLayout.addTab(tabLayout.newTab().setText("Saaraa"));
        tabLayout.addTab(tabLayout.newTab().setText("Yisihaaq"));
        tabLayout.addTab(tabLayout.newTab().setText("Ya'iqoob"));
        tabLayout.addTab(tabLayout.newTab().setText("Yooseef"));

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