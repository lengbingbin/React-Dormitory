package com.zhb.dormitoryservice.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable {

    private int S_id;
    private String S_name;
    private String sex;
    private String birthday;
    private String qq;
    private String mobile;
    private int dormid;

    public Integer getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getDormid() {
        return dormid;
    }

    public void setDormid(int dormid) {
        this.dormid = dormid;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student [S_id=" + S_id + ", S_name=" + S_name + ", sex=" + sex
                + ", birthday=" + birthday + ", qq=" + qq + ", mobile="
                + mobile + ", dormid=" + dormid + "]";
    }


}
