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
import com.example.cdpm_7meals.data.UserSingleton;
import com.example.cdpm_7meals.models.FirebaseImageUploader;
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
                //get all value
                String firstName = firstname.getEditText().getText().toString();
                String lastName = lastname.getEditText().getText().toString();
                String phoneNum = phonenum.getEditText().getText().toString();
                String Gender = gender.getEditText().getText().toString();
                String Birthday = birthday.getEditText().getText().toString();
                String Address = address.getEditText().getText().toString();
                String Password = password.getEditText().getText().toString();
                String Image = phoneNum;

                FirebaseImageUploader firebaseImageUploader = new FirebaseImageUploader(this);
                firebaseImageUploader.uploadImageToFireBasFromUri(imageUri,Image);
                UserHelperClass helperClass = new UserHelperClass(firstName, lastName, phoneNum, Gender, Birthday, Address, Password, Image);
                reference_users.child(phoneNum).setValue(helperClass);

                startActivity(new Intent(SignIn.this, AppActivity.class));

                UserSingleton userSingleton = UserSingleton.getInstance();
                userSingleton.setUsername(phoneNum);
                userSingleton.setNameimg(phoneNum);
            }
        });

        btn_chooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameimg = phonenum + "jpg";
                nameImg.setText(nameimg);
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
        if (imageUri != null) {
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            // Lấy tên người dùng
            String nameImg = firstname.getEditText().getText().toString(); // Thay thế bằng cách lấy tên người dùng từ nơi nào đó

            // Tạo thư mục con "users" trong thư mục gốc "images"
            StorageReference usersRef = storageRef.child("images/users");

            // Tạo thư mục con với tên người dùng
            StorageReference userImagesRef = usersRef.child(nameImg);

            // Tạo reference cho ảnh trong thư mục của người dùng
            StorageReference imageRef = userImagesRef.child(nameImg + ".jpg");

            // Upload ảnh lên Firebase Storage
            imageRef.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Ảnh đã được upload thành công
                            // Lấy URL của ảnh để lưu vào cơ sở dữ liệu hoặc hiển thị
                            // ...

                            // Tiếp theo, bạn có thể chuyển đến Activity khác hoặc thực hiện các thao tác khác
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Đã xảy ra lỗi trong quá trình upload ảnh
                            // ...
                        }
                    });
        } else {
            // Hiển thị thông báo cho người dùng rằng họ cần chọn ảnh trước khi đăng ký
            // ...
        }
    }
}