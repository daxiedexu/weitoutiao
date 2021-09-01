package com.bw.mainpage.mvvm;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityHomeBinding;


import com.bw.mainpage.mvvm.Adapter.MyVpAdapter;
import com.bw.mainpage.mvvm.Adapter.VPAdapter;

import com.bw.mainpage.mvvm.Fragment.Fragment_Headline;
import com.bw.mainpage.mvvm.Fragment.Fragment_Home;
import com.bw.mainpage.mvvm.Fragment.Fragment_My;
import com.bw.mainpage.mvvm.Fragment.Fragment_Video;

import com.bw.mainpage.mvvm.RoomUtils.CacheDatabase;

import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseActivity;

import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;

import java.util.HashMap;

public class HomeActivity extends BaseActivity<NewListViewModel, ActivityHomeBinding> {


    private BottomNavigationBar mainBnb;
    private ViewPager mainVp;


    @Override
    protected void initEvent() {


            mainBnb=(BottomNavigationBar) findViewById(R.id.main_bnb);
            //mainTab=(SlidingTabLayout) findViewById(R.id.main_tab);
            mainVp=(ViewPager) findViewById(R.id.main_vp);


        ArrayList<Fragment> fragments=new ArrayList<>( );
        fragments.add(new Fragment_Home());
        fragments.add(new Fragment_Video());
        fragments.add(new Fragment_Headline());
        fragments.add(new Fragment_My());

        VPAdapter vpAdapter=new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        mainVp.setAdapter(vpAdapter);



            mainBnb.setMode(BottomNavigationBar.MODE_FIXED);
            mainBnb.setActiveColor(android.R.color.holo_red_dark);
            mainBnb.setInActiveColor(R.color.black);
            mainBnb.addItem(new BottomNavigationItem(R.drawable.home_24, "首页"))
                    .addItem(new BottomNavigationItem(R.drawable.video_24, "视频"))
                    .addItem(new BottomNavigationItem(R.drawable.message_24, "微头条"))
                    .addItem(new BottomNavigationItem(R.drawable.box_24, "我的"))
                    .initialise( );


//        mainBnb.selectTab(getIntent().getIntExtra("position",0));
        if (getIntent().getIntExtra("position",0)!=0){
            mainVp.setCurrentItem(2);
            mainBnb.selectTab(2);
        }

        mainVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    mainBnb.selectTab(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            mainBnb.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                @Override
                public void onTabSelected(int position) {
                    mainVp.setCurrentItem(position);
                }

                @Override
                public void onTabUnselected(int position) {

                }

                @Override
                public void onTabReselected(int position) {

                }
            });





    }


    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.HomeViewModel, mViewModel);
    }


        @Override
        protected NewListViewModel createViewModel () {
            return new NewListViewModel(this);
        }

        @Override
        protected int getLayout () {
            return R.layout.activity_home;
        }

        @Override
        protected void onDestroy () {
            super.onDestroy();
            CacheDatabase.getInstance(this).getCacheDao().deleteAll();
        }


        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        }
    }
