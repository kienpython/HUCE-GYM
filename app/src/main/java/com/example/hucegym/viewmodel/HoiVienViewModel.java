package com.example.hucegym.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hucegym.model.HoiVien;

public class HoiVienViewModel extends ViewModel {
    private MutableLiveData<HoiVien> hoiVienData;

    public MutableLiveData<HoiVien> getHoiVienData() {
        if (hoiVienData == null) {
            hoiVienData = new MutableLiveData<>();
            loadHoiVienData();
        }
        return hoiVienData;
    }

    private void loadHoiVienData() {
        // Gọi Retrofit hoặc API để lấy dữ liệu hội viên từ server
        // Sau khi nhận được dữ liệu, cập nhật giá trị của hoiVienData
        // HoiVien hoiVien = ...;
        // hoiVienData.setValue(hoiVien);
    }
}
