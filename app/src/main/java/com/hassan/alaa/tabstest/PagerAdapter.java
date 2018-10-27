package com.hassan.alaa.tabstest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                FragmentA a = new FragmentA();
                return a;
            case 1:
                FragmentB b = new FragmentB();
                return b;
            case 2:
                FragmentC c = new FragmentC();
                return c;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
