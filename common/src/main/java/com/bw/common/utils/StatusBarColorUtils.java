package com.bw.common.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * @ClassName StatusBarColorUtils
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/21 17:33
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class StatusBarColorUtils {
    /**
     * 更改状态栏的颜色
     */
    public static void setStatusBarColor(Activity activity,int colorId){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(colorId);
        }else {
            //SDK:21以下先不设置
        }
    }
    /**
     * 更改谷歌状态栏文字颜色
     */
    public static void setAndroidNativeLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
}
