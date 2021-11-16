package com.example.citysights;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("auth/login")
    Call<LoginToken> getToken(@Body LoginCredentials loginCredentials);

    @POST("auth/register")
    Call<RegistrationPojo> getMessage(@Body RegistrationPojo registrationPojo);

    @GET("admin/users")
    Call<UserDetailsListData> getUserDetails(@Header("Authorization") String authToken );
}
