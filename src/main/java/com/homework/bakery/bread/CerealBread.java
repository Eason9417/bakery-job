package com.homework.bakery.bread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CerealBread extends Bread{
    @Override
    public void prepare(Date producedDate) {
        setName("杂粮面包");
        setPrice(10.00);
        setProducedDate(producedDate);
        setShelfLife(3);
    }

}
