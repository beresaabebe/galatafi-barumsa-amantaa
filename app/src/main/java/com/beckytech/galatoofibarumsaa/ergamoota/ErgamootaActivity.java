package com.beckytech.galatoofibarumsaa.ergamoota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.material.tabs.TabLayout;

public class ErgamootaActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    com.beckytech.galatoofibarumsaa.ergamoota.FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ergamoota);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();
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
    }
}