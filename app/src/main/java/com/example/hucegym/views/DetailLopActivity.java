package com.example.hucegym.views;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hucegym.R;
import com.example.hucegym.model.Lop;

public class DetailLopActivity extends AppCompatActivity {
    private TextView tv_id_lop;
    private TextView id_nv;
    private TextView types_room;
    private TextView ten_lop;
    private TextView packages;
    private TextView ngay_hoat_dong;
    private TextView so_luong_hv;
    private TextView time_start;
    private TextView time_end;
    private Lop lop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lop_chi_tiet);
        getObjectLop();
        setThongTinLop(lop);
    }

    // Lấy lớp khi ấn vào xem chi tiết
    private void getObjectLop() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lop = (Lop) bundle.getSerializable("Lop");
        }
    }

    private void setThongTinLop(Lop lop) {
        if (lop == null) {
            Toast.makeText(this, "Lỗi: Không có thông tin lớp học.", Toast.LENGTH_SHORT).show();
            return;
        }

        tv_id_lop = findViewById(R.id.txt_id_lop_ct);
        id_nv = findViewById(R.id.txt_id_nv);
        types_room = findViewById(R.id.txt_types_room_ct);
        packages = findViewById(R.id.txt_packages);
        ngay_hoat_dong = findViewById(R.id.txt_ngay_hoat_dong);
        so_luong_hv = findViewById(R.id.txt_so_luong_hv);
        ten_lop = findViewById(R.id.txt_ten_lop_ct);
        time_end = findViewById(R.id.txt_time_end);
        time_start = findViewById(R.id.txt_time_start);

        tv_id_lop.setText(String.valueOf(lop.getId_lop()));
        id_nv.setText(String.valueOf(lop.getId_nv()));
        types_room.setText(String.valueOf(lop.getTypes_room()));
        packages.setText(String.valueOf(lop.getPackages()));
        ngay_hoat_dong.setText(String.valueOf(lop.getNgay_hoat_dong()));
        so_luong_hv.setText(String.valueOf(lop.getSo_luong_hv()));
        ten_lop.setText(String.valueOf(lop.getTen_lop()));
        time_end.setText(String.valueOf(lop.getTime_end()));
        time_start.setText(String.valueOf(lop.getTime_start()));
    }
}
