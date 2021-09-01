package com.bw.mainpage.mvvm.model.net;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.utils.ThreadUtils;
import com.bw.http.RetrofitManger;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.entity.NewsDetailEntity;
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
public class NewDetailModel implements IModel {
    public LiveData<NewsDetailEntity> newLists(String newsCode){
        MutableLiveData<NewsDetailEntity> mutableLiveData = new MutableLiveData<>();
//        LiveData<NewsDetailEntity> newsdeta = RetrofitManger.getInstance().getRetrofit().create(HomeApi.class).newsdeta(newsCode);
//        if (ThreadUtils.isMainThread()){
//            mutableLiveData.setValue(newsdeta.getValue());
//        }else {
//            mutableLiveData.postValue(newsdeta.getValue());
//        }
        return mutableLiveData;
    }
}
