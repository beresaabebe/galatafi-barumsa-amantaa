package com.beckytech.galatoofibarumsaa.raajotaxixiqqoo;

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
            case 1: return new AmoosFragment();
            case 2: return new NaahoomFragment();
            case 3: return new MilkiyasFragment();
            case 4: return new IyyuelFragment();
            case 5: return new AbdiyyuuFragment();
            case 6: return new YoonaasFragment();
            case 7: return new InbaaqomFragment();
            case 8: return new SofooniyaasFragment();
            case 9: return new HaageeFragment();
            case 10: return new ZakariasFragment();
        }

        return new HooseeFragment();
    }

    @Override
    public int getItemCount() {
        return 11;
    }
}
