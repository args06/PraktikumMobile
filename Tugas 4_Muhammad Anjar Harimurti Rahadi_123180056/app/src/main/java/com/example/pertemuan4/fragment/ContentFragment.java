package com.example.pertemuan4.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pertemuan4.R;
import com.example.pertemuan4.adapter.MovieAdapter;
import com.example.pertemuan4.model.Movies;
import com.example.pertemuan4.model.MoviesData;

import java.util.ArrayList;

public class ContentFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    private RecyclerView recyclerView;
    private ArrayList<Movies> movie = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        recyclerView = view.findViewById(R.id.rv_recycler_view);
        recyclerView.setHasFixedSize(true);

        movie.addAll(MoviesData.getListData());
        showRecyclerView();

    }

    private void showRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter listMovieAdapter = new MovieAdapter(movie,getContext());
        recyclerView.setAdapter(listMovieAdapter);
    }
}