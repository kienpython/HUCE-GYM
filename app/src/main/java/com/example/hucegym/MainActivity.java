package com.example.hucegym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView txtQuenMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
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

    // Xử lý sự kiện
}