package com.bw.usercenter;

import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.bw.http.RetrofitManger;
import com.bw.http.protocol.BaseRespEntity;
import com.bw.mvvm_core.view.BaseActivity;
import com.bw.usercenter.databinding.ActivityRegisterBinding;
import com.bw.usercenter.mvvm.api.UserCenterApi;
import com.bw.usercenter.mvvm.entity.LoginEntity;
import com.bw.usercenter.mvvm.entity.RegisterEntity;
import com.bw.usercenter.mvvm.viewmodel.RegisterViewModel;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class RegisterActivity extends BaseActivity<RegisterViewModel, ActivityRegisterBinding> {

    @Override
    protected void initEvent() {
        mBinding.setRegisterOnClick(view->{
            /**
             * RxJava解决点击事件抖动
             */
            RxView.clicks(view).throttleFirst(3, TimeUnit.SECONDS)
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            RetrofitManger.getInstance()
                                    .getRetrofit()
                                    .create(UserCenterApi.class)
                                    .register(mViewModel.mutableLiveData.getValue())
                                    .observe(RegisterActivity.this, new Observer<BaseRespEntity<RegisterEntity>>() {
                                        @Override
                                        public void onChanged(BaseRespEntity<RegisterEntity> registerEntityBaseRespEntity) {
                                            Toast.makeText(RegisterActivity.this, "注册了哈~", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    });
        });
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.RegisterViewModel,mViewModel);
    }

    @Override
    protected RegisterViewModel createViewModel() {
        return new RegisterViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }
}