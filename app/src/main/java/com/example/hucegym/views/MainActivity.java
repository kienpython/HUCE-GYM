package com.example.hucegym.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.hucegym.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    TextView txtQuenMatKhau;
    private Button btnDangNhap;
    private EditText edUsername;
    private EditText edPassword;
    private Button btnDangKy;
    private List<User> mListUser;

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

    //Call API
    private void getListUsers(){
        ApiServiceLogin.apiServiceLogin.getListUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mListUser = response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call api error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Xử lý sự kiện đăng nhập
    public void login(){
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        // Bắt sự kiện khi điều khoản được click
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getListUsers();
                String strUsername = edUsername.getText().toString().trim();
                String strPassword = edPassword.getText().toString().trim();
//              Rỗng thì không làm gì cả
                if (mListUser==null || mListUser.isEmpty()){
                    return;
                }

                boolean isHasUser = false;
                for (User user : mListUser){
                    if (strUsername.equals(user.getUsername()) && strPassword.equals(user.getPassword())){
                        isHasUser = true;
                        break;
                    }
                }

                if (isHasUser){
                    startLoginActivity();
                }
                else{
                    Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
                }

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
