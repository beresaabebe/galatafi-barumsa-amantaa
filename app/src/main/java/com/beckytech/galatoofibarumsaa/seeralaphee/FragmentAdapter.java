package com.beckytech.galatoofibarumsaa.seeralaphee;

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
            case 1: return new AbeelFragment();
            case 2: return new HeenokFragment();
            case 3: return new NoohFragment();
            case 4: return new MelkeseedeeqFragment();
            case 5: return new AbrahamFragment();
            case 6: return new LooxFragment();
            case 7: return new SaaraaFragment();
            case 8: return new YisihaaqFragment();
            case 9: return new YaiqobFragment();
            case 10: return new YooseefFragment();
        }

        return new AddaamFragment();

    }

    @Override
    public int getItemCount() {
        return 11;
    }
}
