package com.example.hucegym.views;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hucegym.R;
import com.example.hucegym.model.Lop;
import com.example.hucegym.model.NhanVien;

public class DetailNhanVienActivity extends AppCompatActivity {
    private TextView id_nv;
    private TextView name;
    private TextView gioi_tinh;
    private TextView tuoi;
    private TextView sdt;
    private TextView gmail;
    private NhanVien nhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pt_chi_tiet);
        getObjectNhanVien();
        setThongTinNhanVien(nhanVien);
    }

    // Lấy lớp khi ấn vào xem chi tiết
    private void getObjectNhanVien() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nhanVien = (NhanVien) bundle.getSerializable("NhanVien");
        }
    }

    private void setThongTinNhanVien(NhanVien nhanVien) {
        if (nhanVien == null) {
            Toast.makeText(this, "Lỗi: Không có thông tin lớp học.", Toast.LENGTH_SHORT).show();
            return;
        }

        id_nv = findViewById(R.id.textMaNV);
        name = findViewById(R.id.textTenNV);
        tuoi = findViewById(R.id.textTuoiNV);
        sdt = findViewById(R.id.textSĐTNV);
        gmail = findViewById(R.id.textGamilNV);
        gioi_tinh = findViewById(R.id.textGioiTinhNV);

        id_nv.setText(String.valueOf(nhanVien.getId_nv()));
        name.setText(String.valueOf(nhanVien.getName()));
        tuoi.setText(String.valueOf(nhanVien.getTuoi()));
        sdt.setText(String.valueOf(nhanVien.getSdt()));
        gmail.setText(String.valueOf(nhanVien.getGmail()));
        gioi_tinh.setText(String.valueOf(nhanVien.getGioi_tinh()));

    }
}
