package com.example.hucegym.viewmodel;

import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {

    // Các biến hoặc phương thức khác
    private boolean isRegistrationSuccessful;

    public boolean registerUser(String username, String password) {
        // Kiểm tra giá trị không trống
        if (!username.isEmpty() && !password.isEmpty()) {
            // Đăng ký thành công
            isRegistrationSuccessful = true;
        } else {
            // Đăng ký không thành công
            isRegistrationSuccessful = false;
        }

        return isRegistrationSuccessful;
    }

    // Các phương thức khác
}
