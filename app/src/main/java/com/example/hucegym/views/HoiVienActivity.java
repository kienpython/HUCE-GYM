package com.example.hucegym.views;

import android.os.Bundle;
import android.widget.Button;
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

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            // Gọi phương thức đăng xuất từ ViewModel
            hoiVienViewModel.logout();
            finish();
        });

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
        TextView textViewGioiTinhHV = findViewById(R.id.textViewGioiTinhHV);
        TextView textViewTuoiHV = findViewById(R.id.textViewTuoiHV);
        TextView textViewSDTHV = findViewById(R.id.textViewSDTHV);
        TextView textViewEmailHV = findViewById(R.id.textViewEmailHV);
        TextView textViewCMNDHV = findViewById(R.id.textViewCMNDHV);
        TextView textViewBienxeHV = findViewById(R.id.textViewBienxeHV);


        // Liên kết với ViewModel để theo dõi dữ liệu
        hoiVienViewModel.getHoiVienList().observe(this, hoiVienList -> {
            if (hoiVienList != null && hoiVienList.size() > 0) {
                HoiVien hoiVien = hoiVienList.get(0); // Lấy thông tin của hội viên đầu tiên
                textViewIDHV.setText(hoiVien.getId_hv());
                textViewHoTenHV.setText(hoiVien.getName_hv());
                textViewNgaySinhHV.setText(hoiVien.getNgay_sinh());
                textViewGioiTinhHV.setText(hoiVien.getGioi_tinh());
                textViewTuoiHV.setText(hoiVien.getTuoi());
                textViewSDTHV.setText(hoiVien.getSdt());
                textViewEmailHV.setText(hoiVien.getEmail());
                textViewCMNDHV.setText(hoiVien.getCmnd());
                textViewBienxeHV.setText(hoiVien.getBien_xe());
            }
        });
    }

    private void updateUI(List<HoiVien> hoiVienList) {
        // Cập nhật giao diện người dùng khi có dữ liệu mới từ ViewModel
    }

}
