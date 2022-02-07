package com.beckytech.galatoofibarumsaa.contactinfo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 1) {
            return new YoosaadFragment();
        }

        if (position == 2) {
            return new FacebookFragment();
        }

        return new YoutubeFragment();

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
