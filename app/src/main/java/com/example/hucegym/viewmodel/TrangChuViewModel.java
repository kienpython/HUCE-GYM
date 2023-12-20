package com.example.hucegym.viewmodel;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.BaseObservable;

import com.example.hucegym.views.ExercisesActivity;

public class TrangChuViewModel extends BaseObservable {
    public Context context;

    public TrangChuViewModel(Context context) {
        this.context = context;
    }

    // Chuyển sang phần xem bài tập
    private void startExercisesActivity() {
        Intent intent = new Intent(context, ExercisesActivity.class);
        context.startActivity(intent);
    }
    // Xử lý sự kiện nút xem bài tập
    public void onClickExercises() {
        startExercisesActivity();
    }





//    public void handleXemLich(Context context) {
//        showToast("Xem lịch clicked");
//        startActivity(context, XemLichActivity.class);
//        Intent intent = new Intent(context, XemLichActivity.class);
//        context.startActivity(intent);
//    }
//
//    public void handleTheoDoiSucKhoe(Context context) {
//        showToast("Theo dõi sức khỏe clicked");
//        startActivity(context, TheoDoiSucKhoeActivity.class);
//        Intent intent = new Intent(context, TheoDoiSucKhoeActivity.class);
//        context.startActivity(intent);
//    }
//
//    public void handleXemBaiTap(Context context) {
//        showToast("Xem bài tập clicked");
//        startActivity(context, XemBaiTapActivity.class);
//        Intent intent = new Intent(context, XemBaiTapActivity.class);
//        context.startActivity(intent);
//    }
//
//    public void handleSuKien(Context context) {
//        showToast("Sự kiện clicked");
//        //Thêm logic cho mục Sự kiện ở đây
//    }
//
//    public void handleGoiTap(Context context) {
//        showToast("Gói tập clicked");
//        //Thêm logic cho mục Gói tập ở đây
//    }
//
//    public void handlePT(Context context) {
//        showToast("PT clicked");
//        //Thêm logic cho mục PT ở đây
//    }
//
//    public void handleLop(Context context) {
//        showToast("Lớp clicked");
//        //Thêm logic cho mục Lớp ở đây
//    }
//
//    public void handleDieuKhoan(Context context) {
//        showToast("Điều khoản clicked");
//        //Thêm logic cho mục Điều khoản ở đây
//    }
//
//    public void handleNhacNho(Context context) {
//        showToast("Nhắc nhở clicked");
//        //Thêm logic cho mục Nhắc nhở ở đây
//    }
//
//    public void handleGopY(Context context) {
//        showToast("Góp ý clicked");
//        //Thêm logic cho mục Góp ý ở đây
//    }
//
//    public void handleTrangChu(Context context) {
//        showToast("Trang chủ clicked");
//        //Thêm logic cho mục Trang chủ ở đây
//    }
//
//    // Các phương thức khác tương tự cho các mục còn lại
//
//    // Phương thức chung có thể tái sử dụng cho các mục đích khác
//    private void showToast(String message) {
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//    }
//
//    private void startActivity(Context context, Class<?> cls) {
//        context.startActivity(new Intent(context, cls));
//    }
}
