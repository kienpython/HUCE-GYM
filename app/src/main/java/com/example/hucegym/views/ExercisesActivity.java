package com.example.hucegym.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.hucegym.R;
import com.example.hucegym.adapter.ExercisesAdapter;
import com.example.hucegym.databinding.ActivityExercisesBinding;
import com.example.hucegym.model.Exercises;
import com.example.hucegym.viewmodel.ExercisesViewModel;

import java.util.List;


public class ExercisesActivity extends AppCompatActivity {
    private List<Exercises> mListExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        ActivityExercisesBinding activityExercisesBinding = DataBindingUtil.setContentView(this, R.layout.activity_exercises);
        ExercisesViewModel exercisesViewModel = new ExercisesViewModel();
        activityExercisesBinding.setExercisesViewModel(exercisesViewModel);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        activityExercisesBinding.rcvExercises.setLayoutManager(linearLayoutManager);
    }

    @BindingAdapter({"list_data", "is_success"})
    public static void loadListData(RecyclerView view, ObservableArrayList<Exercises> list, ObservableBoolean isSuccess) {
        if (isSuccess.get()) {
            Toast.makeText(view.getContext(), "Call api success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(view.getContext(), "Call api error", Toast.LENGTH_SHORT).show();
        }

        ExercisesAdapter exercisesAdapter = new ExercisesAdapter(list);
        view.setAdapter(exercisesAdapter);
    }


}