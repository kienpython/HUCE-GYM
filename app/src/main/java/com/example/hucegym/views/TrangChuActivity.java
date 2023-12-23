package com.example.hucegym.views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import com.example.hucegym.adapter.HealthMonitoringAdapter;
import com.example.hucegym.adapter.PhotoViewPagerAdapter;
import com.example.hucegym.connect.ApiHealthMonitoring;
import com.example.hucegym.databinding.ActivityTrangChuBinding;
import com.example.hucegym.model.HoiVien;
import com.example.hucegym.model.Photo;
import com.example.hucegym.viewmodel.TrangChuViewModel;
import com.example.hucegym.R;

import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator3;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrangChuActivity extends AppCompatActivity {

    private TrangChuViewModel viewModel;
    private ImageButton ibtnRules;
    private ImageButton ibtnFeedBack;
    private Button btnCheckCalendar;
    private Button btnHealthMonitoring;
    private ViewPager2 mViewPager;
    private CircleIndicator3 mCircleIndicator;
    private List<HoiVien> mListHoiVien;
    private String userName;
    private TextView tvUserName;
    private List<Photo> mListPhoto;
    private int id_hv;

    private ActivityTrangChuBinding activityTrangChuBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        getIdHv();
        handleUserName();
        exercisesActivity();
        loadSlide();
        feedBack();
        checkCalendar();
        healthMonitoring();
        rules();

    }

    // Cài đặt tên vào chỗ chào người dùng
    private void setUsername(String username){
        tvUserName = findViewById(R.id.tvUserName);
        tvUserName.setText(username);
    }

    // Lấy tên người dùng
    private void handleUserName(){
        ApiHealthMonitoring.apiHealthMonitoring.getListUsers().enqueue(new Callback<List<HoiVien>>() {
            @Override
            public void onResponse(Call<List<HoiVien>> call, Response<List<HoiVien>> response) {
                mListHoiVien = new ArrayList<>();
                mListHoiVien = response.body();
                // Tìm hội viên cần tìm theo id
                for (HoiVien hv : mListHoiVien)
                {
                    if(hv.getId_hv()==id_hv){
                        userName = hv.getName_hv();
                        setUsername(userName);
                        break;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<HoiVien>> call, Throwable t) {
                Toast.makeText(TrangChuActivity.this,"onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Lấy id khi đăng nhập
    private void getIdHv(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            id_hv = (int) bundle.get("id_hv");
        }
    }

    // Thêm ảnh vào viewPager
    private void loadSlide(){
        mViewPager  = findViewById(R.id.view_pager);
        mCircleIndicator  = findViewById(R.id.circle_indicator);
        mListPhoto = getListPhoto();
        PhotoViewPagerAdapter photoViewPagerAdapter = new PhotoViewPagerAdapter(mListPhoto);
        mViewPager.setAdapter(photoViewPagerAdapter);
//        // Kết nối View Pager với Circle Indicator
        mCircleIndicator.setViewPager(mViewPager);
    }
    // Lấy tạo list ảnh tạo slide
    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.img_1));
        list.add(new Photo(R.drawable.img_2));
        list.add(new Photo(R.drawable.img_3));
        list.add(new Photo(R.drawable.img_4));
        return list;
    }

    // Chuyển sang trang exercises
    private void exercisesActivity(){
        activityTrangChuBinding = DataBindingUtil.setContentView(this,R.layout.activity_trang_chu);
        TrangChuViewModel trangChuViewModel = new TrangChuViewModel(TrangChuActivity.this);
        activityTrangChuBinding.setTrangChuViewModel(trangChuViewModel);
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

    // Chuyển sang phần xem lịch
    private void startCheckCalendarActivity() {
        Intent intent = new Intent(TrangChuActivity.this, CheckCalendarActivity.class);
        startActivity(intent);
    }
    // Xử lý sự kiện nút xem lịch
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
        Bundle bundle = new Bundle();
        bundle.putInt("id_hv",id_hv);
        intent.putExtras(bundle);
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

    // Chuyển sang phần điều khoản
    private void startRulesActivity() {
        Intent intent = new Intent(TrangChuActivity.this, RulesActivity.class);
        startActivity(intent);
    }
    // Xử lý sự kiện nút điều khoản
    private void rules(){
        ibtnRules = findViewById(R.id.ibtnRules);
        ibtnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRulesActivity();
            }
        });
    }
}
