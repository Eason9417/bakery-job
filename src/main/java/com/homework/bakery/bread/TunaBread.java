package com.homework.bakery.bread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TunaBread extends Bread{
    @Override
    public void prepare(Date producedDate) {
        setName("金枪鱼三明治");
        setPrice(12.00);
        setProducedDate(producedDate);
        setShelfLife(1);
    }
}
