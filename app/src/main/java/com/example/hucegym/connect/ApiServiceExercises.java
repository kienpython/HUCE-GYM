package com.example.hucegym.connect;

import com.example.hucegym.model.Exercises;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiServiceExercises {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    ApiServiceExercises apiServiceExercises = new Retrofit.Builder()
            .baseUrl("https://hucegym.000webhostapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceExercises.class);

    @GET("api_tbl_bai_tap.php")
    Call<List<Exercises>> getListUsers(); // Thay đổi từ Call sang Observable
}
