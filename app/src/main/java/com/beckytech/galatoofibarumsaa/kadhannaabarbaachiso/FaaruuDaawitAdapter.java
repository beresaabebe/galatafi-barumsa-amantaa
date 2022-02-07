package com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FaaruuDaawitAdapter extends FragmentStateAdapter {

    public FaaruuDaawitAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 1) {
            return new Faaruu50Fragment();
        }
        if (position == 2) {
            return new Faaruu90Fragment();
        }
        if (position == 3) {
            return  new Faaruu100Fragment();
        }
        if (position == 4) {
            return new Faaruu135Fragment();
        }

        return new Faaruu24Fragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
