package com.example.cdpm_7meals.models;

import java.util.Date;

public class History {
    public int id;
    public int image;
    public Date orderDay;
    public String name;
    public int quantity;
    public long price;

    public History(int id, int image, Date orderDay, String name, int quantity, long price) {
        this.id = id;
        this.image = image;
        this.orderDay = orderDay;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Date getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Date orderDay) {
        this.orderDay = orderDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
