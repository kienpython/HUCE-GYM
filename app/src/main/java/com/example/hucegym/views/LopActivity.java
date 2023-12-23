package com.example.hucegym.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.adapter.LopAdapter;
import com.example.hucegym.adapter.NhanVienAdapter;
import com.example.hucegym.connect.ApiLop;
import com.example.hucegym.connect.ApiNhanVien;
import com.example.hucegym.model.Lop;
import com.example.hucegym.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LopActivity extends AppCompatActivity {
    private RecyclerView rcvLop;
    private List<Lop> mListLop;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt);
        rcvLop = findViewById(R.id.rcvPT);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvLop.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvLop.addItemDecoration(itemDecoration);
        callApiGetLop();

    }
    private void callApiGetLop(){
        ApiLop.apiLop.getListLops().enqueue(new Callback<List<Lop>>() {
            @Override
            public void onResponse(Call<List<Lop>> call, Response<List<Lop>> response) {
                mListLop = new ArrayList<>();
                mListLop = response.body();

                LopAdapter lopAdapter = new LopAdapter(mListLop, LopActivity.this);
                rcvLop.setAdapter(lopAdapter);
            }

            @Override
            public void onFailure(Call<List<Lop>> call, Throwable t) {
                Toast.makeText(LopActivity.this,"onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
