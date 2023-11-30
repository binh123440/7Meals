package com.example.cdpm_7meals.models;

public class Image {
    private String phoneNum,img;

    public Image(String phoneNum,String img) {
        this.phoneNum = phoneNum;
        this.img = img;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
