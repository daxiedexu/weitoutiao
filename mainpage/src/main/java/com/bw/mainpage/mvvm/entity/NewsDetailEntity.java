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


    public static class DataBean implements Parcelable  {
        public Integer id;
        public String title;
        public String content;
        public String url;
        public String newscode;
        public String auth;
        public String publishtime;
        public String isstaticpage;

        protected DataBean(Parcel in) {
            if (in.readByte( ) == 0) {
                id=null;
            } else {
                id=in.readInt( );
            }
            title=in.readString( );
            content=in.readString( );
            url=in.readString( );
            newscode=in.readString( );
            auth=in.readString( );
            publishtime=in.readString( );
            isstaticpage=in.readString( );
        }

        public static final Creator<DataBean> CREATOR=new Creator<DataBean>( ) {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (id == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(id);
            }
            dest.writeString(title);
            dest.writeString(content);
            dest.writeString(url);
            dest.writeString(newscode);
            dest.writeString(auth);
            dest.writeString(publishtime);
            dest.writeString(isstaticpage);
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
