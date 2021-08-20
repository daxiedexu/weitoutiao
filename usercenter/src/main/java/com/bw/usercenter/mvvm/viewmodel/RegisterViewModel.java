package com.bw.usercenter.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.ThreadUtils;
import com.bw.mvvm_core.viewmodel.BaseViewModel;
import com.bw.usercenter.mvvm.entity.RegisterEntity;
import com.bw.usercenter.mvvm.repository.UserRepository;

/**
 * @ClassName RegisterViewModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 15:44
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class RegisterViewModel extends BaseViewModel<UserRepository> {
    public MutableLiveData<RegisterEntity> mutableLiveData = new MutableLiveData<>();
    public RegisterViewModel(LifecycleOwner owner) {
        super(owner);
        RegisterEntity registerEntity = new RegisterEntity();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(registerEntity);
        }else {
            mutableLiveData.postValue(registerEntity);
        }
    }

    @Override
    protected UserRepository createRepository() {
        return new UserRepository();
    }

    public LiveData<RegisterEntity> register(RegisterEntity registerEntity){
        return mRepository.register(registerEntity);
    }
}
