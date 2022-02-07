package com.beckytech.galatoofibarumsaa.hibuat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beckytech.galatoofibarumsaa.R;
import com.beckytech.galatoofibarumsaa.galatamaariyaam.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class HibuatFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    com.beckytech.galatoofibarumsaa.hibuat.FragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galata_maariyaam, container, false);

        tabLayout = view.findViewById(R.id.tab_galataMaariyaam);
        viewPager2 = view.findViewById(R.id.viewPager_galataMaariyaam);

        FragmentManager fm = getFragmentManager();
        adapter = new com.beckytech.galatoofibarumsaa.hibuat.FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Kutaa 1ffaa"));
        tabLayout.addTab(tabLayout.newTab().setText("Kutaa 2ffaa"));

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