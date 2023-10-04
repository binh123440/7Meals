package com.example.a7teams;

public class Food {
    public  static  final  int  Rice=1  , Ham=2, Chicken=3;
    private int image;
    private String name;
    private String docta;
    private String gia;
    private int type;

    public Food(int image, String name, String docta, String gia, int type) {
        this.image = image;
        this.name = name;
        this.docta = docta;
        this.gia = gia;
        this.type = type;
    }

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

    public String getDocta() {
        return docta;
    }

    public void setDocta(String docta) {
        this.docta = docta;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
