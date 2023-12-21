package com.example.hucegym.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import java.util.List;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExercisesViewHolder>{
    private final List<Exercises> mListExercises;
    private final Context mContext;

    public ExercisesAdapter(Context context,List<Exercises> mListExercises) {
        this.mListExercises = mListExercises;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ExercisesAdapter.ExercisesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercises,parent,false);
        return new ExercisesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesViewHolder holder, int position) {
        final Exercises exercises = mListExercises.get(position);
        if (exercises == null){
            return;
        }
        switch (position){
            case 0:
                holder.img_exercises.setImageResource(R.drawable.gap_bung);
                break;
            case 1:
                holder.img_exercises.setImageResource(R.drawable.len_xa);
                break;
            case 2:
                holder.img_exercises.setImageResource(R.drawable.chay);
                break;
            case 3:
                holder.img_exercises.setImageResource(R.drawable.nham_dinh);
                break;
            case 4:
                holder.img_exercises.setImageResource(R.drawable.cay_view);
                break;
        }
        holder.tvTieuDe.setText(exercises.getTieu_de_bt());
        holder.tvGhiChu.setText(exercises.getGhi_chu_bt());
        holder.tvTypesRoom.setText(exercises.getTypes_room());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOpenYoutube(exercises.getVideo_bt());
            }
        });
    }

//    mở youtube
    private void onClickOpenYoutube(String videoId){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + videoId));
        intent.putExtra("VIDEO_ID", videoId);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (mListExercises != null) {
            return mListExercises.size();
        }
        return 0;
    }

    public static class ExercisesViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTieuDe;
        private final TextView tvGhiChu;
        private final TextView tvTypesRoom;
        private ImageView img_exercises;
        private LinearLayout layout;

        public ExercisesViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_item);
            tvTieuDe = itemView.findViewById(R.id.tvTieuDe);
            tvGhiChu = itemView.findViewById(R.id.tvGhiChu);
            tvTypesRoom = itemView.findViewById(R.id.tvTypesRoom);
            img_exercises = itemView.findViewById(R.id.img_exercises);
        }
    }
}
