package com.bw.mainpage.mvvm;

import androidx.lifecycle.Observer;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bw.common.utils.StatusBarColorUtils;
import com.bw.http.RetrofitManger;
import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityGuideBinding;
import com.bw.mainpage.mvvm.RoomUtils.CacheBean;
import com.bw.mainpage.mvvm.RoomUtils.CacheDatabase;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.customview.MyBtnView;
import com.bw.mainpage.mvvm.entity.GuideEntity;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.viewmodel.GuideViewModel;
import com.bw.mvvm_core.view.BaseActivity;

import java.util.HashMap;
import java.util.List;

public class GuideActivity extends BaseActivity<GuideViewModel, ActivityGuideBinding> {
    private Button guideBtn;
    private MyBtnView my1;
    public List<GuideEntity> data;
    private MyBtnView my2;
    private MyBtnView my3;

    @Override
    protected void initEvent() {
        my1 = (MyBtnView) findViewById(R.id.my_1);
        my2 = (MyBtnView) findViewById(R.id.my_2);
        my3 = (MyBtnView) findViewById(R.id.my_3);
        guideBtn = (Button) findViewById(R.id.guide_btn);
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .guide()
                .observe(this, new Observer<BaseRespEntity<List<GuideEntity>>>( ) {
                    @Override
                    public void onChanged(BaseRespEntity<List<GuideEntity>> guideEntities) {

                        data=guideEntities.getData( );

                    }
                });

        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(GuideActivity.this, Color.WHITE);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(GuideActivity.this,true);

        guideBtn.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                CacheBean cacheBean=new CacheBean( );

                if(!my1.ischeck){
                    cacheBean.classify=my1.getText( ).toString( );
                    CacheDatabase.getInstance(GuideActivity.this).getCacheDao().insertAll(cacheBean);
                }
                if(!my2.ischeck){
                    cacheBean.classify=my2.getText( ).toString( );
                    CacheDatabase.getInstance(GuideActivity.this).getCacheDao().insertAll(cacheBean);
                }
                if(!my3.ischeck){
                    cacheBean.classify=my3.getText( ).toString( );
                    CacheDatabase.getInstance(GuideActivity.this).getCacheDao().insertAll(cacheBean);
                }

                Intent intent=new Intent(GuideActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.GuideViewModel,mViewModel);
    }

    @Override
    protected GuideViewModel createViewModel() {
        return new GuideViewModel(this);
    }

    protected int getLayout() {
        return R.layout.activity_guide;
    }
}