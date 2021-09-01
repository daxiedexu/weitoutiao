package com.bw.mainpage.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.http.protocol.BaseRespEntity;
import com.bw.mainpage.BR;
import com.bw.mainpage.R;
import com.bw.mainpage.databinding.ActivityCommentBinding;
import com.bw.mainpage.mvvm.Adapter.CommentAdapter;
import com.bw.mainpage.mvvm.entity.UserCommentEntity;
import com.bw.mainpage.mvvm.viewmodel.CommentViewModel;
import com.bw.mvvm_core.view.BaseActivity;

import java.util.HashMap;
import java.util.List;

public class CommentActivity extends BaseActivity<CommentViewModel, ActivityCommentBinding> {


    private android.widget.ImageView commentBack;
    private android.widget.ImageView commentHead;
    private android.widget.Button commentPay;
    private androidx.recyclerview.widget.RecyclerView commentRv;
    private android.widget.EditText commentWrite;
    private android.widget.ImageView commentSay;
    private android.widget.ImageView commentCollect;
    private android.widget.ImageView commentUpload;

    @Override
    protected void initEvent() {
        commentBack = (ImageView) findViewById(R.id.comment_back);
        commentHead = (ImageView) findViewById(R.id.comment_head);
        commentPay = (Button) findViewById(R.id.comment_pay);
        commentRv = (RecyclerView) findViewById(R.id.comment_rv);
        commentWrite = (EditText) findViewById(R.id.comment_write);
        commentSay = (ImageView) findViewById(R.id.comment_say);
        commentCollect = (ImageView) findViewById(R.id.comment_collect);
        commentUpload = (ImageView) findViewById(R.id.comment_upload);
        Glide.with(this).load(R.drawable.ic_launcher_background).transform(new CircleCrop()).into(commentHead);
        commentBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommentActivity.this,HomeActivity.class);
                intent.putExtra("position",2);
                startActivity(intent);
            }
        });
        mViewModel.getComment(1).observe(this, new Observer<BaseRespEntity<List<UserCommentEntity>>>() {
            @Override
            public void onChanged(BaseRespEntity<List<UserCommentEntity>> listBaseRespEntity) {
                List<UserCommentEntity> data = listBaseRespEntity.getData();
                CommentAdapter commentAdapter = new CommentAdapter(R.layout.item_comment, data);
                commentRv.setAdapter(commentAdapter);
                commentRv.setLayoutManager(new LinearLayoutManager(CommentActivity.this));
            }
        });
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.CommentViewModel,mViewModel);
    }

    @Override
    protected CommentViewModel createViewModel() {
        return new CommentViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_comment;
    }

}