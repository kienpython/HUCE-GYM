package com.example.hucegym.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.model.Lop;
import com.example.hucegym.model.NhanVien;
import com.example.hucegym.views.DetailLopActivity;
import com.example.hucegym.views.LopActivity;

import java.io.Serializable;
import java.util.List;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.LopViewHolder>{
    private final List<Lop> mListLop;
    private final Context mContext;

    public LopAdapter(List<Lop> mListNhanVien, Context mContext) {
        this.mListLop = mListNhanVien;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lop_row_item,parent,false);
        return new LopAdapter.LopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LopViewHolder holder, int position) {
        final Lop lop = mListLop.get(position);
        if (lop == null){
            return;
        }
        holder.txt_id_lop.setText(String.valueOf(lop.getId_lop()));
        holder.txt_ten_nv1.setText(String.valueOf(lop.getName_nv()));
        holder.txt_types_room.setText(String.valueOf(lop.getTypes_room()));
        holder.txt_ten_lop.setText(String.valueOf(lop.getTen_lop()));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickWatchDetail(lop);
            }
        });
    }

    private void onClickWatchDetail(Lop lop){
        Intent intent = new Intent(mContext, DetailLopActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Lop", (Serializable) lop); // Sử dụng putParcelable nếu Lop implement Parcelable
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (mListLop != null) {
            return mListLop.size();
        }
        return 0;
    }

    public static class LopViewHolder extends RecyclerView.ViewHolder {

        private final TextView txt_id_lop;
        private final TextView txt_ten_nv1;
        private final TextView txt_types_room;
        private final TextView txt_ten_lop;
        private LinearLayout layout;

        public LopViewHolder(@NonNull View itemView){
            super(itemView);
            layout = itemView.findViewById(R.id.layout_item_lop);
            txt_id_lop = itemView.findViewById(R.id.txt_id_lop);
            txt_ten_nv1 = itemView.findViewById(R.id.txt_ten_nv1);
            txt_types_room = itemView.findViewById(R.id.txt_types_room);
            txt_ten_lop = itemView.findViewById(R.id.txt_ten_lop);
        }
    }
}
