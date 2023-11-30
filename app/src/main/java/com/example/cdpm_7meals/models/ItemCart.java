package com.example.cdpm_7meals.models;

public class ItemCart {
    private Product2 product;
    private int quantity;

    public ItemCart(Product2 product, int quantity) {
        this.product = product;
        this.quantity = quantity; // Số lượng mặc định là 1 khi thêm mới vào giỏ hàng
    }

    public Product2 getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }
}
