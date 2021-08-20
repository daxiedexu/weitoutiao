package com.bw.http.protocol;

/**
 * @ProjectName: NewsZG61901
 * @Package: com.zy.net.protocol
 * @ClassName: TokenRespEntity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/8/17 13:58
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/8/17 13:58
 * @UpdateRemark:
 * @Version: 1.0
 */
public class TokenRespEntity {
    private String access_token;
    private String token_type;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
