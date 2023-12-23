package com.example.hucegym.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.adapter.ExercisesAdapter;
import com.example.hucegym.adapter.NhanVienAdapter;
import com.example.hucegym.connect.ApiNhanVien;
import com.example.hucegym.connect.ApiServiceExercises;
import com.example.hucegym.model.Exercises;
import com.example.hucegym.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NhanVienActivity extends AppCompatActivity {
    private RecyclerView rcvPT;
    private List<NhanVien> mListPT;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt);
        rcvPT = findViewById(R.id.rcvPT);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvPT.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvPT.addItemDecoration(itemDecoration);
        callApiGetNhanVien();

    }

    private void callApiGetNhanVien(){
        ApiNhanVien.apiNhanVien.getListNhanViens().enqueue(new Callback<List<NhanVien>>() {
            @Override
            public void onResponse(Call<List<NhanVien>> call, Response<List<NhanVien>> response) {
                mListPT = new ArrayList<>();
                mListPT = response.body();

                NhanVienAdapter nhanVienAdapter = new NhanVienAdapter(mListPT, NhanVienActivity.this);
                rcvPT.setAdapter(nhanVienAdapter);
            }

            @Override
            public void onFailure(Call<List<NhanVien>> call, Throwable t) {
                Toast.makeText(NhanVienActivity.this,"onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
