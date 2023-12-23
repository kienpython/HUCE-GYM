package com.example.hucegym.retrofit;

import com.example.hucegym.connect.ApiFeedBack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;
    static Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    public static Retrofit getInstance(String baseUrl){
        if(instance==null){
            instance = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return instance;
    }
}
