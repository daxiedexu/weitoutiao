package com.bw.mvvm_core.cmds;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

/**
 * @ClassName ViewAdapter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/17 16:46
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class ViewAdapter {
    @BindingAdapter(value = {"onClickCmd"},requireAll = false)
    public static void onClickCmd(View view,final BindCommand bindCommand){
        RxView.clicks(view).throttleFirst(3, TimeUnit.MINUTES)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if (bindCommand!=null){
                            bindCommand.execute();
                        }
                    }
                });
    }
}
