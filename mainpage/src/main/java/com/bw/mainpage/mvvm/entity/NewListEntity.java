package com.bw.mainpage.mvvm.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @ClassName NewListEntity
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 14:53
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NewListEntity implements MultiItemEntity {

    public Integer id;
    public String newscode;
    public Integer newstypeid;
    public Integer sourcesiteid;
    public String sourcesitename;
    public String title;
    public String description;
    public String auth;
    public String sourceurl;
    public String mainimgurl;
    public String istop;
    public int type;

    public NewListEntity() {
    }

    public NewListEntity(Integer id, String newscode, Integer newstypeid, Integer sourcesiteid, String sourcesitename, String title, String description, String auth, String sourceurl, String mainimgurl, String istop) {
        this.id = id;
        this.newscode = newscode;
        this.newstypeid = newstypeid;
        this.sourcesiteid = sourcesiteid;
        this.sourcesitename = sourcesitename;
        this.title = title;
        this.description = description;
        this.auth = auth;
        this.sourceurl = sourceurl;
        this.mainimgurl = mainimgurl;
        this.istop = istop;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type=type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewscode() {
        return newscode;
    }

    public void setNewscode(String newscode) {
        this.newscode = newscode;
    }

    public Integer getNewstypeid() {
        return newstypeid;
    }

    public void setNewstypeid(Integer newstypeid) {
        this.newstypeid = newstypeid;
    }

    public Integer getSourcesiteid() {
        return sourcesiteid;
    }

    public void setSourcesiteid(Integer sourcesiteid) {
        this.sourcesiteid = sourcesiteid;
    }

    public String getSourcesitename() {
        return sourcesitename;
    }

    public void setSourcesitename(String sourcesitename) {
        this.sourcesitename = sourcesitename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    public String getMainimgurl() {
        return mainimgurl;
    }

    public void setMainimgurl(String mainimgurl) {
        this.mainimgurl = mainimgurl;
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }

    @Override
    public String toString() {
        return "NewListEntity{" +
                "id=" + id +
                ", newscode='" + newscode + '\'' +
                ", newstypeid=" + newstypeid +
                ", sourcesiteid=" + sourcesiteid +
                ", sourcesitename='" + sourcesitename + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", auth='" + auth + '\'' +
                ", sourceurl='" + sourceurl + '\'' +
                ", mainimgurl='" + mainimgurl + '\'' +
                ", istop='" + istop + '\'' +
                '}';
    }

    @Override
    public int getItemType() {
        if(type%3==0){
            return 0;
        }else if(type%3==1){
            return 1;
        }else if(type%3==2){
            return 2;
        }
        return 0;
    }
}
