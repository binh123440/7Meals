package com.example.cdpm_7meals.data;

import static com.makeramen.roundedimageview.RoundedDrawable.TAG;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.models.Product;
import com.example.cdpm_7meals.models.Profile;
import com.example.cdpm_7meals.models.User;
import com.example.cdpm_7meals.models.UserHelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Data {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");

    public void Add_Data_Food() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dr = db.getReference("products");

        Product product1 = new Product(1,R.drawable.fried_chicken_and_fried_rice_1,"Egg fried rice with chicken","Made from fried rice with eggs and served with fried chicken", 80000,1);
        Product product2 = new Product(2,R.drawable.fried_chicken_and_fried_rice,"Fried rice with fried chicken and fat","Made from rice and chicken coated with fat for grilling", 50000,1);
        Product product3 = new Product(3,R.drawable.burger,"Beef Burger with special sauce","With a sauce made from a blend of cream and cheese, it creates a burger with a bold Asian flavor", 50000,2);
        Product product4 = new Product(4,R.drawable.chicken_burger,"Burger Chicken","A normal burger but the main ingredient is fried chicken", 50000,2);
        Product product5 = new Product(5,R.drawable.fried_chicken,"Fried chicken thighs","Plump chicken thighs are soaked in egg and rolled in breadcrumbs", 50000,3);
        Product product6 = new Product(6,R.drawable.chicken_satay,"Grilled chicken wings with satay","Grilled with satay gives it a flavor that is both spicy and salty", 135000,3);

        dr.child("Egg fried rice with chicken").setValue(product1);
        dr.child("Fried rice with fried chicken and fat").setValue(product2);
        dr.child("Beef Burger with special sauce").setValue(product3);
        dr.child("Burger Chicken").setValue(product4);
        dr.child("Fried chicken thighs").setValue(product5);
        dr.child("Grilled chicken wings with satay").setValue(product6);
    }

    public void Add_Data_Nam() {
        //get all value
        String firstName = "Le";
        String lastName = "Kim Nam";
        String phoneNum = "0123456780";
        String Gender = "nam";
        String Birthday = "1/1/2003";
        String Address = "305 Tran Cao Van";
        String Password = "nam123";
        User user = new User(R.drawable.anh_nam,firstName,lastName,phoneNum,Gender,Birthday,Address,Password);
        myRef.child(phoneNum).setValue(user);
    }

    public void Add_Data_Binh() {
        //get all value
        String firstName = "Le";
        String lastName = "Ha Binh";
        String phoneNum = "0123456780";
        String Gender = "nam";
        String Birthday = "1/1/2003";
        String Address = "100 Dang Thuy Tram";
        String Password = "binh123";
        User user = new User(R.drawable.anh_binh,firstName,lastName,phoneNum,Gender,Birthday,Address,Password);
        myRef.child(phoneNum).setValue(user);
    }

    public void Add_Data_Quy() {
        //get all value
        String firstName = "Le";
        String lastName = "Phu Quy";
        String phoneNum = "0123456781";
        String Gender = "nam";
        String Birthday = "1/1/2003";
        String Address = "48 Cao Thang";
        String Password = "quy123";
        User user = new User(R.drawable.anh_binh,firstName,lastName,phoneNum,Gender,Birthday,Address,Password);
        myRef.child(phoneNum).setValue(user);
    }

    public void Add_Data_Hieu() {
        //get all value
        String firstName = "Huynh";
        String lastName = "Trong Hieu";
        String phoneNum = "0123456782";
        String Gender = "nam";
        String Birthday = "1/1/2003";
        String Address = "100 Tran Cao Van";
        String Password = "hieu123";
        User user = new User(R.drawable.anh_binh,firstName,lastName,phoneNum,Gender,Birthday,Address,Password);
        myRef.child(phoneNum).setValue(user);
    }

    public void Add_Data_Hao() {
        //get all value
        String firstName = "Le";
        String lastName = "Ngoc Hao";
        String phoneNum = "0123456783";
        String Gender = "nam";
        String Birthday = "1/1/2003";
        String Address = "156 Le Do";
        String Password = "hao123";
        User user = new User(R.drawable.anh_binh,firstName,lastName,phoneNum,Gender,Birthday,Address,Password);
        myRef.child(phoneNum).setValue(user);
    }

    public void Add_Data_Tien() {
        //get all value
        String firstName = "Huynh";
        String lastName = "Van Tien";
        String phoneNum = "0123456784";
        String Gender = "nam";
        String Birthday = "1/1/2003";
        String Address = "10 Dien Bien Phu";
        String Password = "tien123";
        User user = new User(R.drawable.anh_binh,firstName,lastName,phoneNum,Gender,Birthday,Address,Password);
        myRef.child(phoneNum).setValue(user);
    }
}
