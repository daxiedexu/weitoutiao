package com.bw.mainpage.mvvm;

import android.app.Application;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.bw.mainpage.mvvm.umeng.SharedPreferencesHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.socialize.PlatformConfig;

/**
 * @ClassName MyApp
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/24 13:46
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class MyApp extends Application {

    SharedPreferencesHelper sharedPreferencesHelper;
    @Override
    public void onCreate() {
        super.onCreate( );

        MultiDex.install(this);
        sharedPreferencesHelper=new SharedPreferencesHelper(this,"umeng");

        //设置LOG开关，默认为false
        UMConfigure.setLogEnabled(false);

        //友盟预初始化
//        UMConfigure.preInit(getApplicationContext(),"60938eaac9aacd3bd4c2f7a7","Umeng");

        UMConfigure.init(this,"60938eaac9aacd3bd4c2f7a7"
                ,"Umeng",UMConfigure.DEVICE_TYPE_PHONE,"771598b04dba7aaa5aef15bd117d3b02");

        //获取消息推送实例
        PushAgent pushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        pushAgent.register(new UPushRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i("666", "注册成功：deviceToken：--> " + deviceToken);
            }

            @Override
            public void onFailure(String errCode, String errDesc) {
                Log.e("666", "注册失败：--> " + "code:" + errCode + ", desc:" + errDesc);
            }
        });

        String FileProvider = "com.umeng.soexample.fileprovider";
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setWXFileProvider(FileProvider);

        PlatformConfig.setQQZone("1110635796","ELzp27tgv5MGtuk8");
        PlatformConfig.setQQFileProvider(FileProvider);


        //友盟正式初始化
        /**
         * 打开app首次隐私协议授权，以及sdk初始化，判断逻辑请查看SplashTestActivity
         */
        //判断是否同意隐私协议，uminit为1时为已经同意，直接初始化umsdk
//        if(sharedPreferencesHelper.getSharedPreference("uminit","").equals("1")){
//            //友盟正式初始化
//            UmInitConfig umInitConfig=new UmInitConfig();
//            umInitConfig.UMinit(getApplicationContext());
//        }



    }
}
