package com.example.pertemuan4.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pertemuan4.DetailActivity;
import com.example.pertemuan4.R;
import com.example.pertemuan4.model.Movies;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private ArrayList<Movies> movie;
    private Context context;

    public MovieAdapter(ArrayList<Movies> movie, Context context) {
        this.movie = movie;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movies_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(movie.get(position));
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;
        ImageView ivPhoto;
        CardView cvCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_name);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            tvDescription = itemView.findViewById(R.id.tv_detail);
            cvCardView = itemView.findViewById(R.id.cv_cardview);
        }

        public void bind(Movies movie){
            tvTitle.setText(movie.getsName());
            tvDescription.setText(movie.getsDetail());
            Glide.with(itemView.getContext())
                    .load(movie.getsImage())
                    .apply(new RequestOptions().override(40,60))
                    .into(ivPhoto);
            cvCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_DATA, movie);
                    context.startActivity(intent);
                }
            });
        }
    }
}