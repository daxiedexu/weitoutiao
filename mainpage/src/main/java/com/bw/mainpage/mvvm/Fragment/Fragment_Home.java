package com.bw.mainpage.mvvm.Fragment;

import androidx.fragment.app.Fragment;

import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityHomeBinding;

import com.bw.mainpage.mvvm.RoomUtils.CacheBean;
import com.bw.mainpage.mvvm.RoomUtils.CacheDatabase;
import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseFragment;

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


    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {

    }

    @Override
    protected NewListViewModel createViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }


//
//
//        List<CacheBean> all=CacheDatabase.getInstance(getContext()).getCacheDao( ).getAll( );
//
//        ArrayList<Fragment> fragments=new ArrayList<>( );
//        fragments.add(new Attention_fragment( ));
//        fragments.add(new Cate_fragment( ));
//        fragments.add(new Finance_fragment( ));
//        fragments.add(new History_fragment( ));
//        fragments.add(new Hot_fragment( ));
//        fragments.add(new Recommend_fragment( ));
//
//        ArrayList<String> strings=new ArrayList<>( );
//        strings.add("关注");
//        strings.add("推荐");
//        for (int i=0; i < all.size( ); i++) {
//            strings.add(all.get(i).classify);
//        }
//
//        int size=strings.size( );
//        if (fragments.size( ) > size) {
//            for (int i=0; i < fragments.size( ) - size; i++) {
//                strings.add("添加");
//            }
//        }



}
