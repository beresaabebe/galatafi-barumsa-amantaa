package com.beckytech.galatoofibarumsaa.seeraooritii;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.beckytech.galatoofibarumsaa.seeralaphee.AbeelFragment;
import com.beckytech.galatoofibarumsaa.seeralaphee.AddaamFragment;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 1: return new RuutFragment();
            case 2: return new YooditFragment();
            case 3: return new NaabuteeFragment();
            case 4: return new EeliyaasFragment();
            case 5: return new EelsaaFragment();
            case 6: return new IyyoobFragment();
            case 7: return new SoosinnaaFragment();
            case 8: return new AsterFragment();
        }

        return new MuseeFragment();
    }

    @Override
    public int getItemCount() {
        return 9;
    }
}
