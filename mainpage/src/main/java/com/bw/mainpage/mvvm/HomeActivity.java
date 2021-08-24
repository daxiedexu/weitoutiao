package com.bw.mainpage.mvvm;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bw.common.utils.StatusBarColorUtils;
import com.bw.http.RetrofitManger;
import com.bw.http.protocol.BaseRespEntity;
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
import com.bw.mainpage.mvvm.RoomUtils.CacheBean;
import com.bw.mainpage.mvvm.RoomUtils.CacheDatabase;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseActivity;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends BaseActivity<NewListViewModel, ActivityHomeBinding> {


    private BottomNavigationBar mainBnb;
    private SlidingTabLayout mainTab;
    private RecyclerView mainTabcs;
    private ViewPager mainVp;

    private EditText homeBtn;
    private android.widget.ImageView homeAdd;


    @Override
    protected void initEvent() {
        homeBtn = (EditText) findViewById(R.id.home_btn);
        homeAdd = (ImageView) findViewById(R.id.home_add);


        List<CacheBean> all=CacheDatabase.getInstance(this).getCacheDao( ).getAll( );

        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(HomeActivity.this, Color.RED);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(HomeActivity.this,false);

        homeBtn.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });


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
        strings.add("推荐");
        for (int i=0; i < all.size(); i++) {
            strings.add(all.get(i).classify);
        }


        strings.add("关注");
        strings.add("关注");
        strings.add("关注");
        strings.add("关注");



        int size=strings.size( );
        if(fragments.size()>size){
            for (int i=0; i <fragments.size()-size ; i++) {
                strings.add("添加");
            }
        }


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



        mainTab.getTitleView(0).setTextSize(24);
        mainTab.setOnTabSelectListener(new OnTabSelectListener( ) {
            @Override
            public void onTabSelect(int position) {

                for (int i=0; i < mainTab.getTabCount( ); i++) {
                    if(i==position){
                        mainTab.getTitleView(i).setTextSize(24);
                    }else {
                        mainTab.getTitleView(i).setTextSize(16);
                    }
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        homeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindow popupWindow = new PopupWindow(HomeActivity.this);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setOutsideTouchable(true);
                View inflate = LayoutInflater.from(HomeActivity.this).inflate(R.layout.item_pop, null);
                popupWindow.setContentView(inflate);
                popupWindow.showAsDropDown(v,0,0);

            }
        });
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

    @Override
    protected void onDestroy() {
        super.onDestroy( );
        CacheDatabase.getInstance(this).getCacheDao().deleteAll();
    }

}