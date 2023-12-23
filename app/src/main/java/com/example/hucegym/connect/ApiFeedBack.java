package com.example.hucegym.connect;

import com.example.hucegym.model.Exercises;
import com.example.hucegym.model.FeedBack;
import com.example.hucegym.model.FeedBackModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiFeedBack {
    @POST("handle_feed_back.php")
    @FormUrlEncoded
    Observable<FeedBackModel> callFeedBack(
            @Field("noi_dung_gop_y") String noi_dung_gop_y,
            @Field("email") String email,
            @Field("status") int status,
            @Field("ten_co_so") String ten_co_so,
            @Field("ten_hoi_vien") String ten_hoi_vien,
            @Field("so_dien_thoai") String so_dien_thoai
    );
}
