package com.homework.bakery.order;

import com.homework.bakery.bread.Bread;
import com.homework.bakery.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BreadStore {
    private double sum = 0;
    public double orderByBread(Bread bread){
        if (bread == null){
            return sum += 0;
        }
        return  sum += bread.getPrice();
    }

    public double getSum() {
        return sum;
    }

    public static void main(String[] args) {
        String s1 = "WheatBread";
        String s2 = "CerealBread";
        String s3 = "TunaBread";
        DateUtil dateUtil = new DateUtil();
        BreadStore breadStore = new BreadStore();
        SimpleDateFormat sd = new SimpleDateFormat();
        Date currentYMDHMSDate = dateUtil.getCurrentYMDHMSDate(dateUtil.getCurrentYMDHMSStr());
        long time = currentYMDHMSDate.getTime() - 2*24*60*60*1500;
        Date date = new Date(time);
//        Date currentYMDHMSDate2 = dateUtil.getCurrentYMDHMSDate(dateUtil.date2ymdHmsStr(date));
//        System.out.println(currentYMDHMSDate2);
        BreadFactory breadFactory = new BreadFactory();
//        System.out.println(date);

        Date currentYMDHMSDate1 = dateUtil.getCurrentYMDHMSDate("2022-07-20 21:00:00");
        System.out.println(currentYMDHMSDate1);
        Long aLong = dateUtil.DayDiff(dateUtil.date2ymdHmsStr(currentYMDHMSDate1), dateUtil.getCurrentYMDHMSStr());
        System.out.println(aLong);
        Bread wheatBread = breadFactory.createBread(s2, date);
        System.out.println(wheatBread.getPrice());


    }

}
