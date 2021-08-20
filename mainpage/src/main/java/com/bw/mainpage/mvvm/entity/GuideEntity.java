package com.bw.mainpage.mvvm.entity;

/**
 * @ClassName GuideEntity
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 14:32
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */

public class GuideEntity {
    public Integer id;
    public String typename;

    public GuideEntity() {
    }

    public GuideEntity(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "GuideEntity{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}
