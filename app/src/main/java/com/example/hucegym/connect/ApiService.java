package com.example.hucegym.connect;

import com.example.hucegym.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("da_web_nc/model/modals_ktc/CSDL/taikhoan.php")
    Call<User> loginUser(
            @Field("username") String username,
            @Field("password") String password
    );
}
