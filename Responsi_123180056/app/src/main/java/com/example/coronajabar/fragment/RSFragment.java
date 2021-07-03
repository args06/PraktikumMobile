package com.example.coronajabar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coronajabar.R;
import com.example.coronajabar.adapter.CaseAdapter;
import com.example.coronajabar.adapter.FaskesAdapter;
import com.example.coronajabar.model.faskes.DataItem;
import com.example.coronajabar.model.kasus.ContentItem;
import com.example.coronajabar.service.CovidListener;
import com.example.coronajabar.service.CovidService;

import java.util.Collections;
import java.util.List;

public class RSFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_r_s, container, false);
    }

    RecyclerView rvRecyclerView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvRecyclerView = view.findViewById(R.id.rv_rs);
        new CovidService().getFaskes(covidListener);
    }

    CovidListener<List<DataItem>> covidListener = new CovidListener<List<DataItem>>() {

        @Override
        public void onSuccess(List<DataItem> items) {

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvRecyclerView.setLayoutManager(linearLayoutManager);
            FaskesAdapter rvAdapter = new FaskesAdapter(items);
            rvRecyclerView.setAdapter(rvAdapter);

            for(int i = 0; i < items.size(); i++){
                Log.d("Hasilnya : ", String.valueOf(items.get(i).getNama()));
            }
        }

        @Override
        public void onFailed(String msg) {
            Log.d("Errornya : ", msg);
        }
    };
}