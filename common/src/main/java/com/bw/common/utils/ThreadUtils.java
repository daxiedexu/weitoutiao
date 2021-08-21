package com.bw.common.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executors;

/**
 * @ClassName ThreadUtils
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/16 18:55
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class ThreadUtils {
    //定义Handler用于切换主线程
    public static Handler mHandler = new Handler(Looper.getMainLooper());
    //切换主线程
    public static void doTaskOnMainThread(Runnable runnable){
        mHandler.post(runnable);
    }
    //使用线程池切换子线程
    public static void doTaskOnAsync(Runnable runnable){
        Executors.newCachedThreadPool().submit(runnable);
    }
    /**
     * 判断当前是否为主线程
     * 1.主线程返回true
     * 2.子线程返回false
     */
    public static boolean isMainThread(){
        if (Looper.getMainLooper().getThread()==Thread.currentThread()){
            return true;
        }else {
            return false;
        }
    }
}
