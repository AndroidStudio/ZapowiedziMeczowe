package com.meczyki.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.meczyki.fragments.FootballPreviewsFragment;
import com.meczyki.fragments.FootballScoresFragment;
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
        this.fragmentTitleList.add("Zapowiedzi meczowe");
        this.fragmentTitleList.add("Ostatnie mecze");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                return new FootballPreviewsFragment();
            }
            case 1: {
                return new FootballScoresFragment();
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
