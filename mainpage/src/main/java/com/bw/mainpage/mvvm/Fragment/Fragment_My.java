package com.bw.mainpage.mvvm.Fragment;

import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityHomeBinding;

import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseFragment;

import java.util.HashMap;

/**
 * @ClassName Fragment_My
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/28 8:43
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class Fragment_My extends BaseFragment<NewListViewModel,ActivityHomeBinding>{


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
        return R.layout.my_fragment;
    }
}
