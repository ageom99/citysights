package com.example.citysights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserSignUp extends AppCompatActivity {

    EditText firstname, lastname, email_id, password, confirm_password, user_location;
    TextView error;
    String first_name, last_name, emailid, passwrd, cnfrmpassword, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
    }

    public void SignUp(View view){

        firstname = findViewById(R.id.user_first_name);
        lastname = findViewById(R.id.user_last_name);
        email_id = findViewById(R.id.user_email);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        user_location = findViewById(R.id.user_address);
        error = findViewById(R.id.api_error);


        first_name = firstname.getText().toString();
        last_name = lastname.getText().toString();
        emailid = email_id.getText().toString();
        passwrd = password.getText().toString();
        cnfrmpassword = confirm_password.getText().toString();
        address = user_location.getText().toString();

        RegistrationPojo registrationPojo = new RegistrationPojo();
        registrationPojo.setEmail(emailid);
        registrationPojo.setFname(first_name);
        registrationPojo.setLname(last_name);
        registrationPojo.setPassword(passwrd);
        registrationPojo.setAddress(address);

        if(first_name.isEmpty()){
            firstname.setError("Enter first name");
        }
        else if(last_name.isEmpty()){
            lastname.setError("Enter last name");
        }
        else if(emailid.isEmpty()){
            email_id.setError("Enter email id");
        }
        else if(passwrd.isEmpty()){
            password.setError("Enter Password");
        }
        else if(cnfrmpassword.isEmpty()){
            confirm_password.setError("Confirm your password");
        }
        else if(!passwrd.equals(cnfrmpassword)){
            confirm_password.setError("Passwords don't match");
        }
        else{
            //Toast.makeText(this, "Sign up clicked successfully", Toast.LENGTH_SHORT).show();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://34.228.32.106:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            APIInterface apiInterface = retrofit.create(APIInterface.class);

            Call<RegistrationPojo> call = apiInterface.getMessage(registrationPojo);

            call.enqueue(new Callback<RegistrationPojo>() {
                @Override
                public void onResponse(Call<RegistrationPojo> call, Response<RegistrationPojo> response) {
                    if(!response.isSuccessful()){
                        if(response.code() ==500) {
                            error.setText(R.string.user_already_registered);
                        }
                        else{
                            error.setText(R.string.registration_error);
                        }

                    }
                    else{
                        error.setText(R.string.user_registered);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(UserSignUp.this,UserLogin.class);
                                startActivity(intent);
                            }
                        },3000);

                    }
                }

                @Override
                public void onFailure(Call<RegistrationPojo> call, Throwable t) {
                    error.setText("The error is: "+t.toString());
                }
            });
        }
    }
}