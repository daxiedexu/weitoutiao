package com.bw.http;

import android.text.TextUtils;
import android.util.Log;

import com.bw.http.api.TokenApi;
import com.bw.http.common.Config;
import com.bw.http.customGson.CustomGsonConverterFactory;
import com.bw.http.protocol.TokenRespEntity;
import com.bw.http.rxjavaAdapter.LiveDataCallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName RetrofitManger
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/18 19:19
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class RetrofitManger {
    private Retrofit retrofit;
    private String mToken = "";
    private static final String TAG = "RetrofitManger";
    public void create(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(new OkHttpClient.Builder()
                        .readTimeout(Config.TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(Config.TIMEOUT,TimeUnit.SECONDS)
                        .connectTimeout(Config.TIMEOUT,TimeUnit.SECONDS)
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .addInterceptor(createTokenInterceptor())
                        .build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(CustomGsonConverterFactory.create())
                .build();
    }

    private Interceptor createTokenInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String localToken = mToken;
                if (!TextUtils.isEmpty(localToken)){
                    return resetRequest(request,localToken,chain);
                }
                Response response = chain.proceed(request);
                if (checkHttpCode401(response)){
                    String token = requestToken();
                    if (TextUtils.isEmpty(token)){
                        return response;
                    }
                    mToken = token;
                    return resetRequest(request,token,chain);
                }
                return response;
            }
        };
        return interceptor;
    }

    private String requestToken(){
        TokenApi tokenApi = createApi(TokenApi.class);
        Call<TokenRespEntity> tokenService = tokenApi.getToken("password", Config.AUTH_CODE, "");
        try {
            retrofit2.Response<TokenRespEntity> result = tokenService.execute();
            if (result!=null&&result.body()!=null){
                return result.body().getAccess_token();
            }
        } catch (IOException e) {
            Log.e(TAG, "error info:"+e.getMessage());
        }
        return "";
    }

    public <T> T createApi(Class<?> service){
        return (T) retrofit.create(service);
    }

    private boolean checkHttpCode401(Response response){
        if (null==response){
            return false;
        }else if (response.code()==401){
            return true;
        }else{
            return false;
        }
    }

    private Response resetRequest(Request request,String token,Interceptor.Chain chain){
        Request.Builder newBuilder = request.newBuilder().addHeader("Authorization", "bearer " + token);
        Request newRequest = newBuilder.build();
        try {
            return chain.proceed(newRequest);
        } catch (IOException e) {
            Log.e(TAG,"error:"+e.getMessage());
        }
        return null;
    }

    public Retrofit getRetrofit(){
        if (retrofit==null){
            create();
        }
        return retrofit;
    }

    //单例动态双重锁
    private volatile static RetrofitManger retrofitManger;
    public synchronized static RetrofitManger getInstance(){
        if (retrofitManger==null){
            synchronized (RetrofitManger.class){
                if (retrofitManger==null){
                    retrofitManger = new RetrofitManger();
                }
            }
        }
        return retrofitManger;
    }
}
