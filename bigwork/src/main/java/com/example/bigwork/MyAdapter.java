package com.example.bigwork;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 这是个可以多次复用的工具类
 * 可以作为所有的TabLayout的Adapter
 */

public class MyAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    ArrayList<String> title;
    public MyAdapter(FragmentManager fm,ArrayList<Fragment> fragments,ArrayList<String> title){
        super(fm);
        this.fragments=fragments;
        this.title=title;
    }
    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }
    @Override
    public int getCount(){
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
