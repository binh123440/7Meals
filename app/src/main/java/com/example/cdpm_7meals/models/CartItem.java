package com.example.cdpm_7meals.models;

public class CartItem extends Product{

    private int quantity;
    public CartItem() {
        super();
    }

    public CartItem(int id, String imageSrc, String name, String desc, long price, int categoryID, int quantity) {
        super(id, imageSrc, name, desc, price, categoryID);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
