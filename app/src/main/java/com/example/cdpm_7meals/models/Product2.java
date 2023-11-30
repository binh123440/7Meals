package com.example.cdpm_7meals.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product2 implements Parcelable {
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


    protected Product2(Parcel in) {
        id = in.readInt();
        image = in.readString();
        name = in.readString();
        desc = in.readString();
        price = in.readLong();
        categoryID = in.readInt();
    }

    public static final Creator<Product2> CREATOR = new Creator<Product2>() {
        @Override
        public Product2 createFromParcel(Parcel in) {
            return new Product2(in);
        }

        @Override
        public Product2[] newArray(int size) {
            return new Product2[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(image);
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeLong(price);
        dest.writeInt(categoryID);
    }
}
