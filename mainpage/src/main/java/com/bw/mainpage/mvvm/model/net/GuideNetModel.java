package com.bw.mainpage.mvvm.model.net;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.ThreadUtils;
import com.bw.mainpage.mvvm.entity.GuideEntity;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mvvm_core.model.IModel;

/**
 * @ClassName GuideNetModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 19:23
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class GuideNetModel implements IModel {
    public LiveData<GuideEntity> guide(GuideEntity guideEntity){
        MutableLiveData<GuideEntity> mutableLiveData = new MutableLiveData<>();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(guideEntity);
        }else {
            mutableLiveData.postValue(guideEntity);
        }
        return mutableLiveData;
    }
}
