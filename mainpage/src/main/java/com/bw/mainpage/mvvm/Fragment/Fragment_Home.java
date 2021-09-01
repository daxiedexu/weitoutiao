package com.bw.mainpage.mvvm.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bw.common.utils.StatusBarColorUtils;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityHomeBinding;

import com.bw.mainpage.mvvm.Adapter.VPAdapter;
import com.bw.mainpage.mvvm.HomeActivity;
import com.bw.mainpage.mvvm.RoomUtils.CacheBean;
import com.bw.mainpage.mvvm.RoomUtils.CacheDatabase;
import com.bw.mainpage.mvvm.SearchActivity;
import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseFragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Fragment_Home
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/28 8:34
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class Fragment_Home  extends BaseFragment<NewListViewModel,ActivityHomeBinding>{
    private ImageView homeShare;
    private SlidingTabLayout mainTab;
    private ViewPager mainVp;
    private EditText homeBtn;
    private android.widget.ImageView homeAdd;

    @Override
    protected void initEvent() {
        homeBtn = (EditText) getActivity().findViewById(R.id.home_btn);
        homeAdd = (ImageView) getActivity().findViewById(R.id.home_add);
        homeShare = (ImageView) getActivity().findViewById(R.id.home_share);
        List<CacheBean> all = CacheDatabase.getInstance(getActivity()).getCacheDao().getAll();

        //homeAdd=(ImageView) findViewById(R.id.home_add);
        mainVp=(ViewPager) getActivity().findViewById(R.id.home_vp);
        mainTab = (SlidingTabLayout) getActivity().findViewById(R.id.main_tab);
        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(getActivity(), Color.RED);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(getActivity(), false);

        // 在调用TBS初始化、创建WebView之前进行如下配置
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });




        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Attention_fragment());
        fragments.add(new Cate_fragment());
        fragments.add(new Finance_fragment());
        fragments.add(new History_fragment());
        fragments.add(new Hot_fragment());
        fragments.add(new Recommend_fragment());

        ArrayList<String> strings = new ArrayList<>();
        strings.add("关注");
        strings.add("推荐");
        for (int i = 0; i < all.size(); i++) {
            strings.add(all.get(i).classify);
        }

        int size = strings.size();
        if (fragments.size() > size) {
            for (int i = 0; i < fragments.size() - size; i++) {
                strings.add("添加");
            }
        }


        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments, strings);
        mainVp.setAdapter(vpAdapter);
        mainTab.setViewPager(mainVp);




        mainTab.getTitleView(0).setTextSize(24);
        mainTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

                for (int i = 0; i < mainTab.getTabCount(); i++) {
                    if (i == position) {
                        mainTab.getTitleView(i).setTextSize(24);
                    } else {
                        mainTab.getTitleView(i).setTextSize(16);
                    }
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mainTab.getTabCount(); i++) {
                    if (i == position) {
                        mainTab.getTitleView(i).setTextSize(24);
                    } else {
                        mainTab.getTitleView(i).setTextSize(16);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        UMImage image = new UMImage(getActivity(), R.drawable.box_24);//本地文件
        homeShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(getActivity()).withMedia(image).setDisplayList(SHARE_MEDIA.QZONE, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {

                            }
                        }).open();
            }
        });


        homeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindow popupWindow = new PopupWindow(getActivity());
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setOutsideTouchable(true);
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.item_pop, null);
                popupWindow.setContentView(inflate);
                popupWindow.showAsDropDown(v, 0, 0);

            }
        });

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.HomeViewModel, mViewModel);
    }

    @Override
    protected NewListViewModel createViewModel() {
        return new NewListViewModel(getActivity());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }




}
