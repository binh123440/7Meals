package com.example.cdpm_7meals.data;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.models.CartItem;
import com.example.cdpm_7meals.models.Food;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public TestData() {}
    public static ArrayList<CartItem> getCartItems() {
        ArrayList<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem(1, "fried_chicken_and_fried_rice_1", "Egg fried rice with chicken", "Made from fried rice with eggs and served with fried chicken", 80000, 1, 1));
        cartItems.add(new CartItem(2, "fried_chicken_and_fried_rice", "Fried rice with fried chicken and fat", "Made from rice and chicken coated with fat for grilling", 50000, 2, 2));
        cartItems.add(new CartItem(3, "burger", "Beef Burger with special sauce", "With a sauce made from a blend of cream and cheese, it creates a burger with a bold Asian flavor", 50000, 3, 3));
        cartItems.add(new CartItem(4, "chicken_burger", "Burger Chicken", "A normal burger but the main ingredient is fried chicken", 50000, 2, 2));
        cartItems.add(new CartItem(5, "fried_chicken", "Fried chicken thighs", "Plump chicken thighs are soaked in egg and rolled in breadcrumbs", 135000, 3, 2));
        return cartItems;
    }

    public static ArrayList<Food> getListFood()
    {
        ArrayList<Food> list =new ArrayList<>();
        list.add(new Food(R.drawable.fried_chicken_and_fried_rice_1,"Egg fried rice with chicken","Made from fried rice with eggs and served with fried chicken",80000,Food.Rice));
        list.add(new Food(R.drawable.fried_chicken_and_fried_rice,"Fried rice with fried chicken and fat","Made from rice and chicken coated with fat for grilling",50000,Food.Rice));
        list.add(new Food(R.drawable.burger,"Beef Burger with special sauce","With a sauce made from a blend of cream and cheese, it creates a burger with a bold Asian flavor",50000,Food.Ham));
        list.add(new Food(R.drawable.chicken_burger,"Burger Chicken","A normal burger but the main ingredient is fried chicken",50000,Food.Ham));
        list.add(new Food(R.drawable.fried_chicken,"Fried chicken thighs","Plump chicken thighs are soaked in egg and rolled in breadcrumbs",50000,Food.Chicken));
        list.add(new Food(R.drawable.chicken_satay,"Grilled chicken wings with satay","Grilled with satay gives it a flavor that is both spicy and salty",135000,Food.Chicken));
        list.add(new Food(R.drawable.fried_chicken_and_fried_rice_1,"Egg fried rice with chicken","Made from fried rice with eggs and served with fried chicken",80000,Food.Rice));
        list.add(new Food(R.drawable.fried_chicken_and_fried_rice,"Fried rice with fried chicken and fat","Made from rice and chicken coated with fat for grilling",50000,Food.Rice));
        list.add(new Food(R.drawable.burger,"Beef Burger with special sauce","With a sauce made from a blend of cream and cheese, it creates a burger with a bold Asian flavor",50000,Food.Ham));
        list.add(new Food(R.drawable.chicken_burger,"Burger Chicken","A normal burger but the main ingredient is fried chicken",50000,Food.Ham));
        list.add(new Food(R.drawable.fried_chicken,"Fried chicken thighs","Plump chicken thighs are soaked in egg and rolled in breadcrumbs",135000,Food.Chicken));
        list.add(new Food(R.drawable.chicken_satay,"Grilled chicken wings with satay","Grilled with satay gives it a flavor that is both spicy and salty",135000,Food.Chicken));
        return list;
    }
}
