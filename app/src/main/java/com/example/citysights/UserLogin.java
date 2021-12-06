package com.example.citysights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserLogin extends AppCompatActivity {

    EditText emailid, password;
    String user_email, user_password;
    TextView api_error;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        login = findViewById(R.id.user_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailid = (EditText) findViewById(R.id.user_email);
                password = (EditText) findViewById(R.id.user_password);
                api_error = (TextView) findViewById(R.id.login_error);

                user_email = emailid.getText().toString();
                user_password = password.getText().toString();

                LoginCredentials loginCredentials = new LoginCredentials();
                loginCredentials.setEmail(user_email);
                loginCredentials.setPassword(user_password);

                if(user_email.isEmpty()){
                    emailid.setError("Enter Email id");
                }
                else if(user_password.isEmpty()){
                    password.setError("Enter password");
                }
                else{
                    //Toast.makeText(UserLogin.this,"The user email is "+user_email,Toast.LENGTH_LONG).show();
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://34.228.32.106:8080/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    APIInterface apiInterface = retrofit.create(APIInterface.class);


                    Call<LoginToken> call = apiInterface.getToken(loginCredentials);

                    call.enqueue(new Callback<LoginToken>() {
                        @Override
                        public void onResponse(Call<LoginToken> call, Response<LoginToken> response) {
                            if(!response.isSuccessful()){
                                Toast.makeText(UserLogin.this,"The response code is "+response.code(),Toast.LENGTH_LONG).show();
                                //emailid.setError("The response code is "+response.code());
                            }
                            else{

//                        SharedPreferences sharedPreferences = getSharedPreferences("UserToken", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putString("token", response.body().token);
//                        editor.putString("tokenExpiry",response.body().tokenExpiry);
//                        editor.apply();
                                //Toast.makeText(UserLogin.this,response.body().tokenExpiry.)
                                assert response.body() != null;
                                //Toast.makeText(UserLogin.this,"The token Expiry is"+response.body().getData().getTokenExpiry(),Toast.LENGTH_LONG).show();


                                SharedPreferences sharedPreferences = getSharedPreferences("UserToken", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("token", response.body().getData().getToken());
                                editor.putString("tokenExpiry",response.body().getData().getTokenExpiry());
                                editor.apply();
                                //Toast.makeText(UserLogin.this,response.body().tokenExpiry.)
                                //String metadata = response.body().getMetadata();
                                //Toast.makeText(UserLogin.this,"The token Expiry is"+response.body().getData().getTokenExpiry(),Toast.LENGTH_LONG).show();
                                if(user_email.equals("admin@citisight.com")){
                                    //Toast.makeText(UserLogin.this, "Condition satisfied", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(UserLogin.this,GetUserDetails.class);
                                    startActivity(intent);
                                }
                                else{
                                    Intent intent = new Intent(UserLogin.this,DashBoard.class);
                                    startActivity(intent);
                                }

                                assert response.body() != null;
                                Log.d("The expiry of token is", response.body().getData().getTokenExpiry());
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginToken> call, Throwable t) {
                            api_error.setText("the error is "+t.toString());
                            //Toast.makeText(UserLogin.this,"API calling failed, error is "+t.toString(),Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });

    }


//    public void LogIn(View view){
//        emailid = (EditText) findViewById(R.id.user_email);
//        password = (EditText) findViewById(R.id.user_password);
//        api_error = (TextView) findViewById(R.id.login_error);
//
//        user_email = emailid.getText().toString();
//        user_password = password.getText().toString();
//
//        LoginCredentials loginCredentials = new LoginCredentials();
//        loginCredentials.setEmail(user_email);
//        loginCredentials.setPassword(user_password);
//
//        if(user_email.isEmpty()){
//            emailid.setError("Enter Email id");
//        }
//        else if(user_password.isEmpty()){
//            password.setError("Enter password");
//        }
//        else{
//            Toast.makeText(this,"The user email is "+user_email,Toast.LENGTH_LONG).show();
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl("http://34.228.32.106:8080/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//            APIInterface apiInterface = retrofit.create(APIInterface.class);
//
//
//            Call<LoginToken> call = apiInterface.getToken(loginCredentials);
//
//            call.enqueue(new Callback<LoginToken>() {
//                @Override
//                public void onResponse(Call<LoginToken> call, Response<LoginToken> response) {
//                    if(!response.isSuccessful()){
//                        Toast.makeText(UserLogin.this,"The response code is "+response.code(),Toast.LENGTH_LONG).show();
//                        //emailid.setError("The response code is "+response.code());
//
//                    }
//                    else{
//                        //Toast.makeText(UserLogin.this,"token expiry is "+response.body().tokenExpiry,Toast.LENGTH_LONG).show();
////                        SharedPreferences sharedPreferences = getSharedPreferences("UserToken", Context.MODE_PRIVATE);
////                        SharedPreferences.Editor editor = sharedPreferences.edit();
////                        editor.putString("token", response.body().token);
////                        editor.putString("tokenExpiry",response.body().tokenExpiry);
////                        editor.apply();
//                        Intent intent = new Intent(UserLogin.this,DashBoard.class);
//                        startActivity(intent);
//                        //Log.d("Tag", response.body().token);
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<LoginToken> call, Throwable t) {
//                    api_error.setText("the error is "+t.toString());
//                    Toast.makeText(UserLogin.this,"API calling failed, error is "+t.toString(),Toast.LENGTH_LONG).show();
//                }
//            });
//        }
//    }

    public void signUp(View view){
        Intent intent = new Intent(UserLogin.this, UserSignUp.class);
        this.startActivity(intent);
    }

    public void ForgotPassword(View view){
        Toast.makeText(this,"You clicked on forgot password", Toast.LENGTH_LONG).show();
    }
}