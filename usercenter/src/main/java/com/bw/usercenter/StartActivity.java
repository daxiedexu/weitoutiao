package com.bw.usercenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //置空window背景图
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    /**
     * 等待视图能够获取焦点跳转登录页面
     * 1.在视图获取到焦点的时候去跳转
     * 2.在视图失去焦点的时候去杀死Activity
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            Intent intent = new Intent(StartActivity.this,LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.entrance,R.anim.outside);
        }else {
            finish();
        }
    }
}