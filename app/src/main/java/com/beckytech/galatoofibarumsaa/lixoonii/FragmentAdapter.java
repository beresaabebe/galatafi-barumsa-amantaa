package com.beckytech.galatoofibarumsaa.lixoonii;

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

        switch (position) {
            case 1: return new LixoonniiKibxataaFragment();
            case 2: return new LixoonniiRoobiiFragment();
            case 3: return new LixoonniKamisaaFragment();
            case 4: return new LixonniiJimaataFragment();
            case 5: return new LixoonniiSanbataaFragment();
            case 6: return new LixonniiDilbataaFragment();
        }

        return new LixoonniiWiixataFragment();
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
