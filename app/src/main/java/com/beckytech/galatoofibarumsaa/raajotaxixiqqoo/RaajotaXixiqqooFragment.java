package com.beckytech.galatoofibarumsaa.raajotaxixiqqoo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beckytech.galatoofibarumsaa.R;
import com.google.android.material.tabs.TabLayout;

public class RaajotaXixiqqooFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    com.beckytech.galatoofibarumsaa.raajotaxixiqqoo.FragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_raajota_gurguddoo, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager2 = view.findViewById(R.id.viewPager);

        FragmentManager fm = getFragmentManager();
        adapter = new com.beckytech.galatoofibarumsaa.raajotaxixiqqoo.FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Hoosee"));
        tabLayout.addTab(tabLayout.newTab().setText("Amoos"));
        tabLayout.addTab(tabLayout.newTab().setText("Naahoom"));
        tabLayout.addTab(tabLayout.newTab().setText("Mikiyaas"));
        tabLayout.addTab(tabLayout.newTab().setText("Iyyue'eel"));
        tabLayout.addTab(tabLayout.newTab().setText("Abdiyyuu"));
        tabLayout.addTab(tabLayout.newTab().setText("Yoonaas"));
        tabLayout.addTab(tabLayout.newTab().setText("Inbaaqoom"));
        tabLayout.addTab(tabLayout.newTab().setText("Sofooniyaas"));
        tabLayout.addTab(tabLayout.newTab().setText("Haagee"));
        tabLayout.addTab(tabLayout.newTab().setText("Zakkaariyaas"));


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