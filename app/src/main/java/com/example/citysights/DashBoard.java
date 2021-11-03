package com.example.citysights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {
    TextView textView;
    String token, tokenExpiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        textView = findViewById(R.id.dashboard_textview);

<<<<<<< HEAD
//        SharedPreferences sh = getSharedPreferences("UserToken", Context.MODE_PRIVATE);
//        token = sh.getString("token","");
//        tokenExpiry = sh.getString("tokenExpiry","");
//
//        textView.setText("The expiry of login token is "+tokenExpiry);
=======
        SharedPreferences sh = getSharedPreferences("UserToken", Context.MODE_PRIVATE);
        token = sh.getString("token","");
        tokenExpiry = sh.getString("tokenExpiry","");

        textView.setText("The expiry of login token is "+tokenExpiry);
>>>>>>> b51c265 (Second Commit)


    }

}