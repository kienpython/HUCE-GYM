package com.example.hucegym.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.hucegym.BR;
import com.example.hucegym.connect.ApiService;
import com.example.hucegym.connect.RetrofitClient;
import com.example.hucegym.model.User;
import com.example.hucegym.views.RegisterActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends BaseObservable {
    private String username;
    private String password;
    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void navigateToRegister() {
        Log.d("LoginViewModel", "chuyển qua Register");
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    public void loginUser() {
        ApiService apiService = RetrofitClient.getRetroClient().create(ApiService.class);
        Call<User> call = apiService.loginUser(username, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        // Xử lý đăng nhập thành công, ví dụ:
                        String name = user.getUsername();
                        String chucVu = user.getChuc_vu();
                    } else {
                        // Xử lý đăng nhập thất bại
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Xử lý lỗi kết nối
            }
        });
    }
}
