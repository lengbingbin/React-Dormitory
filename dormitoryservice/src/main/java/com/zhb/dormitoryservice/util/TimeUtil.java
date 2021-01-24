package com.zhb.dormitoryservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public static String parseTime(String time){
        //转换为该时区表示的时间格式
        String timeStr  = time;
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
        Date dateTime = null;
        try {
            dateTime = SDF.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat Time3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String starttime = Time3.format(dateTime);
        //加上8个小时为中国时区
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(starttime);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 8);// 24小时制
        date = cal.getTime();
        starttime = format.format(date);
        return starttime;
    }
}
