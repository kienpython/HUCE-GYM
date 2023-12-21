package com.example.hucegym.connect;

import com.example.hucegym.model.NhacNho;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiServiceNhacNho {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    ApiServiceNhacNho apiServiceNhacNho = new Retrofit.Builder()
            .baseUrl("https://hucegym.000webhostapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServiceNhacNho.class);
    @GET("api_tbl_notice.php")
    Call<List<NhacNho>> getListNhacNho();
}
