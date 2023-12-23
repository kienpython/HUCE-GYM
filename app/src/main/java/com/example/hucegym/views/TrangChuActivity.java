package com.example.hucegym.views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import com.example.hucegym.adapter.PhotoViewPagerAdapter;
import com.example.hucegym.databinding.ActivityTrangChuBinding;
import com.example.hucegym.model.Photo;
import com.example.hucegym.viewmodel.TrangChuViewModel;
import com.example.hucegym.R;

import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator3;

public class TrangChuActivity extends AppCompatActivity {

    private TrangChuViewModel viewModel;
    private ImageButton ibtnRules;
    private ImageButton ibtnFeedBack;
    private Button btnCheckCalendar;
    private Button btnHealthMonitoring;
    private ViewPager2 mViewPager;
    private CircleIndicator3 mCircleIndicator;

    private List<Photo> mListPhoto;
    private int id_hv;

    private ActivityTrangChuBinding activityTrangChuBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        getIdHv();
        exercisesActivity();
        loadSlide();
//        feedBack();
//        checkCalendar();
        healthMonitoring();

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

}
