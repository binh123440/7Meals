package com.example.cdpm_7meals.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Food implements Parcelable {
    public  static  final  int  Rice=1  , Ham=2, Chicken=3;
    private int image;
    private String name;
    private String dacta;
    private long gia;
    private int type;

    public Food(int image, String name, String dacta, long gia, int type) {
        this.image = image;
        this.name = name;
        this.dacta = dacta;
        this.gia = gia;
        this.type = type;
    }

    protected Food(Parcel in) {
        image = in.readInt();
        name = in.readString();
        dacta = in.readString();
        gia = in.readLong();
        type = in.readInt();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDacta() {
        return dacta;
    }

    public void setDocta(String dacta) {
        this.dacta = dacta;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(dacta);
        dest.writeLong(gia);
        dest.writeInt(type);
    }
}