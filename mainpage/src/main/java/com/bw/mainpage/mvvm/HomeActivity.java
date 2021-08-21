package com.bw.mainpage.mvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bw.mainpage.R;
import com.bw.mainpage.mvvm.Adapter.VPAdapter;
import com.bw.mainpage.mvvm.Fragment.Attention_fragment;
import com.bw.mainpage.mvvm.Fragment.Cate_fragment;
import com.bw.mainpage.mvvm.Fragment.Finance_fragment;
import com.bw.mainpage.mvvm.Fragment.History_fragment;
import com.bw.mainpage.mvvm.Fragment.Hot_fragment;
import com.bw.mainpage.mvvm.Fragment.Recommend_fragment;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationBar mainBnb;
    private SlidingTabLayout mainTab;
    private RecyclerView mainTabcs;
    private ViewPager mainVp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mainTab = (SlidingTabLayout) findViewById(R.id.main_tab);
        mainVp = (ViewPager) findViewById(R.id.main_vp);
        mainBnb = (BottomNavigationBar) findViewById(R.id.main_bnb);

        ArrayList<Fragment> fragments=new ArrayList<>( );
        fragments.add(new Attention_fragment());
        fragments.add(new Cate_fragment());
        fragments.add(new Finance_fragment());
        fragments.add(new History_fragment());
        fragments.add(new Hot_fragment());
        fragments.add(new Recommend_fragment());

        ArrayList<String> strings=new ArrayList<>( );
        strings.add("dsdsd");
        strings.add("dsdsd");
        strings.add("dsdsd");
        strings.add("dsdsd");
        strings.add("dsdsd");
        strings.add("dsdsd");


        VPAdapter vpAdapter=new VPAdapter(getSupportFragmentManager( ), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments,strings);
        mainVp.setAdapter(vpAdapter);
        mainTab.setViewPager(mainVp);

        mainBnb.addItem(new BottomNavigationItem(R.drawable.ic_launcher_background,"11"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background,"11"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background,"11"))
                .initialise();

    }


}