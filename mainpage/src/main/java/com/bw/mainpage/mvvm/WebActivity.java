package com.bw.mainpage.mvvm;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.bw.http.RetrofitManger;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.WebBinding;
import com.bw.mainpage.mvvm.api.HomeApi;
import com.bw.mainpage.mvvm.entity.NewsDetailEntity;

import com.bw.mainpage.mvvm.viewmodel.NewDetailViewModel;
import com.bw.mvvm_core.view.BaseActivity;
import com.tencent.smtt.sdk.WebView;

import java.util.HashMap;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName WebActivity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/25 19:31
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class WebActivity extends BaseActivity<NewDetailViewModel,WebBinding>  {
    private android.widget.ImageView webImgBack;
    private android.widget.ImageView webImgShare;
    private android.widget.TextView webTvTitle;
    private android.widget.ImageView webImgHead;
    private android.widget.TextView webTvAuthor;
    private android.widget.TextView webTvTime;
    private com.tencent.smtt.sdk.WebView webTvWeb;
    private android.widget.EditText webEtWrite;
    private android.widget.ImageView webImgSay;
    private android.widget.ImageView webImgCollect;
    private android.widget.ImageView webImgUpload;

    @Override
    protected void initEvent() {
        webImgBack = (ImageView) findViewById(R.id.web_img_back);
        webImgShare = (ImageView) findViewById(R.id.web_img_share);
        webTvTitle = (TextView) findViewById(R.id.web_tv_title);
        webImgHead = (ImageView) findViewById(R.id.web_img_head);
        webTvAuthor = (TextView) findViewById(R.id.web_tv_author);
        webTvTime = (TextView) findViewById(R.id.web_tv_time);
        webTvWeb = (WebView) findViewById(R.id.web_tv_web);
        webEtWrite = (EditText) findViewById(R.id.web_et_write);
        webImgSay = (ImageView) findViewById(R.id.web_img_say);
        webImgCollect = (ImageView) findViewById(R.id.web_img_collect);
        webImgUpload = (ImageView) findViewById(R.id.web_img_upload);


        Intent intent=getIntent( );
//        NewsDetailEntity.DataBean newsDetail=intent.getParcelableExtra("newsDetail");
//        Toast.makeText(this, newsDetail.url+"", Toast.LENGTH_SHORT).show( );
        String newscode = intent.getStringExtra("newscode");
        Log.i("123456", "initEvent: "+newscode);
//        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
//                .newsdeta(newscode)
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Consumer<NewsDetailEntity>() {
//                    @Override
//                    public void accept(NewsDetailEntity newsDetailEntity) throws Exception {
////                        NewsDetailEntity.DataBean data = newsDetailEntity.getData();
////                        webTvTitle.setText(data.getTitle());
////                        Log.i("123456", "onChanged: "+data.getTitle());
//                    }
//                });

//        mViewModel.detail(newscode).observe(this, new Observer<NewsDetailEntity>() {
//            @Override
//            public void onChanged(NewsDetailEntity newsDetailEntity) {
//                Log.i("123456", "onChanged: "+newsDetailEntity);
////                webTvTitle.setText(newsDetailEntity.getData().getTitle());
////                NewsDetailEntity.DataBean data = newsDetailEntity.getData();
//            }
//        });


    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.WebViewModel,mViewModel);
    }

    @Override
    protected NewDetailViewModel createViewModel() {
        return new NewDetailViewModel(this);
    }


    @Override
    protected int getLayout() {
        return R.layout.web;
    }

}
