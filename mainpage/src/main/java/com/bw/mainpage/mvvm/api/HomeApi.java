package com.bw.mainpage.mvvm.api;

import androidx.lifecycle.LiveData;

import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.mvvm.entity.GuideEntity;
import com.bw.mainpage.mvvm.entity.NewListEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @ClassName HomeApi
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 19:19
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public interface HomeApi {
    @GET("api/NewsType/getAllTypes")
    LiveData<BaseRespEntity<List<GuideEntity>>> guide();
    @GET("api/News/getNews?")
    LiveData<BaseRespEntity<List<NewListEntity>>> newList(@Query("newstype") int newstype, @Query("pagenum") int pagenum, @Query("pagesize") int pagesize);
}
