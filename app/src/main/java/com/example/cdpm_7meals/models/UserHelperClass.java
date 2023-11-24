package com.example.cdpm_7meals.models;

public class UserHelperClass {
    String firstname, lastname, phonenum , gender, birthday, adress , password, image;

    public UserHelperClass() {
    }

    public UserHelperClass(String firstname, String lastname, String phonenum, String gender, String birthday, String adress, String password,String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenum = phonenum;
        this.gender = gender;
        this.birthday = birthday;
        this.adress = adress;
        this.password = password;
        this.image = image;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
