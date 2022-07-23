package com.homework.bakery.bread;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Bread {
    protected String name;
    protected double price;
    protected Date producedDate;
    protected int shelfLife;

    public abstract void prepare(Date producedDate);

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Date getProducedDate() {
        return producedDate;
    }

    public int getShelfLife() {
        return shelfLife;
    }
}
