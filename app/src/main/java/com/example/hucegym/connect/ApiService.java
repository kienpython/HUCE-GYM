package com.example.hucegym.connect;

import com.example.hucegym.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("C:\\xampp\\htdocs\\login.php")
    Call<User> loginUser(@Body User user);

    // Tạo một instance của Retrofit
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost/login.php") 
            .addConverterFactory(GsonConverterFactory.create()) 
            .build();

    // Tạo một instance của ApiService từ Retrofit
    ApiService apiService = retrofit.create(ApiService.class);

    Call<User> loginUser(String username, String password);
}

