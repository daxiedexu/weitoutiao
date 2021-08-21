package com.bw.mainpage.mvvm;

import androidx.lifecycle.Observer;

import android.graphics.Color;
import android.widget.Toast;

import com.bw.common.utils.StatusBarColorUtils;
import com.bw.http.RetrofitManger;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityGuideBinding;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.GuideEntity;
import com.bw.mainpage.mvvm.viewmodel.GuideViewModel;
import com.bw.mvvm_core.view.BaseActivity;

import java.util.HashMap;

public class GuideActivity extends BaseActivity<GuideViewModel, ActivityGuideBinding> {

    @Override
    protected void initEvent() {
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .guide()
                .observe(GuideActivity.this, new Observer<GuideEntity>() {
                    @Override
                    public void onChanged(GuideEntity guideEntity) {
                        Toast.makeText(GuideActivity.this, guideEntity.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(GuideActivity.this, Color.WHITE);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(GuideActivity.this,true);
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.GuideViewModel,mViewModel);
    }

    @Override
    protected GuideViewModel createViewModel() {
        return new GuideViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_guide;
    }
}