package com.bw.http.api;

import com.bw.http.protocol.TokenRespEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @ProjectName: NewsZG61901
 * @Package: com.zy.net.api
 * @ClassName: TokenApi
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/8/17 13:57
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/8/17 13:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntity> getToken(@Field("grant_type") String grant_type, @Field("username") String username, @Field("password") String password);
}
