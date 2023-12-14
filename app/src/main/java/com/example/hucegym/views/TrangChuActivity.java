package com.example.hucegym.views;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hucegym.viewmodel.TrangChuViewModel;
import com.example.hucegym.R;

public class TrangChuActivity extends AppCompatActivity {

    private TrangChuViewModel viewModel;
    private ImageButton btnRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        btnRules = findViewById(R.id.btnRules);
        // Bắt sự kiện khi điều khoản được click
        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRulesActivity();
            }
        });

//
//        viewModel = new TrangChuViewModel();
//
//        ImageButton xemLichButton = findViewById(R.id.button5);
//        ImageButton theoDoiSucKhoeButton = findViewById(R.id.button3);
//        ImageButton xemBaiTapButton = findViewById(R.id.button4);
//        //Thêm ImageButton và TextView khác tương tự
//
//        TextView trangChuTextView = findViewById(R.id.textView);
//        TextView xemLichTextView = findViewById(R.id.textView24);
//        TextView theoDoiSucKhoeTextView = findViewById(R.id.textView3);
//        //Thêm TextView khác tương tự
//
//        // Bắt sự kiện khi Xem Lịch được click
//        xemLichButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.handleXemLich(TrangChuActivity.this);
//            }
//        });
//
//        // Bắt sự kiện khi Theo Dõi Sức Khỏe được click
//        theoDoiSucKhoeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.handleTheoDoiSucKhoe(TrangChuActivity.this);
//            }
//        });
//
//        // Bắt sự kiện khi Xem Bài Tập được click
//        xemBaiTapButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.handleXemBaiTap(TrangChuActivity.this);
//            }
//        });
//
//        //Thêm sự kiện cho các ImageButton và TextView khác
    }

    // Chuyển trang sang phần điều khoản
    private void startRulesActivity() {
        Intent intent = new Intent(TrangChuActivity.this, RulesActivity.class);
        startActivity(intent);
    }

}
