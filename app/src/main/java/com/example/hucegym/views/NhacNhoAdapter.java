package com.example.hucegym.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.model.NhacNho;

import java.util.List;

    public class NhacNhoAdapter extends RecyclerView.Adapter<NhacNhoAdapter.NhacNhoViewHolder> {

        private List<NhacNho> danhSachNhacNho;

        public NhacNhoAdapter(List<NhacNho> danhSachNhacNho) {
            this.danhSachNhacNho = danhSachNhacNho;
        }

        @NonNull
        @Override
        public NhacNhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nhac_nho_row_item, parent, false);
            return new NhacNhoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NhacNhoViewHolder holder, int position) {
            NhacNho nhacNho = danhSachNhacNho.get(position);
            holder.txtTieuDe.setText(nhacNho.getTieuDe());
            holder.txtNoiDung.setText(nhacNho.getNoiDung());
        }

        @Override
        public int getItemCount() {
            return danhSachNhacNho.size();
        }

        public class NhacNhoViewHolder extends RecyclerView.ViewHolder {

            TextView txtTieuDe;
            TextView txtNoiDung;

            public NhacNhoViewHolder(@NonNull View itemView) {
                super(itemView);
                txtTieuDe = itemView.findViewById(R.id.txt_name_nhac_nho);
                txtNoiDung = itemView.findViewById(R.id.txt_noi_dung_nhac_nho);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Xử lý khi item được nhấn
                        // Có thể chuyển sang màn hình chi tiết nhắc nhở
                    }
                });
            }
        }

}
