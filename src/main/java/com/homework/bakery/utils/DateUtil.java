package com.homework.bakery.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    //年月日 时分秒格式的日期
    private static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
    private static final String H_M_S = "HH:mm:ss";

    //获取当前时间，年月日-时分秒
    public String getCurrentYMDHMSStr(){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
        String dateStr = sdf.format(new Date());
        return dateStr;
    }

    //获取当前时间，时分秒
    public String getCurrentHMSStr(){
        SimpleDateFormat sdf = new SimpleDateFormat(H_M_S);
        String dateStr = sdf.format(new Date());
        return dateStr;
    }

    //根据年月日-时分秒字符串获取date对象
    public Date getCurrentYMDHMSDate(String ymdHmsTime){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
            return sdf.parse(ymdHmsTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据时分秒字符串获取date对象
    public Date getCurrentHMSDate(String HmsTime){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(H_M_S);
            return sdf.parse(HmsTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //将date对象转换为年月日-时分秒字符串
    public String date2ymdHmsStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
        if(date==null){
            return "";
        }else{
            return sdf.format(date);
        }
    }

    //将date对象转换为时分秒字符串
    public String date2HmsStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
        if(date==null){
            return "";
        }else{
            return sdf.format(date);
        }
    }

    //计算时间间隔，多少天
    public  Long DayDiff(String startTime, String endTime) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(Y_M_D_H_M_S);
        // 一天的毫秒数
        long nd = 1000 * 24 * 60 * 60;
        //两个时间的毫秒时间差
        long diff;
        //两个时间的天数时间差
        long day = 0;
        try {
            // 获得两个时间的毫秒时间差异
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
            // 计算差多少天
            day = diff / nd;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return day;
    }

    //计算时间间隔，多少秒
    public Long SecDiff(String startTime, String endTime) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(Y_M_D_H_M_S);
        //一秒钟的毫秒数
        long ns = 1000;
        //两个时间的毫秒时间差
        long diff;
        //两个时间的秒数时间差
        long second = 0;
        try {
            // 获得两个时间的毫秒时间差异
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
            // 计算差多少秒
            second = diff / ns;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return second;
    }



}
