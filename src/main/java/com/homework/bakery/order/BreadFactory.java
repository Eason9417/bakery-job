package com.homework.bakery.order;

import com.homework.bakery.bread.Bread;
import com.homework.bakery.bread.CerealBread;
import com.homework.bakery.bread.TunaBread;
import com.homework.bakery.bread.WheatBread;
import com.homework.bakery.utils.DateUtil;

import java.util.Date;

public class BreadFactory {

    DateUtil dateUtil = new DateUtil();
    Date date = new Date();


    Date HMSdate = dateUtil.getCurrentHMSDate(dateUtil.getCurrentHMSStr());

    public Bread createBread(String Type, Date producedDate){
        Bread bread = null;
        if (Type.equals("WheatBread")){//全麦面包
            bread =new WheatBread();
            bread.prepare(producedDate);
            //判断是否过期
            if(dateUtil.SecDiff(dateUtil.date2ymdHmsStr(producedDate),dateUtil.date2ymdHmsStr(date)) > bread.getShelfLife()*24*60*60){
                bread = null;
            } else if( dateUtil.SecDiff(dateUtil.date2ymdHmsStr(producedDate),dateUtil.getCurrentYMDHMSStr()) > (bread.getShelfLife()-1)*24*60*60
                    && dateUtil.SecDiff(dateUtil.date2ymdHmsStr(producedDate),dateUtil.getCurrentYMDHMSStr()) < bread.getShelfLife()*24*60*60){
                //全麦面包，在过期当天可以半价出售
                bread.setPrice(bread.getPrice()/2);
            }
        }else if (Type.equals("CerealBread")){//杂粮面包
            bread=new CerealBread();
            bread.prepare(producedDate);
            //判断是否过期
            if(dateUtil.SecDiff(dateUtil.date2ymdHmsStr(producedDate),dateUtil.date2ymdHmsStr(date)) > bread.getShelfLife()*24*60*60 ){
                bread = null;
            } else if(dateUtil.DayDiff(dateUtil.date2ymdHmsStr(producedDate),dateUtil.getCurrentYMDHMSStr()) >= 2 && HMSdate.after(dateUtil.getCurrentHMSDate("07:00:00")) && HMSdate.before(dateUtil.getCurrentHMSDate("09:00:00")))
            {   //杂粮面包，在过期当天的早上07:00-09:00免费领取
                bread.setPrice(0);
            }

        }else if (Type.equals("TunaBread")){//金枪鱼三明治
            bread=new TunaBread();
            bread.prepare(producedDate);
            //判断是否过期
            if(dateUtil.SecDiff(dateUtil.date2ymdHmsStr(producedDate),dateUtil.date2ymdHmsStr(date)) > bread.getShelfLife()*24*60*60 ){
                bread = null;
            }
        }
        return bread;
    }

}
