package com.bw.usercenter.mvvm.entity;

/**
 * @ClassName RegisterEntity
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 13:55
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class RegisterEntity {

    public Integer id;
    public String username;
    public String pwd;
    public String sex;
    public String birthday;

    public RegisterEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "RegisterEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
