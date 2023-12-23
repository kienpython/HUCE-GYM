package com.example.hucegym.connect;

import com.example.hucegym.model.Exercises;
import com.example.hucegym.model.NhanVien;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiNhanVien {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    ApiNhanVien apiNhanVien = new Retrofit.Builder()
            .baseUrl("https://hucegym.000webhostapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiNhanVien.class);

    @GET("api_tbl_nhan_vien.php")
    Call<List<NhanVien>> getListNhanViens();
}
