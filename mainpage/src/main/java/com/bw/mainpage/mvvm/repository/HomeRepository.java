package com.bw.mainpage.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.mvvm.entity.GuideEntity;
import com.bw.mainpage.mvvm.entity.NewListEntity;
import com.bw.mainpage.mvvm.entity.NewsDetailEntity;
import com.bw.mainpage.mvvm.entity.UserCommentEntity;
import com.bw.mainpage.mvvm.model.net.GuideNetModel;
import com.bw.mainpage.mvvm.model.net.NewDetailModel;
import com.bw.mainpage.mvvm.model.net.NewListNetModel;
import com.bw.mainpage.mvvm.model.net.UserCommentModel;
import com.bw.mvvm_core.model.Model;
import com.bw.mvvm_core.repository.BaseRepository;

import java.util.List;

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
    @Model
    NewDetailModel newDetailModel;
    @Model
    UserCommentModel userCommentModel;
    public LiveData<GuideEntity> guide(GuideEntity guideEntity){
        return guideNetModel.guide(guideEntity);
    }
    public LiveData<NewListEntity> newList(NewListEntity newListEntity){
        return newListNetModel.newList(newListEntity);
    }
    public LiveData<NewsDetailEntity> newDetail(String newsCode){
        return newDetailModel.newLists(newsCode);
    }
    public LiveData<BaseRespEntity<List<UserCommentEntity>>> comments(Integer userid){
        return userCommentModel.guide(userid);
    }
}
