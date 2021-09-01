package com.bw.mainpage.mvvm.model.net;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.utils.ThreadUtils;
import com.bw.http.RetrofitManger;
import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.GuideEntity;
import com.bw.mainpage.mvvm.entity.NewsDetailEntity;
import com.bw.mainpage.mvvm.entity.UserCommentEntity;
import com.bw.mvvm_core.model.IModel;

import java.util.List;


/**
 * @ClassName GuideNetModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 19:23
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class UserCommentModel implements IModel {
    public LiveData<BaseRespEntity<List<UserCommentEntity>>> guide(Integer userid){
//        MutableLiveData<List<UserCommentEntity>> mutableLiveData = new MutableLiveData<>();
        LiveData<BaseRespEntity<List<UserCommentEntity>>> comment = RetrofitManger.getInstance().getRetrofit().create(HomeApi.class).comment(userid);
//        if (ThreadUtils.isMainThread()){
//            mutableLiveData.setValue(comment.getValue().getData());
//        }else {
//            mutableLiveData.postValue(comment.getValue().getData());
//        }
        return comment;
    }
}
