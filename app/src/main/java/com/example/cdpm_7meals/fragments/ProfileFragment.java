package com.example.cdpm_7meals.fragments;

import static com.makeramen.roundedimageview.RoundedDrawable.TAG;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cdpm_7meals.activities.IntroActivity;
import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.activities.DeleteAccountActivity;
import com.example.cdpm_7meals.activities.ProfileActivity;
import com.example.cdpm_7meals.activities.RulesActivity;
import com.example.cdpm_7meals.adapters.ProfileAdapter;
import com.example.cdpm_7meals.data.Data;
import com.example.cdpm_7meals.models.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProfileFragment extends Fragment {

    ListView list;
    String List[] = {"Profile","Request account deletion","Terms and Policies","Log out"};
    Date date;
    String name,phonenumber,gender,birthday,address,username,password;

    String loginPhoneNum;
    TextView tv_fullname;

    int flags[]={R.drawable.iconavatar,R.drawable.caidat,R.drawable.warningoctagon,R.drawable.signout};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        tv_fullname = view.findViewById(R.id.full_name);

        list = view.findViewById(R.id.list);
        ProfileAdapter adapter = new ProfileAdapter(getContext(),List,flags);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        Intent myintent = new Intent(getContext(), ProfileActivity.class);
                        ArrayList<String> list = new ArrayList<>();

                        Bundle bundle = getArguments();
                        if (bundle != null) {
                            String username = bundle.getString("phonenumber");
                            new Data().GetDataUser(loginPhoneNum, new Data.OnDataReceivedListener() {
                                @Override
                                public void onDataReceived(ArrayList<String> data) {
                                    if (!data.isEmpty()) {
                                        // Đảm bảo rằng danh sách không rỗng trước khi truy cập phần tử đầu tiên
                                        loginPhoneNum = data.get(0);
                                        tv_fullname.setText(loginPhoneNum);
                                        // Tiếp tục xử lý dữ liệu theo nhu cầu của bạn
                                    } else {
                                        Log.e(TAG, "Danh sách dữ liệu rỗng.");
                                    }
                                }
                            });
                        }

                        new Data().GetDataProfile(loginPhoneNum, new Data.OnDataReceivedListener() {
                            @Override
                            public void onDataReceived(ArrayList<String> data) {
                                if (!data.isEmpty()) {
                                    // Đảm bảo rằng danh sách không rỗng trước khi truy cập phần tử đầu tiên
                                    myintent.putExtra("name",data.get(0));
                                    myintent.putExtra("phonenumber",data.get(1));
                                    myintent.putExtra("gender",data.get(2));
                                    myintent.putExtra("birthday",data.get(3));
                                    myintent.putExtra("address",data.get(4));
                                    myintent.putExtra("username",data.get(5));
                                    myintent.putExtra("password",data.get(6));
                                    startActivity(myintent);
                                    // Tiếp tục xử lý dữ liệu theo nhu cầu của bạn
                                } else {
                                    Log.e(TAG, "Danh sách dữ liệu rỗng.");
                                }
                            }
                        });
                        break;
                    case 1:
                        Intent myintent2 = new Intent(getContext(), DeleteAccountActivity.class);
                        startActivity(myintent2);
                        break;
                    case 2:
                        Intent myintent3 = new Intent(getContext(), RulesActivity.class);
                        startActivity(myintent3);
                        break;
                    case 3: OpenDia(Gravity.CENTER); break;


                }


            }
        });

        return view;
    }

    public void OpenDia (int gravity)
    {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_logout);
        Window window =dialog.getWindow();
        if(window==null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams wda= window.getAttributes();
        wda.gravity= gravity;
        window.setAttributes(wda);
        if(Gravity.BOTTOM==gravity)
        {
            dialog.setCancelable(true);

        } else
            dialog.setCancelable(false);
        Button btno = dialog.findViewById(R.id.btno);
        Button btyes = dialog.findViewById(R.id.btyes);
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startActivity(new Intent(getContext(), IntroActivity.class));
            }
        });
        dialog.show();
    }

}