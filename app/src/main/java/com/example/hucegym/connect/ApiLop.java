package com.example.hucegym.connect;

import com.example.hucegym.model.Lop;
import com.example.hucegym.model.NhanVien;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiLop {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    ApiLop apiLop = new Retrofit.Builder()
            .baseUrl("https://hucegym.000webhostapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiLop.class);

    @GET("api_tbl_lop.php")
    Call<List<Lop>> getListLops();
}
