package com.meczyki.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.meczyki.fragments.MainFragment;
import com.meczyki.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Przemysław Skitał on 2016-07-17.
 */
public class MainViewPageAdapter extends FragmentPagerAdapter {
    private final List<String> fragmentTitleList = new ArrayList<>();

    public MainViewPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.fragmentTitleList.add("Ostatnie mecze");
        this.fragmentTitleList.add("Zapowiedzi meczowe");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                MainFragment mainFragment = new MainFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.BOX_INDEX, position);
                mainFragment.setArguments(bundle);
                return mainFragment;
            }
            case 1: {
                MainFragment mainFragment = new MainFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.BOX_INDEX, 2);
                mainFragment.setArguments(bundle);
                return mainFragment;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
