package com.example.hucegym.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.hucegym.BR;
import com.example.hucegym.connect.ApiServiceLogin;
import com.example.hucegym.model.User;
import com.example.hucegym.views.TrangChuActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends BaseObservable {
    private String username;
    private String password;
    private List<User> mListUser;

    private  int idHv;
    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isShowMessage = new ObservableField<>();
    public ObservableField<Boolean> isSuccess = new ObservableField<>();
    public Context context;
    public int getIdHv() {
        return idHv;
    }

    public void setIdHv(int idHv) {
        this.idHv = idHv;
    }
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
                isHasUser = true;

                idHv = user.getId_hv();
                notifyPropertyChanged(BR._all);
                break;
            }
        }

        if (isHasUser){
            startLoginActivity();
            isSuccess.set(true);
        }
        else{
            isSuccess.set(false);
            messageLogin.set("Username or password invalid!");
        }
    }

    // Chuyển trang đến trang chủ
    private void startLoginActivity() {
        Intent intent = new Intent(context, TrangChuActivity.class);
        intent.putExtra("id_hv", idHv);
        context.startActivity(intent);
    }
}
