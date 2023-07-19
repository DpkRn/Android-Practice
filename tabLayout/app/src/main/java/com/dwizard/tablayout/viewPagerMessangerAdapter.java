package com.dwizard.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class viewPagerMessangerAdapter extends FragmentPagerAdapter {
    public viewPagerMessangerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public viewPagerMessangerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new ChatFragment();
        else if(position==1)
            return new StoryFragment();
            else
                return new CallFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return  "Chat";
        else if(position==1)
            return "Story";
        else
            return "Calls";

    }
}
