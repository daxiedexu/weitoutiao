package com.bw.mainpage.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.ThreadUtils;
import com.bw.mainpage.mvvm.entity.GuideEntity;
import com.bw.mainpage.mvvm.repository.HomeRepository;
import com.bw.mvvm_core.viewmodel.BaseViewModel;

/**
 * @ClassName GuideViewModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 20:20
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class GuideViewModel extends BaseViewModel<HomeRepository> {
    public MutableLiveData<GuideEntity> mutableLiveData = new MutableLiveData<>();
    public GuideViewModel(LifecycleOwner owner) {
        super(owner);
        GuideEntity guideEntity = new GuideEntity();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(guideEntity);
        }else {
            mutableLiveData.postValue(guideEntity);
        }
    }

    @Override
    protected HomeRepository createRepository() {
        return new HomeRepository();
    }
}
