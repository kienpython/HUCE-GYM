package com.example.hucegym.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hucegym.R;
import com.example.hucegym.adapter.NhacNhoAdapter;
import com.example.hucegym.databinding.ActivityNhacNhoBinding;
import com.example.hucegym.viewmodel.NhacNhoViewModel;

import java.util.ArrayList;

public class NhacNhoActivity extends AppCompatActivity {

    private NhacNhoViewModel nhacNhoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_nhac_nho); // Loại bỏ dòng này

        // Sử dụng DataBindingUtil để thiết lập binding
        ActivityNhacNhoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_nhac_nho);

        nhacNhoViewModel = new ViewModelProvider(this).get(NhacNhoViewModel.class);

        NhacNhoAdapter adapter = new NhacNhoAdapter(new ArrayList<>(), nhacNho -> {
            // Xử lý khi nhấn vào một mục nhắc nhở
        });

        binding.recyclerViewNhacNho.setAdapter(adapter);
        binding.recyclerViewNhacNho.setLayoutManager(new LinearLayoutManager(this));

        nhacNhoViewModel.getListNhacNho().observe(this, adapter::submitList);
    }
}
