package com.example.citysights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {
    TextView textView;
    String token, tokenExpiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        textView = findViewById(R.id.dashboard_textview);


//        SharedPreferences sh = getSharedPreferences("UserToken", Context.MODE_PRIVATE);
//        token = sh.getString("token","");
//        tokenExpiry = sh.getString("tokenExpiry","");
//
//        textView.setText("The expiry of login token is "+tokenExpiry);

        SharedPreferences sh = getSharedPreferences("UserToken", Context.MODE_PRIVATE);
        token = sh.getString("token","");
        tokenExpiry = sh.getString("tokenExpiry","");

        textView.setText("The expiry of login token is "+tokenExpiry);

    }

    public void Maps(View view){
        Intent intent = new Intent(DashBoard.this, MapsActivity.class);
        startActivity(intent);
    }

}