package com.example.cdpm_7meals.data;

import static com.makeramen.roundedimageview.RoundedDrawable.TAG;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cdpm_7meals.models.Profile;
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
    public void Add_ProfileData() {
        DatabaseReference myRef = database.getReference("profiles");

        String name = "Lê Hà Bình";
        Profile profile = new Profile("Lê Hà Bình", "0563499836", "nam", "28-09-2003", "48 Cao Thắng", "lathequyen", "lathequyen");
        //Thêm đối tượng lên Firebase
        myRef.child(name).setValue(profile);
    }

    public void GetDataUser(String phonenum, final OnDataReceivedListener listener) {
        DatabaseReference myRef = database.getReference("profiles/" + phonenum);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> list = new ArrayList<>();
                if (snapshot.exists()) {
                    list.add(snapshot.child("lastname").getValue(String.class));
                    list.add(snapshot.child("phonenum").getValue(String.class));
                    list.add(snapshot.child("gender").getValue(String.class));
                    list.add(snapshot.child("birthday").getValue(String.class));
                    list.add(snapshot.child("address").getValue(String.class));
                    list.add(snapshot.child("password").getValue(String.class));

                    // Gửi dữ liệu đến listener khi dữ liệu được nhận
                    listener.onDataReceived(list);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void GetDataProfile(String username, final OnDataReceivedListener listener) {
        DatabaseReference myRef = database.getReference("profiles/" + username);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> list = new ArrayList<>();
                if (snapshot.exists()) {
                    list.add(snapshot.child("name").getValue(String.class));
                    list.add(snapshot.child("phoneNumber").getValue(String.class));
                    list.add(snapshot.child("gender").getValue(String.class));
                    list.add(snapshot.child("birthday").getValue(String.class));
                    list.add(snapshot.child("address").getValue(String.class));
                    list.add(snapshot.child("username").getValue(String.class));
                    list.add(snapshot.child("password").getValue(String.class));

                    // Gửi dữ liệu đến listener khi dữ liệu được nhận
                    listener.onDataReceived(list);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    // Định nghĩa một interface để lắng nghe sự kiện khi dữ liệu được nhận
    public interface OnDataReceivedListener {
        void onDataReceived(ArrayList<String> data);
    }
}
