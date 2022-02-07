package com.beckytech.galatoofibarumsaa.raajotagurguddoo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beckytech.galatoofibarumsaa.R;
import com.beckytech.galatoofibarumsaa.malkaa.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class RaajotaGurguddooFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    com.beckytech.galatoofibarumsaa.raajotagurguddoo.FragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_raajota_gurguddoo, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager2 = view.findViewById(R.id.viewPager);

        FragmentManager fm = getFragmentManager();
        adapter = new com.beckytech.galatoofibarumsaa.raajotagurguddoo.FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Raajaa Isaayaas"));
        tabLayout.addTab(tabLayout.newTab().setText("Raajaa Ermiyaas"));
        tabLayout.addTab(tabLayout.newTab().setText("Raajaa Hisqi'el"));
        tabLayout.addTab(tabLayout.newTab().setText("Raajaa Dani'el"));

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