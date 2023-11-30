package com.example.cdpm_7meals.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private List<ItemCart> cartItems;
    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(Product2 product, int quantity) {
        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        for (ItemCart item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                // Nếu đã tồn tại, tăng số lượng lên
                item.incrementQuantity();
                return;
            }
        }

        // Nếu chưa tồn tại, thêm mới vào giỏ hàng
        cartItems.add(new ItemCart(product,quantity));
    }
    public double getCountItemCart(){
        double tongtien=0;
        for (ItemCart item : cartItems){
            tongtien += item.getQuantity() * item.getProduct().getPrice();
        }
        return tongtien;
    }
    public double getCountItemCart2(){
        double tongtien=15000;
        for (ItemCart item : cartItems){
            tongtien += item.getQuantity() * item.getProduct().getPrice();
        }
        return tongtien;
    }

    public List<ItemCart> getCartItems() {
        return cartItems;
    }
}
