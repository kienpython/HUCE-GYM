package com.example.hucegym.connect;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static String Base_url = "http://10.0.2.2/";

    private static Retrofit retrofit;

    public static Retrofit getRetroClient(){
        if(retrofit == null){
            OkHttpClient.Builder okBuilder = new OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30 , TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true);

            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okBuilder.build())
                    .build();
        }
        return retrofit;
    }
}
