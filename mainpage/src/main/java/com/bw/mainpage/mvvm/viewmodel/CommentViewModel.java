package com.bw.mainpage.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.common.ThreadUtils;
import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.mvvm.entity.NewsDetailEntity;
import com.bw.mainpage.mvvm.entity.UserCommentEntity;
import com.bw.mainpage.mvvm.repository.HomeRepository;
import com.bw.mvvm_core.viewmodel.BaseViewModel;

import java.util.List;

/**
 * @ClassName NewListLocalModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 20:21
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class CommentViewModel extends BaseViewModel<HomeRepository> {
//    public MutableLiveData<UserCommentEntity> mutableLiveData = new MutableLiveData<>();
    public CommentViewModel(LifecycleOwner owner) {
        super(owner);
//        UserCommentEntity userCommentEntity = new UserCommentEntity();
//        if (ThreadUtils.isMainThread()){
//            mutableLiveData.setValue(userCommentEntity);
//        }else {
//            mutableLiveData.postValue(userCommentEntity);
//        }
    }

    @Override
    protected HomeRepository createRepository() {
        return new HomeRepository();
    }

    public LiveData<BaseRespEntity<List<UserCommentEntity>>> getComment(Integer  userid){
        return mRepository.comments(userid);
    }
}
