package com.homework.bakery.order;

import com.homework.bakery.bread.Bread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderBread {
    BreadFactory breadFactory;
    Bread bread = null;

    public void OrderBread(BreadFactory simpleFactory) {
        setBreadFactory(simpleFactory);
    }

    public void setBreadFactory(BreadFactory breadFactory) {
        String Type = "";
        this.breadFactory = breadFactory;
        do {
            Date producedDate = null;
            bread = this.breadFactory.createBread(Type,producedDate);
            //输出pizza
            if (bread != null){
                System.out.println("订购成功");
            }else {
                System.out.println("订购失败");
                break;
            }
        }while (true);
    }

}
