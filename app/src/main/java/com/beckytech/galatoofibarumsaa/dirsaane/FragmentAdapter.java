package com.beckytech.galatoofibarumsaa.dirsaane;

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
            case 1: return new DirsaaneGabrielFragment();
            case 2: return new DirsaaneFaanuelFragment();
            case 3: return new DirsaaneRaaguelFragment();
            case 4: return new DirsaaneRufaaelFragment();
            case 5: return new DirsaaneSaquelFragment();
            case 6: return new DirsaaneAfiniinFragment();
            case 7: return new DirsaaneWaldaaFragment();
        }
        return new DirsaaneMikaaelFragment();
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
