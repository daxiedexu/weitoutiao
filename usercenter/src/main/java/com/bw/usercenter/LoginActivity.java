package com.bw.usercenter;

import android.content.Intent;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import com.bw.http.RetrofitManger;
import com.bw.http.protocol.BaseRespEntity;
import com.bw.mvvm_core.view.BaseActivity;
import com.bw.usercenter.databinding.ActivityLoginBinding;
import com.bw.usercenter.mvvm.api.UserCenterApi;
import com.bw.usercenter.mvvm.entity.LoginEntity;
import com.bw.usercenter.mvvm.viewmodel.LoginViewModel;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> {

    @Override
    protected void initEvent() {
        mBinding.setLoginOnClick(view->{
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
                                    .login(mViewModel.mutableLiveData.getValue())
                                    .observe(LoginActivity.this, new Observer<BaseRespEntity<LoginEntity>>() {
                                        @Override
                                        public void onChanged(BaseRespEntity<LoginEntity> loginEntityBaseRespEntity) {
                                            Toast.makeText(LoginActivity.this, "登录了哈~", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    });
        });
        mBinding.setSkipOnClick(view->{
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.LoginViewModel,mViewModel);
    }

    @Override
    protected LoginViewModel createViewModel() {
        return new LoginViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }
}