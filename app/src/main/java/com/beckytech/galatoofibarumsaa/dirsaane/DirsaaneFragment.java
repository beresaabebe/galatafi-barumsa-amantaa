package com.beckytech.galatoofibarumsaa.dirsaane;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.material.tabs.TabLayout;

public class DirsaaneFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dirsaane, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager2 = view.findViewById(R.id.viewPager);

        FragmentManager fm = getFragmentManager();
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

        return view;
    }
}