package com.bw.usercenter.mvvm.model.net;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.ThreadUtils;
import com.bw.mvvm_core.model.IModel;
import com.bw.usercenter.mvvm.entity.RegisterEntity;

/**
 * @ClassName RegisterNetModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 15:39
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class RegisterNetModel implements IModel {
    public LiveData<RegisterEntity> register(RegisterEntity registerEntity){
        MutableLiveData<RegisterEntity> mutableLiveData = new MutableLiveData<>();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(registerEntity);
        }else {
            mutableLiveData.postValue(registerEntity);
        }
        return mutableLiveData;
    }
}
