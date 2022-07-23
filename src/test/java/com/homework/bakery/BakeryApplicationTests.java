package com.homework.bakery;

import com.homework.bakery.bread.Bread;
import com.homework.bakery.order.BreadFactory;
import com.homework.bakery.order.BreadStore;
import com.homework.bakery.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Date;

@SpringBootTest
class BakeryApplicationTests {
    String s1 = "WheatBread";//全麦面包
    String s2 = "CerealBread";//杂粮面包
    String s3 = "TunaBread";//金枪鱼三明治
    DateUtil dateUtil = new DateUtil();
    BreadStore breadStore = new BreadStore();
    BreadFactory breadFactory = new BreadFactory();
    Date currentYMDHMSDate = dateUtil.getCurrentYMDHMSDate(dateUtil.getCurrentYMDHMSStr());

    @Test
    public void test1() {//测试购买功能，三种面包各购买一个结账
        //一天前的时间
        long time1 = currentYMDHMSDate.getTime() - 24*60*60*1000 ;
        Date date1 = new Date(time1);
        //生产三种面包，且面包均未过期
        Bread wheatBread = breadFactory.createBread(s1, date1);
        Bread cerealBread = breadFactory.createBread(s2, date1);
        Bread tunaBread = breadFactory.createBread(s3, date1);
        //购买三种面包
        breadStore.orderByBread(wheatBread);
        breadStore.orderByBread(cerealBread);
        breadStore.orderByBread(tunaBread);
        System.out.println("订单共计" + breadStore.getSum() + "元");
    }

    @Test
    public void test2() {//测试有肉的面包过期之后，是否立刻销毁
        long time4 = currentYMDHMSDate.getTime() - (24*60*60*1000+1000);
        Date date4 = new Date(time4);
        Bread tunaBread = breadFactory.createBread(s3, date4);
        if(tunaBread == null){
            System.out.println("该面包过期已销毁");
        }else{
            System.out.println("该面包过期未销毁");
        }

    }
    @Test
    public void test3() {//测试全麦面包在过期当天是否半价出售
        long time5 = currentYMDHMSDate.getTime() - (24*60*60*1000+5000);
        Date date5 = new Date(time5);
        Bread wheatBread = breadFactory.createBread(s1, date5);
        breadStore.orderByBread(wheatBread);
        System.out.println(breadStore.getSum());
        if (breadStore.getSum() == 6){
            System.out.println("全麦面包当前为半价：" + wheatBread.getPrice());
        }

    }
    @Test
    public void test4(){//测试杂粮面包，在过期当天的早上07:00-09:00免费领取。
        long time6 = currentYMDHMSDate.getTime() - (3*24*60*60*1000);
        Date date6 = new Date(time6);
        //设置免费领取的时段为当前系统时间前一个小时至后一个小时
        Bread cerealBread = breadFactory.createBread(s2, date6);
        breadStore.orderByBread(cerealBread);
        Date HMSdate = dateUtil.getCurrentHMSDate(dateUtil.getCurrentHMSStr());
        if (HMSdate.after(dateUtil.getCurrentHMSDate("07:00:00")) && HMSdate.before(dateUtil.getCurrentHMSDate("09:00:00"))){
            if (breadStore.getSum() == 0){
                System.out.println("当前时间为免费领取时间，杂粮面包可免费领取");
            }
        }else{
            System.out.println("当前时间不是免费领取时间，购买杂粮面包需要花费" + breadStore.getSum() + "元");
        }



    }


}
