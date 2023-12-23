package com.example.hucegym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.model.Exercises;
import com.example.hucegym.model.HoiVien;

import java.util.List;

public class HealthMonitoringAdapter extends RecyclerView.Adapter<HealthMonitoringAdapter.HealthMonitoringViewHolder>{
    private final HoiVien hv;
    private final Context mContext;
    private final int id_hv;

    public HealthMonitoringAdapter(HoiVien hv, Context mContext, int id_hv) {
        this.hv = hv;
        this.mContext = mContext;
        this.id_hv = id_hv;
    }

    @NonNull
    @Override
    public HealthMonitoringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_health_monitoring,parent,false);
        return new HealthMonitoringAdapter.HealthMonitoringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthMonitoringViewHolder holder, int position) {
        final HoiVien hoiVien = hv;
        if (hoiVien == null){
            return;
        }

        holder.tvChieuCao.setText(String.valueOf(hoiVien.getChieu_cao()));
        holder.tvCanNang.setText(String.valueOf(hoiVien.getCan_nang()));
        holder.tvPhanTramMo.setText(String.valueOf(hoiVien.getPhan_tram_mo()));
    }

    @Override
    public int getItemCount() {
        if (hv != null) {
            return 1;
        }
        return 0;
    }

    public static class HealthMonitoringViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvChieuCao;
        private final TextView tvCanNang;
        private final TextView tvPhanTramMo;
        private LinearLayout layout;

        public HealthMonitoringViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_item_health_monitoring);
            tvChieuCao = itemView.findViewById(R.id.tvChieuCao);
            tvCanNang = itemView.findViewById(R.id.tvCanNang);
            tvPhanTramMo = itemView.findViewById(R.id.tvPhanTramMo);
        }
    }
}
