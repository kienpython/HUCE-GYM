package com.example.hucegym.connect;

import com.example.hucegym.model.Exercises;
import com.example.hucegym.model.FeedBackModel;
import com.example.hucegym.model.HoiVien;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiHealthMonitoring {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    ApiHealthMonitoring apiHealthMonitoring = new Retrofit.Builder()
            .baseUrl("https://hucegym.000webhostapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiHealthMonitoring.class);

    @GET("api_tbl_hoi_vien.php")
    Call<List<HoiVien>> getListUsers();
}
