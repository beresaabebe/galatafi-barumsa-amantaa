package com.beckytech.galatoofibarumsaa.galatamaariyaam;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.material.tabs.TabLayout;

public class GalataMaariyaam extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_galata_maariyaam);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));

        tabLayout = findViewById(R.id.tab_galataMaariyaam);
        viewPager2 = findViewById(R.id.viewPager_galataMaariyaam);

        FragmentManager fm = getSupportFragmentManager();
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

    }
}
