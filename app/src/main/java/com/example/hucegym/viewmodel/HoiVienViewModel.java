package com.example.hucegym.viewmodel;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hucegym.connect.ApiServiceCaNhan;
import com.example.hucegym.model.HoiVien;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoiVienViewModel extends ViewModel {

    private MutableLiveData<List<HoiVien>> hoiVienList = new MutableLiveData<>();

    public LiveData<List<HoiVien>> getHoiVienList() {
        return hoiVienList;
    }

    public void loadHoiVienList() {
        ApiServiceCaNhan.apiServiceCaNhan.getListHoiVien().enqueue(new Callback<List<HoiVien>>() {
            @Override
            public void onResponse(Call<List<HoiVien>> call, Response<List<HoiVien>> response) {
                if (response.isSuccessful()) {
                    hoiVienList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<HoiVien>> call, Throwable t) {
                // Xử lý lỗi nếu có
            }
        });
    }
    public void logout() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        startActivity(intent);
    }
    private void finish() {
    }
    private void startActivity(Intent intent) {
    }

    public void loadHoiVien(String s) {
    }
}
