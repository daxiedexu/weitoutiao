package com.bw.mainpage.mvvm.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ClassName NewsDetailEntity
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/25 19:42
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */


public class NewsDetailEntity {
    public Integer code;
    public DataBean data;
    public String msg;


    public class DataBean  {
        public Integer id;
        public String title;
        public String content;
        public String url;
        public String newscode;
        public String auth;
        public String publishtime;
        public String isstaticpage;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNewscode() {
            return newscode;
        }

        public void setNewscode(String newscode) {
            this.newscode = newscode;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public String getIsstaticpage() {
            return isstaticpage;
        }

        public void setIsstaticpage(String isstaticpage) {
            this.isstaticpage = isstaticpage;
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code=code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data=data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg=msg;
    }


}
