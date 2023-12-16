package com.example.hucegym.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.hucegym.R;

public class HealthMonitoring extends AppCompatActivity {
    private ImageButton ibtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_monitoring);
        healthMonitoring();
    }

    // Chuyển sang phần trang chủ
    private void startLoginActivity() {
        Intent intent = new Intent(HealthMonitoring.this, TrangChuActivity.class);
        startActivity(intent);
        finish();
    }

    // Xử lý sự kiện nút theo dõi sức khỏe
    private void healthMonitoring(){
        ibtnBack = findViewById(R.id.ibtnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startLoginActivity();
            }
        });
    }
}