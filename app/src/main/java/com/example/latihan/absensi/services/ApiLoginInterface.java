package com.example.latihan.absensi.services;

import com.example.latihan.absensi.LoginAbsen;
import com.example.latihan.absensi.entity.LoginAbsensi;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiLoginInterface {

    @GET("/loginabsensi/")
    Call<ArrayList<LoginAbsen>> getAllProduct();


    @Multipart
    @POST("/loginabsensi/add")
    Call<String> addLogin(@Part MultipartBody.Part file, @Part("data") RequestBody data);

    @GET("onecalllogin")
    Call<LoginAbsensi> getOneCallLogin(@Query("longitude") String longitude, @Query("latitude") String latitude);
}
