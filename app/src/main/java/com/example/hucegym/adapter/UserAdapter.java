package com.example.hucegym.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.model.User;
import com.example.hucegym.views.MainActivity;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private final List<User> mListUser;

    public UserAdapter(List<User> mListUser) {
        this.mListUser = mListUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_login, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null) {
            return;
        }
        holder.edUsername.setText(user.getUsername());
        holder.edPassword.setText(user.getPassword());
    }

    @Override
    public int getItemCount() {
        if (mListUser != null) {
            return mListUser.size();
        }
        return 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private final EditText edUsername;
        private final EditText edPassword;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            edUsername = itemView.findViewById(R.id.edUsername);
            edPassword = itemView.findViewById(R.id.edPassword);
        }
    }

    // Thêm phương thức để kiểm tra đăng nhập
//    public void checkLogin(int position) {
//        if (currentViewHolder != null) {
//            User user = mListUser.get(position);
//            if (user != null) {
//                if (currentViewHolder.edUsername.getText().toString().equals(user.getUsername()) && currentViewHolder.edPassword.getText().toString().equals(user.getPassword())) {
//                    // Hiển thị Toast khi đăng nhập thành công
//                    Toast.makeText(currentViewHolder.itemView.getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
//                } else {
//                    // Hiển thị Toast khi đăng nhập không thành công
//                    Toast.makeText(currentViewHolder.itemView.getContext(), "Tài khoản hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }

//    }

}
