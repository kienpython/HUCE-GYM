package com.example.hucegym.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.hucegym.R;
import com.example.hucegym.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {

    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Khởi tạo ViewModel
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        // Tìm các view
        EditText usernameEditText = findViewById(R.id.editTextTextPersonName5);
        EditText passwordEditText = findViewById(R.id.editTextTextPersonName6);
        // Thêm các EditText khác nếu cần

        Button registerButton = findViewById(R.id.button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy đầu vào người dùng
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // Lấy đầu vào khác nếu cần

                // Gọi phương thức đăng ký trong ViewModel
                boolean isRegistrationSuccessful = registerViewModel.registerUser(username, password);

                // Xử lý kết quả đăng ký
                if (isRegistrationSuccessful) {
                    // Đăng ký thành công, thực hiện các hành động sau khi đăng ký
                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    // Thêm logic chuyển hướng đến màn hình chính hoặc màn hình đăng nhập
                } else {
                    // Đăng ký không thành công, thông báo người dùng
                    Toast.makeText(RegisterActivity.this, "Đăng ký không thành công. Vui lòng thử lại.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Thêm logic hoặc lắng nghe sự kiện bổ sung nếu cần
    }
}
