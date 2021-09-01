package com.bw.mainpage.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.ThreadUtils;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.entity.NewsDetailEntity;
import com.bw.mainpage.mvvm.repository.HomeRepository;
import com.bw.mvvm_core.viewmodel.BaseViewModel;

/**
 * @ClassName NewListLocalModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 20:21
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NewDetailViewModel extends BaseViewModel<HomeRepository> {
    public MutableLiveData<NewsDetailEntity> mutableLiveData = new MutableLiveData<>();
    public NewDetailViewModel(LifecycleOwner owner) {
        super(owner);
        NewsDetailEntity newsDetailEntity = new NewsDetailEntity();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(newsDetailEntity);
        }else {
            mutableLiveData.postValue(newsDetailEntity);
        }
    }

    @Override
    protected HomeRepository createRepository() {
        return new HomeRepository();
    }

    public LiveData<NewsDetailEntity> detail(String newsCode){
        return mRepository.newDetail(newsCode);
    }
}
