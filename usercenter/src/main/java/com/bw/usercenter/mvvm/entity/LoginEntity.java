package com.bw.usercenter.mvvm.entity;

/**
 * @ClassName LoginEntity
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/19 15:23
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class LoginEntity {
    private int id;
    private String username;
    private String pwd;
    private String sex;
    private String birthday;

    public LoginEntity() {
    }

    public LoginEntity(int id, String username, String pwd, String sex, String birthday) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.sex = sex;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
