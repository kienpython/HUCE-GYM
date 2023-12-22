package com.example.hucegym.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.hucegym.R;
import com.example.hucegym.databinding.ActivityTrangChuBinding;
import com.example.hucegym.model.Photo;
import com.example.hucegym.viewmodel.HoiVienViewModel;
import com.example.hucegym.viewmodel.TrangChuViewModel;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class TrangChuActivity extends AppCompatActivity {

    private TrangChuViewModel viewModel;
    private ImageButton ibtnRules;
    private ImageButton ibtnFeedBack;
    private Button btnCheckCalendar;
    private Button btnHealthMonitoring;
    private ViewPager2 mViewPager;
    private ImageButton ibtnNhacNho;
    private ImageButton imageButtonCaNhan;

    private CircleIndicator3 mCircleIndicator;

    private List<Photo> mListPhoto;
    private HoiVienViewModel hoiVienViewModel;
    private ActivityTrangChuBinding activityTrangChuBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        exercisesActivity();
        checkcanhan();
        checkNhacNho();

        int idHv = getIntent().getIntExtra("id_hv", -1);

        // Khởi tạo ViewModel
        hoiVienViewModel = new ViewModelProvider(this).get(HoiVienViewModel.class);

        // Lấy dữ liệu từ ViewModel sử dụng id_hv
        hoiVienViewModel.loadHoiVien(String.valueOf(idHv));


    }

    // Chuyển sang trang exercises
    private void exercisesActivity(){
        activityTrangChuBinding = DataBindingUtil.setContentView(this,R.layout.activity_trang_chu);
        TrangChuViewModel trangChuViewModel = new TrangChuViewModel(TrangChuActivity.this);
        activityTrangChuBinding.setTrangChuViewModel(trangChuViewModel);
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

    // xem cá nhân
    private void startHoiVienActivity() {
        Intent intent = new Intent(TrangChuActivity.this, HoiVienActivity.class);
        startActivity(intent);
    }
    private void checkcanhan(){
        imageButtonCaNhan = findViewById(R.id.imageButtonCaNhan);
        imageButtonCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startHoiVienActivity();
            }
        });
    }

    // xem nhắc nhở
    private void startNhacNhoActivity() {
        Intent intent = new Intent(TrangChuActivity.this, NhacNhoActivity.class);
        startActivity(intent);
    }
    private void checkNhacNho(){
        ibtnNhacNho = findViewById(R.id.ibtnNhacNho);
        ibtnNhacNho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startNhacNhoActivity();
            }
        });
    }

}