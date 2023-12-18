package com.example.hucegym.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hucegym.R;


public class MainActivity extends AppCompatActivity {
    TextView txtQuenMatKhau;
    private Button btnDangNhap;
    private Button btnDangKy;
    private String[] danhSachGoiTap = {"Gói Tập A", "Gói Tập B", "Gói Tập C", "Gói Tập D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
        register();
        init();
    }
    //Khởi tạo các thành phần
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

    // Xử lý sự kiện đăng nhập
    public void login(){
        btnDangNhap = findViewById(R.id.btnDangNhap);
        // Bắt sự kiện khi điều khoản được click
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoginActivity();
            }
        });
    }
    // Chuyển trang đến trang chủ
    private void startLoginActivity() {
        Intent intent = new Intent(MainActivity.this, TrangChuActivity.class);
        startActivity(intent);
        finish();
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
