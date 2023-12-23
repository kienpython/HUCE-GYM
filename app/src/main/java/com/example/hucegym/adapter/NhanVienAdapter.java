package com.example.hucegym.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.model.Exercises;
import com.example.hucegym.model.Lop;
import com.example.hucegym.model.NhanVien;
import com.example.hucegym.views.DetailLopActivity;
import com.example.hucegym.views.DetailNhanVienActivity;
import com.example.hucegym.views.NhanVienActivity;

import java.io.Serializable;
import java.util.List;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.NhanVienViewHolder>{

    private final List<NhanVien> mListNhanVien;
    private final Context mContext;

    public NhanVienAdapter(List<NhanVien> mListNhanVien, Context mContext) {
        this.mListNhanVien = mListNhanVien;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NhanVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pt_row_item,parent,false);
        return new NhanVienAdapter.NhanVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NhanVienViewHolder holder, int position) {
        final NhanVien nhanVien = mListNhanVien.get(position);
        if (nhanVien == null){
            return;
        }
        holder.tvMaNV.setText(String.valueOf(nhanVien.getId_nv()));
        holder.tvTenNV.setText(nhanVien.getName());
        holder.tvTuoiNV.setText(String.valueOf(nhanVien.getTuoi()));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickWatchDetail(nhanVien);
            }
        });
    }

    private void onClickWatchDetail(NhanVien nhanVien){
        Intent intent = new Intent(mContext, DetailNhanVienActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("NhanVien", (Serializable) nhanVien); // Sử dụng putParcelable nếu Lop implement Parcelable
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        if (mListNhanVien != null) {
            return mListNhanVien.size();
        }
        return 0;
    }

    public static class NhanVienViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvMaNV;
        private final TextView tvTenNV;
        private final TextView tvTuoiNV;
        private LinearLayout layout;

        public NhanVienViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_item_nhan_vien);
            tvMaNV = itemView.findViewById(R.id.tvMaNV);
            tvTenNV = itemView.findViewById(R.id.tvTenNV);
            tvTuoiNV = itemView.findViewById(R.id.tvTuoiNV);

        }
    }
}
