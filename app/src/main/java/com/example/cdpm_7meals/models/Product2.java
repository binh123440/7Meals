package com.example.cdpm_7meals.models;

public class Product2 {
    private int id;
    private String image;
    private String name;
    private String desc;
    private long price;
    private int categoryID;

    public Product2(){}

    public Product2(int id, String image, String name, String desc, long price, int categoryID) {
        this.id = id;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public long getPrice() {
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
