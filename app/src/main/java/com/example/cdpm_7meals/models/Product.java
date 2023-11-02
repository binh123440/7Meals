package com.example.cdpm_7meals.models;

public class Product {
    private int id;
    private String imageSrc;
    private String name;
    private String desc;
    private long price;
    private int categoryID;

    public Product(){}

    public Product(int id, String imageSrc, String name, String desc , long price, int categoryID) {
        this.id = id;
        this.imageSrc = imageSrc;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.categoryID = categoryID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
