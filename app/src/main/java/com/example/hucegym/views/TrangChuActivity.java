package com.example.hucegym.views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hucegym.CheckCalendarActivity;
import com.example.hucegym.viewmodel.TrangChuViewModel;
import com.example.hucegym.R;

public class TrangChuActivity extends AppCompatActivity {

    private TrangChuViewModel viewModel;
    private ImageButton ibtnRules;
    private ImageButton ibtnFeedBack;
    private Button btnCheckCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        feedBack();
        checkCalendar();
    }

    // Chuyển trang sang phần điều khoản
    private void startRulesActivity() {
        Intent intent = new Intent(TrangChuActivity.this, RulesActivity.class);
        startActivity(intent);
    }

    // Chuyển sang phần góp ý
    private void startFeedBackActivity() {
        Intent intent = new Intent(TrangChuActivity.this, FeedbackActivity.class);
        startActivity(intent);
    }
    // Xử lý sự kiện nút góp ý
    private void feedBack(){
        ibtnFeedBack = findViewById(R.id.ibtnGopY);
        ibtnFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFeedBackActivity();
            }
        });
    }

    // Chuyển sang phần góp ý
    private void startCheckCalendarActivity() {
        Intent intent = new Intent(TrangChuActivity.this, CheckCalendarActivity.class);
        startActivity(intent);
    }
    // Xử lý sự kiện nút góp ý
    private void checkCalendar(){
        btnCheckCalendar = findViewById(R.id.btnCheckCalendar);
        btnCheckCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startCheckCalendarActivity();
            }
        });
    }
}
