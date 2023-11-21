package com.example.cdpm_7meals.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.models.Image;
import com.example.cdpm_7meals.models.UserHelperClass;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

public class SignIn extends AppCompatActivity {


    TextInputLayout firstname, lastname, phonenum, gender, birthday, address , password;
    private TextView btn_back,btn_showImg;

    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    StorageReference reference_img = FirebaseStorage.getInstance().getReference().child("images");
    DatabaseReference reference_users = rootNode.getReference("users");
    private final static int img_request = 1;
    ProgressBar progressBar;
    private Uri imageUri;
    private EditText nameImg;
    private AppCompatButton btn_signin,btn_chooseImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);




        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
        //status là thanh ở trên
        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        firstname = findViewById(R.id.FirstNamelay);
        lastname = findViewById(R.id.LastNamelay);
        phonenum = findViewById(R.id.phoneNumberlay2);
        gender = findViewById(R.id.GenderLay);
        birthday = findViewById(R.id.BirthdayLay);
        address = findViewById(R.id.AddressLay);
        password = findViewById((R.id.enterPasswordLayout));

        btn_back = findViewById(R.id.nutback);

        progressBar = findViewById(R.id.probar);
        btn_chooseImg = findViewById(R.id.bt_chooseImg);
        nameImg = findViewById(R.id.enterImage);
        btn_showImg = findViewById(R.id.tv_showImg);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, Login.class));
            }
        });

        btn_signin = findViewById(R.id.nutSignin);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    UploadFile();
                    //get all value
                    String firstName = firstname.getEditText().getText().toString();
                    String lastName = lastname.getEditText().getText().toString();
                    String phoneNum = phonenum.getEditText().getText().toString();
                    String Gender = gender.getEditText().getText().toString();
                    String Birthday = birthday.getEditText().getText().toString();
                    String Address = address.getEditText().getText().toString();
                    String Password = password.getEditText().getText().toString();
                    UserHelperClass helperClass = new UserHelperClass(firstName, lastName, phoneNum, Gender, Birthday, Address, Password);
                    reference_users.child(phoneNum).setValue(helperClass);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                startActivity(new Intent(SignIn.this, AppActivity.class));
            }
        });

        btn_chooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        btn_showImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, ShowImage.class);
                intent.putExtra("img",imageUri.toString());
                startActivity(intent);
            }
        });
    }

    // Lựa ảnh từ thiết bị
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,img_request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == img_request && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            Intent intent = new Intent(this, ShowImage.class);
            intent.putExtra("img",imageUri.toString());
            //startActivity(intent);
        }
    }

    // Up ảnh lên store
    private String getFileExtension (Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void UploadFile() throws FileNotFoundException {
        // Tạo đối tượng FirebaseStorage
        FirebaseStorage storage = FirebaseStorage.getInstance();

        // Chọn một thư mục trên Firebase Storage để lưu trữ ảnh (vd: "images")
        StorageReference storageRef = storage.getReference().child("images");

        // Chọn tên tệp cho ảnh (vd: "my_image.jpg")
        String imageName = phonenum.getEditText().toString() + ".jpg";
        StorageReference imageRef = storageRef.child(imageName);

        // Chuyển đổi Uri của ảnh thành InputStream
        InputStream stream = getContentResolver().openInputStream(imageUri);

        // Tải lên ảnh lên Firebase Storage
        UploadTask uploadTask = imageRef.putStream(stream);

        uploadTask.addOnSuccessListener(taskSnapshot -> {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(0);
                }
            }, 5000);
            // Ảnh đã được tải lên thành công
            // Lấy URL của ảnh đã tải lên
            imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                String downloadUrl = uri.toString();
                // Bạn có thể lưu trữ đường dẫn downloadUrl vào Firebase Realtime Database hoặc làm gì đó khác với nó
            });
        }).addOnFailureListener(exception -> {
            Toast.makeText(SignIn.this, "Upload failured", Toast.LENGTH_SHORT).show();
        });
    }
}