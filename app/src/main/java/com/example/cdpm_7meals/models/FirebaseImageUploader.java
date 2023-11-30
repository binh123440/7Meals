package com.example.cdpm_7meals.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.cdpm_7meals.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class FirebaseImageUploader {
    private View.OnClickListener mContext;

    public FirebaseImageUploader(View.OnClickListener context){
        this.mContext = context;
    }

    public void uploadImageToFireBasFromUri(Uri selectedImg, String phoneNum){
        // Tiếp tục với quá trình tải lên Firebase Storage sử dụng Uri từ file đã lưu
        String filename = phoneNum;
        String path = "images/users/" + filename; // Đường dẫn trong Storage

        // Gọi putFile(fileUri) để tải file lên Firebase Storage
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child(path);
        storageRef.putFile(selectedImg)
                .addOnSuccessListener(taskSnapshot -> {
                    // Xử lý khi tải lên thành công
                    Log.d("FirebaseImageUploader","Upload successfull");
                })
                .addOnFailureListener(exception -> {
                    // Xử lý khi tải lên thất bại
                    Log.d("FirebaseImageUploader","Upload failed "+ exception.getMessage());
                });
    }
}

