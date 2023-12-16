package com.example.hucegym.views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hucegym.viewmodel.TrangChuViewModel;
import com.example.hucegym.R;

public class TrangChuActivity extends AppCompatActivity {

    private TrangChuViewModel viewModel;
    private ImageButton ibtnRules;
    private ImageButton ibtnFeedBack;
    private Button btnCheckCalendar;
    private Button btnHealthMonitoring;
    private ImageButton imgExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        feedBack();
        checkCalendar();
        healthMonitoring();
        exercisesActivity();
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

    // Chuyển sang phần theo dõi sức khỏe
    private void startHealthMonitoringActivity() {
        Intent intent = new Intent(TrangChuActivity.this, HealthMonitoring.class);
        startActivity(intent);
    }
    // Xử lý sự kiện nút theo dõi sức khỏe
    private void healthMonitoring(){
        btnHealthMonitoring = findViewById(R.id.btnHealthMonitoring);
        btnHealthMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startHealthMonitoringActivity();
            }
        });
    }

    // Chuyển sang phần xem bài tập
    private void startExercisesActivity() {
        Intent intent = new Intent(TrangChuActivity.this, ExercisesActivity.class);
        startActivity(intent);
    }
    // Xử lý sự kiện nút xem bài tập
    private void exercisesActivity(){
        imgExercises = findViewById(R.id.imgExercises);
        imgExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startExercisesActivity();
            }
        });
    }
}
