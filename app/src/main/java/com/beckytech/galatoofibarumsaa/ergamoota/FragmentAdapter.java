package com.beckytech.galatoofibarumsaa.ergamoota;

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
            case 1: return new ErgamaaGabrieelFragment();
            case 2: return new ErgamaaFaanuelFragment();
            case 3: return new RufaaelFragment();
            case 4: return new UraelFragment();
            case 5: return new ErgamaaRaaguelFragment();
            case 6: return new SurafelFragment();
            case 7: return new KiruubelFragment();
        }
        return new ErgamaaMikaeelFragment();
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
