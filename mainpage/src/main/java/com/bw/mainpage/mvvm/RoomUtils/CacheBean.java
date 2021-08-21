package com.bw.mainpage.mvvm.RoomUtils;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @ClassName Cache
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/19 14:58
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

@Entity
public class CacheBean {

    @PrimaryKey(autoGenerate=true)
    public int rid;

    public String classify;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid=rid;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify=classify;
    }
}
