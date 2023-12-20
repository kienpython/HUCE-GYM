package com.example.hucegym.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.databinding.ItemExercisesBinding;
import com.example.hucegym.model.Exercises;

import java.util.List;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExercisesViewHolder>{
    private final List<Exercises> mListExercises;

    public ExercisesAdapter(List<Exercises> mListExercises) {
        this.mListExercises = mListExercises;
    }

    @NonNull
    @Override
    public ExercisesAdapter.ExercisesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemExercisesBinding itemExercisesBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_exercises, parent, false);
        return new ExercisesViewHolder(itemExercisesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesViewHolder holder, int position) {
        Exercises exercises = mListExercises.get(position);
        holder.itemExercisesBinding.setItemExercisesViewModel(exercises);
    }

    @Override
    public int getItemCount() {
        if (mListExercises != null) {
            return mListExercises.size();
        }
        return 0;
    }

    public static class ExercisesViewHolder extends RecyclerView.ViewHolder {

        private final ItemExercisesBinding itemExercisesBinding;

        public ExercisesViewHolder(@NonNull ItemExercisesBinding itemExercisesBinding) {
            super(itemExercisesBinding.getRoot());
            this.itemExercisesBinding = itemExercisesBinding;
        }
    }
}
