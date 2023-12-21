package com.example.hucegym.views;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.widget.Toast;

import com.example.hucegym.R;
import com.example.hucegym.adapter.ExercisesAdapter;
import com.example.hucegym.connect.ApiServiceExercises;
import com.example.hucegym.model.Exercises;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExercisesActivity extends AppCompatActivity {
    private RecyclerView rcvExercises;
    private List<Exercises> mListExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        rcvExercises = findViewById(R.id.rcv_Exercises);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvExercises.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvExercises.addItemDecoration(itemDecoration);
        callApiGetExerciese();

    }

    private void callApiGetExerciese(){
        ApiServiceExercises.apiServiceExercises.getListUsers().enqueue(new Callback<List<Exercises>>() {
            @Override
            public void onResponse(Call<List<Exercises>> call, Response<List<Exercises>> response) {
                mListExercises = new ArrayList<>();
                mListExercises = response.body();

                ExercisesAdapter exercisesAdapter = new ExercisesAdapter(ExercisesActivity.this,mListExercises);
                rcvExercises.setAdapter(exercisesAdapter);
            }

            @Override
            public void onFailure(Call<List<Exercises>> call, Throwable t) {
                Toast.makeText(ExercisesActivity.this,"onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }


}