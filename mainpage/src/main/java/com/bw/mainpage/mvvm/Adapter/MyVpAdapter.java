package com.bw.mainpage.mvvm.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @ClassName MyVpAdapter
 * @Author 孔晨亮
 * @Date 2021/8/28 11:18
 * User: msi
 */
public class MyVpAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    public MyVpAdapter(@NonNull FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
