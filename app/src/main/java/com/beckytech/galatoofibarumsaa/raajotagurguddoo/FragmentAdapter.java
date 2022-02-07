package com.beckytech.galatoofibarumsaa.raajotagurguddoo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.beckytech.galatoofibarumsaa.malkaa.MalkaaEdoomFragment;
import com.beckytech.galatoofibarumsaa.malkaa.MalkaaMaariyaamFragment;
import com.beckytech.galatoofibarumsaa.malkaa.MalkaaaIyeesuusFragment;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 1) {
            return new ErmiasFragment();
        }

        if (position == 2) {
            return new HisqielFragment();
        }

        if (position == 3) {
            return new DanielFragment();
        }

        return new IsayasFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
