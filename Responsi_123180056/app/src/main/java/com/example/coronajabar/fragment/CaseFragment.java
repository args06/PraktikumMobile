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
import com.example.coronajabar.model.kasus.ContentItem;
import com.example.coronajabar.service.CovidListener;
import com.example.coronajabar.service.CovidService;

import java.util.Collections;
import java.util.List;

public class CaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_case, container, false);
    }

    RecyclerView rvRecyclerView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvRecyclerView = view.findViewById(R.id.rv_case);
        new CovidService().getKasus(covidListener);
    }

    CovidListener<List<ContentItem>> covidListener = new CovidListener<List<ContentItem>>() {

        @Override
        public void onSuccess(List<ContentItem> items) {

            Collections.reverse(items);

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvRecyclerView.setLayoutManager(linearLayoutManager);
            CaseAdapter rvAdapter = new CaseAdapter(items);
            rvRecyclerView.setAdapter(rvAdapter);

            for(int i = 0; i < items.size(); i++){
                Log.d("Hasilnya : ", String.valueOf(items.get(i).getCONFIRMATION()));
            }
        }

        @Override
        public void onFailed(String msg) {
            Log.d("Errornya : ", msg);
        }
    };
}