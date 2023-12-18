package com.example.hucegym.connect;

import com.example.hucegym.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServiceLogin {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    ApiServiceLogin apiServiceLogin = new Retrofit.Builder()
            .baseUrl("https://hucegym.000webhostapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceLogin.class);
    @GET("select_api_accouts.php")
    Call<List<User>> getListUsers();

}
