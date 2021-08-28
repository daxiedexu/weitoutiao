package com.bw.mainpage.mvvm.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @ClassName VPAdapter
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/20 15:50
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class VPAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments;
    ArrayList<String> strings;

    public VPAdapter(@NonNull @NotNull FragmentManager fm, int behavior, ArrayList<Fragment> fragments) {
        super(fm, behavior);
        this.fragments=fragments;
    }

    public VPAdapter(@NonNull  FragmentManager fm, int behavior, ArrayList<Fragment> fragments, ArrayList<String> strings) {
        super(fm, behavior);
        this.fragments=fragments;
        this.strings=strings;
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


    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull  Object object) {
//        super.destroyItem(container, position, object);
    }
}
