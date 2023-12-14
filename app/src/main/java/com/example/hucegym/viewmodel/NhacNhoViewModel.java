package com.example.hucegym.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.hucegym.model.NhacNho;

import java.util.ArrayList;
import java.util.List;

public class NhacNhoViewModel extends ViewModel {
    // Có thể chứa danh sách các nhắc nhở
    // Hoặc gọi API để lấy danh sách từ server

    // Ví dụ danh sách không mềm
    private List<NhacNho> danhSachNhacNho = new ArrayList<>();

    public NhacNhoViewModel() {
        // Khởi tạo dữ liệu mẫu
        danhSachNhacNho.add(new NhacNho("Nhắc nhở 1", "Nội dung nhắc nhở 1"));
        danhSachNhacNho.add(new NhacNho("Nhắc nhở 2", "Nội dung nhắc nhở 2"));
        // Thêm các mục khác nếu cần
    }

    public List<NhacNho> getDanhSachNhacNho() {
        return danhSachNhacNho;
    }
}


