package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.example.cdpm_7meals.R;

public class ViewHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCenter.start(getApplication(), "{Your app secret here}",
                Analytics.class, Crashes.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
    }
}
//"34ef7473-57db-4f1c-9421-ef824de2750d"