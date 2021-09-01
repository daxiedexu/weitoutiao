package com.bw.mainpage.mvvm.entity;

/**
 * @ClassName UserCommentEntity
 * @Author 孔晨亮
 * @Date 2021/8/30 20:10
 * User: msi
 */
public class UserCommentEntity {


    /**
     * id : 8
     * newscode : eaa2f22812e646a19b44288e28ed1ca5
     * userid : 1
     * content : 123123
     * imgs : sample string 1|sample string 2
     * ctime : 2020/1/27 15:21:35
     */

    private int id;
    private String newscode;
    private int userid;
    private String content;
    private String imgs;
    private String ctime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewscode() {
        return newscode;
    }

    public void setNewscode(String newscode) {
        this.newscode = newscode;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
