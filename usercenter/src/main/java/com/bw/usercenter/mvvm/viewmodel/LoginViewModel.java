package com.bw.usercenter.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.utils.ThreadUtils;
import com.bw.mvvm_core.viewmodel.BaseViewModel;
import com.bw.usercenter.mvvm.entity.LoginEntity;
import com.bw.usercenter.mvvm.repository.UserRepository;

/**
 * @ClassName LoginViewModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 15:42
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class LoginViewModel extends BaseViewModel<UserRepository> {
    public MutableLiveData<LoginEntity> mutableLiveData = new MutableLiveData<>();
    public LoginViewModel(LifecycleOwner owner) {
        super(owner);
        LoginEntity loginEntity = new LoginEntity();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(loginEntity);
        }else {
            mutableLiveData.postValue(loginEntity);
        }
    }

    @Override
    protected UserRepository createRepository() {
        return new UserRepository();
    }

    public LiveData<LoginEntity> login(LoginEntity loginEntity){
        return mRepository.login(loginEntity);
    }
}
