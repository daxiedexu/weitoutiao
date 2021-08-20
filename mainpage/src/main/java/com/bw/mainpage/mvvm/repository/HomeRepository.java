package com.bw.mainpage.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.bw.mainpage.mvvm.entity.GuideEntity;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.model.net.GuideNetModel;
import com.bw.mainpage.mvvm.model.net.NewListNetModel;
import com.bw.mvvm_core.model.Model;
import com.bw.mvvm_core.repository.BaseRepository;

/**
 * @ClassName HomeRepository
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 19:24
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class HomeRepository extends BaseRepository {
    @Model
    GuideNetModel guideNetModel;
    @Model
    NewListNetModel newListNetModel;
    public LiveData<GuideEntity> guide(GuideEntity guideEntity){
        return guideNetModel.guide(guideEntity);
    }
    public LiveData<NewListEntity> newList(NewListEntity newListEntity){
        return newListNetModel.newList(newListEntity);
    }
}
