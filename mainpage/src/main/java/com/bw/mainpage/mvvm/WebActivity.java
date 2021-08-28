package com.bw.mainpage.mvvm;

import android.content.Intent;
import android.widget.Toast;

import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.WebBinding;
import com.bw.mainpage.mvvm.entity.NewsDetailEntity;
import com.bw.mainpage.mvvm.viewmodel.NewListViewModel;
import com.bw.mvvm_core.view.BaseActivity;

import java.util.HashMap;

/**
 * @ClassName WebActivity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/25 19:31
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class WebActivity extends BaseActivity<NewListViewModel,WebBinding>  {


    @Override
    protected void initEvent() {
        Intent intent=getIntent( );
        NewsDetailEntity.DataBean newsDetail=intent.getParcelableExtra("newsDetail");
        Toast.makeText(this, newsDetail.url+"", Toast.LENGTH_SHORT).show( );
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.WebViewModel,mViewModel);
    }

    @Override
    protected NewListViewModel createViewModel() {
        return new NewListViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.web;
    }
}
