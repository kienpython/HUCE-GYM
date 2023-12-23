package com.example.hucegym.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hucegym.connect.ApiServiceNhacNho;
import com.example.hucegym.model.NhacNho;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NhacNhoViewModel extends ViewModel {
    private MutableLiveData<List<NhacNho>> listNhacNho = new MutableLiveData<>();
    private ApiServiceNhacNho apiServiceNhacNho;

    public NhacNhoViewModel() {
        apiServiceNhacNho = new ApiServiceNhacNho() {
            @Override
            public Call<List<NhacNho>> getListNhacNho() {
                return null;
            }
        };
        loadNhacNhoList();
    }

    public LiveData<List<NhacNho>> getListNhacNho() {
        return listNhacNho;
    }

    private void loadNhacNhoList() {
        apiServiceNhacNho.getListNhacNho().enqueue(new Callback<List<NhacNho>>() {
            @Override
            public void onResponse(Call<List<NhacNho>> call, Response<List<NhacNho>> response) {
                if (response.isSuccessful()) {
                    listNhacNho.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<NhacNho>> call, Throwable t) {
                // Xử lý lỗi nếu có
            }
        });
    }
}



