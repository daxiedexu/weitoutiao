package com.bw.mainpage.mvvm.model.net;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bw.common.utils.ThreadUtils;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mvvm_core.model.IModel;

/**
 * @ClassName NewListNetModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 19:23
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NewListNetModel implements IModel {
    public LiveData<NewListEntity> newList(NewListEntity newListEntity){
        MutableLiveData<NewListEntity> mutableLiveData = new MutableLiveData<>();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(newListEntity);
        }else {
            mutableLiveData.postValue(newListEntity);
        }
        return mutableLiveData;
    }
}
