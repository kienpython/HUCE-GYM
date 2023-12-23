package com.example.hucegym.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.hucegym.R;
import com.example.hucegym.adapter.ExercisesAdapter;
import com.example.hucegym.adapter.HealthMonitoringAdapter;
import com.example.hucegym.connect.ApiHealthMonitoring;
import com.example.hucegym.connect.ApiServiceExercises;
import com.example.hucegym.model.Exercises;
import com.example.hucegym.model.HoiVien;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthMonitoring extends AppCompatActivity {
    private ImageButton ibtnBack;
    private int id_hv;
    private RecyclerView rcvHealthMonitoring;
    private List<HoiVien> mListHoiVien;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIdHv();
        setContentView(R.layout.activity_health_monitoring);
        rcvHealthMonitoring = findViewById(R.id.rcv_HealthMonitoring);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvHealthMonitoring.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvHealthMonitoring.addItemDecoration(itemDecoration);
        callApiGetHealthMonitoring();
        healthMonitoring();
    }

    //Lấy id_hv khi đăng nhập
    private void getIdHv(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            id_hv = (int) bundle.get("id_hv");
        }
    }
    private void callApiGetHealthMonitoring(){
        ApiHealthMonitoring.apiHealthMonitoring.getListUsers().enqueue(new Callback<List<HoiVien>>() {
            @Override
            public void onResponse(Call<List<HoiVien>> call, Response<List<HoiVien>> response) {
                mListHoiVien = new ArrayList<>();
                mListHoiVien = response.body();
                // Tìm hội viên cần tìm theo id
                for (HoiVien hv : mListHoiVien)
                {
                    if(hv.getId_hv()==id_hv){
                        HealthMonitoringAdapter healthMonitoringAdapter = new HealthMonitoringAdapter(hv, HealthMonitoring.this, id_hv);
                        rcvHealthMonitoring.setAdapter(healthMonitoringAdapter);
                        break;
                    }
                }

            }

            @Override
            public void onFailure(Call<List<HoiVien>> call, Throwable t) {
                Toast.makeText(HealthMonitoring.this,"onFailure", Toast.LENGTH_SHORT).show();
            }
        });
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