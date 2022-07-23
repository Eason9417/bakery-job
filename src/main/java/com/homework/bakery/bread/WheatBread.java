package com.homework.bakery.bread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WheatBread extends Bread{
    @Override
    public void prepare(Date producedDate) {
        setName("全麦面包");
        setPrice(12.00);
        setProducedDate(producedDate);
        setShelfLife(2);
    }

}
