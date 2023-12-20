package com.example.hucegym.views;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.hucegym.R;
import com.example.hucegym.model.HoiVien;
import com.example.hucegym.viewmodel.HoiVienViewModel;

import java.util.List;

public class HoiVienActivity extends AppCompatActivity {
    private HoiVienViewModel hoiVienViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_nhan);

        // Khởi tạo ViewModel
        hoiVienViewModel = new ViewModelProvider(this).get(HoiVienViewModel.class);

        // Liên kết dữ liệu với layout
        bindViews();

        // Lấy dữ liệu từ ViewModel
        hoiVienViewModel.getHoiVienList().observe(this, this::updateUI);

        // Gọi phương thức để tải dữ liệu
        hoiVienViewModel.loadHoiVienList();
    }

    private void bindViews() {
        // Các TextView trong layout
        TextView textViewIDHV = findViewById(R.id.textViewIDHV);
        TextView textViewHoTenHV = findViewById(R.id.textViewHoTenHV);
        TextView textViewNgaySinhHV = findViewById(R.id.textViewNgaySinhHV);
        // ... (Thêm các TextView khác)

        // Liên kết với ViewModel để theo dõi dữ liệu
        hoiVienViewModel.getHoiVienList().observe(this, hoiVienList -> {
            if (hoiVienList != null && hoiVienList.size() > 0) {
                HoiVien hoiVien = hoiVienList.get(0); // Lấy thông tin của hội viên đầu tiên
                textViewIDHV.setText(hoiVien.getId_hv());
                textViewHoTenHV.setText(hoiVien.getName_hv());
                textViewNgaySinhHV.setText(hoiVien.getNgay_sinh());
                // ... (Thiết lập dữ liệu cho các TextView khác)
            }
        });
    }

    private void updateUI(List<HoiVien> hoiVienList) {
        // Cập nhật giao diện người dùng khi có dữ liệu mới từ ViewModel
    }
}
