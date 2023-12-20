package com.example.hucegym.viewmodel;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;

import com.example.hucegym.connect.ApiServiceExercises;
import com.example.hucegym.model.Exercises;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ExercisesViewModel {
    public ExercisesViewModel() {
        callApiExercises();
    }

    private Disposable mDisposable;
    private ObservableArrayList<Exercises> list = new ObservableArrayList<>();
    private ObservableBoolean isSuccess = new ObservableBoolean();
    public void callApiExercises() {
        ApiServiceExercises.apiServiceExercises.callApiExercises()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Exercises>>() {
            @Override
                    public void onSubscribe (Disposable d) {
                        mDisposable = d;

                    }
            @Override
                    public void onNext(@NonNull List<Exercises> exercises){
                list.addAll(exercises);
            }
            @Override
                    public void onError(@NonNull Throwable e){
                isSuccess.set(false);
            }
            @Override
                    public void onComplete(){
                isSuccess.set(true);
            }
        });
    }

    public Disposable getDisposable() {
        return mDisposable;
    }

    public void setDisposable(Disposable mDisposable) {
        this.mDisposable = mDisposable;
    }

    public ObservableArrayList<Exercises> getList() {
        return list;
    }

    public void setList(ObservableArrayList<Exercises> list) {
        this.list = list;
    }

    public ObservableBoolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(ObservableBoolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
