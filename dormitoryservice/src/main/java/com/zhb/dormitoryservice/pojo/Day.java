package com.zhb.dormitoryservice.pojo;

import java.io.Serializable;

public class Day implements Serializable {

    private String Mon;
    private String Tue;
    private String Wed;
    private String Thu;
    private String Fri;
    private String Sat;
    private String Sun;

    public String getMon() {
        return Mon;
    }

    public void setMon(String mon) {
        Mon = mon;
    }

    public String getTue() {
        return Tue;
    }

    public void setTue(String tue) {
        Tue = tue;
    }

    public String getWed() {
        return Wed;
    }

    public void setWed(String wed) {
        Wed = wed;
    }

    public String getThu() {
        return Thu;
    }

    public void setThu(String thu) {
        Thu = thu;
    }

    public String getFri() {
        return Fri;
    }

    public void setFri(String fri) {
        Fri = fri;
    }

    public String getSat() {
        return Sat;
    }

    public void setSat(String sat) {
        Sat = sat;
    }

    public String getSun() {
        return Sun;
    }

    public void setSun(String sun) {
        Sun = sun;
    }
}
