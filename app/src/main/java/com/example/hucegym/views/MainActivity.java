package com.example.hucegym.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hucegym.R;
import com.example.hucegym.adapter.UserAdapter;
import com.example.hucegym.connect.ApiServiceLogin;
import com.example.hucegym.databinding.ActivityLoginBinding;
import com.example.hucegym.model.User;
import com.example.hucegym.viewmodel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    TextView txtQuenMatKhau;
    private Button btnDangKy;
    private ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
        register();
        init();
    }
//    Khởi tạo các thành phần
    public void init(){
        try{
            txtQuenMatKhau = findViewById(R.id.txtQuenMatKhau);
            String htmlcontent = "<u>Quên mật khẩu</u>";
            txtQuenMatKhau.setText(Html.fromHtml(htmlcontent));
        }catch (Exception ex)
        {
            Log.e("Init", ex.getMessage());
        }
    }
    public void login(){
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        LoginViewModel loginViewModel = new LoginViewModel(MainActivity.this);
        activityLoginBinding.setLoginViewModel(loginViewModel);
    }


//    Xử lý sự kiện khi ấn vào nút đăng ký
    public void register(){
        btnDangKy = findViewById(R.id.btnDangKy);
        // Bắt sự kiện khi điều khoản được click
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });
    }
    // Chuyển trang đến đăng ký
    private void startRegisterActivity() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
//        finish();
    }

}
