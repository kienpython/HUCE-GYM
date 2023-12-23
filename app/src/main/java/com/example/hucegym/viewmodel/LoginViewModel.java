package com.example.hucegym.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

import com.example.hucegym.BR;
import com.example.hucegym.R;
import com.example.hucegym.connect.ApiServiceLogin;
import com.example.hucegym.model.User;
import com.example.hucegym.views.MainActivity;
import com.example.hucegym.views.RegisterActivity;
import com.example.hucegym.views.TrangChuActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends BaseObservable {
    private String username;
    private String password;
    private int id_hv;
    private List<User> mListUser;
    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isShowMessage = new ObservableField<>();
    public ObservableField<Boolean> isSuccess = new ObservableField<>();
    public Context context;

    public LoginViewModel(Context context) {
        getListUsers();
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

    //Call API
    private void getListUsers(){
        ApiServiceLogin.apiServiceLogin.getListUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mListUser = response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "Call api error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Xử lý sự kiện đăng nhập
    public void onClickLogin() {

        // Khi click vào button đăng nhập thì mới hiện message
        isShowMessage.set(true);
//      Rỗng thì không làm gì cả
        if (mListUser==null || mListUser.isEmpty()){
            return;
        }

        boolean isHasUser = false;
        for (User user : mListUser){
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                id_hv = user.getId_hv();
                isHasUser = true;
                break;
            }
        }

        if (isHasUser){
            startLoginActivity(id_hv);
            isSuccess.set(true);
        }
        else{
            isSuccess.set(false);
            messageLogin.set("Username or password invalid!");
        }
    }

    // Chuyển trang đến trang chủ
    private void startLoginActivity(int id_hv) {
        Intent intent = new Intent(context, TrangChuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id_hv",id_hv);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
