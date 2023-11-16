package com.example.cdpm_7meals.data;

import com.example.cdpm_7meals.models.Profile;
import com.example.cdpm_7meals.models.UserHelperClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;

public class UpData {
    public void Add_ProfileData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String phonenumber = "0563499836";
        Profile profile = new Profile("Lê Ngọc Hào", "0563499836", "nam", "28-09-2023", "48 Cao Thắng", "lekimnam", "lekimnam");
        //Thêm đối tượng lên Firebase
        myRef.child(phonenumber).setValue(profile);
    }
}
