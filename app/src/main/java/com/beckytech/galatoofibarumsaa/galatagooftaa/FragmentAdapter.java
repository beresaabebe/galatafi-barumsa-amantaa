package com.beckytech.galatoofibarumsaa.galatagooftaa;

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
            case 1: return new GooftaaWiixataaFragment();
            case 2: return new GooftaaKibxataaFragment();
            case 3: return new GooftaaRoobiiFragment();
            case 4: return new GooftaaKamisaaFragment();
            case 5: return new GooftaaJimaataFragment();
            case 6: return new GooftaaSanbataaFragment();
            case 7: return new GooftaaDilbataaFragment();
        }

        return new GooftaaYerooFragment();
    }

    @Override
    public int getItemCount() {
        return 9;
    }
}
