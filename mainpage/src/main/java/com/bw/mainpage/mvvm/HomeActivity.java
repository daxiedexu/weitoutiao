package com.bw.mainpage.mvvm;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bw.common.utils.StatusBarColorUtils;
import com.bw.http.RetrofitManger;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityHomeBinding;
import com.bw.mainpage.mvvm.Adapter.VPAdapter;
import com.bw.mainpage.mvvm.Fragment.Attention_fragment;
import com.bw.mainpage.mvvm.Fragment.Cate_fragment;
import com.bw.mainpage.mvvm.Fragment.Finance_fragment;
import com.bw.mainpage.mvvm.Fragment.History_fragment;
import com.bw.mainpage.mvvm.Fragment.Hot_fragment;
import com.bw.mainpage.mvvm.Fragment.Recommend_fragment;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseActivity;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends BaseActivity<NewListViewModel, ActivityHomeBinding> {


    private BottomNavigationBar mainBnb;
    private SlidingTabLayout mainTab;
    private RecyclerView mainTabcs;
    private ViewPager mainVp;


    @Override
    protected void initEvent() {
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .newList(1,1,10)
                .observe(HomeActivity.this, new Observer<NewListEntity>() {
                    @Override
                    public void onChanged(NewListEntity newListEntity) {
                        Toast.makeText(HomeActivity.this, newListEntity.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(HomeActivity.this, Color.RED);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(HomeActivity.this,false);




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
        strings.add("关注");
        strings.add("关注");
        strings.add("关注");
        strings.add("关注");
        strings.add("关注");
        strings.add("关注");



        VPAdapter vpAdapter=new VPAdapter(getSupportFragmentManager( ), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments,strings);
        mainVp.setAdapter(vpAdapter);
        mainTab.setViewPager(mainVp);


        mainBnb.setMode(BottomNavigationBar.MODE_FIXED);
        mainBnb.setActiveColor(android.R.color.holo_red_dark);
        mainBnb.setInActiveColor(R.color.black);
        mainBnb.addItem(new BottomNavigationItem(R.drawable.home_24,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.video_24,"视频"))
                .addItem(new BottomNavigationItem(R.drawable.message_24,"微头条"))
                .addItem(new BottomNavigationItem(R.drawable.box_24,"我的"))
                .initialise();
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.HomeViewModel,mViewModel);
    }

    @Override
    protected NewListViewModel createViewModel() {
        return new NewListViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }
}