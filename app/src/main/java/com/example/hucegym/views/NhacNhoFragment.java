package com.example.hucegym.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.viewmodel.NhacNhoViewModel;

public class NhacNhoFragment extends Fragment {

    private NhacNhoViewModel nhacNhoViewModel;

    public NhacNhoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_nhac_nho, container, false);

        nhacNhoViewModel = new ViewModelProvider(this).get(NhacNhoViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        NhacNhoAdapter adapter = new NhacNhoAdapter(nhacNhoViewModel.getDanhSachNhacNho());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}

