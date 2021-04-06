package com.example.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_DATA = "EXTRA_DATA";
    private Movies movie;

    ImageView ivBack, ivImage;
    TextView tvTitle, tvDirector, tvRelease, tvRuntime, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivBack = findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_title);
        tvDirector = findViewById(R.id.tv_director);
        tvRelease = findViewById(R.id.tv_release);
        tvRuntime = findViewById(R.id.tv_runtime);
        tvDescription = findViewById(R.id.tv_description);
        ivImage = findViewById(R.id.iv_images);

        movie = getIntent().getParcelableExtra(EXTRA_DATA);

        Glide.with(this)
                .load(movie.getsImage())
                .apply(new RequestOptions().override(160,240))
                .into(ivImage);
        tvTitle.setText(movie.getsName());
        tvDirector.setText(movie.getsDirector());
        tvRelease.setText(movie.getsReleaseDate());
        tvRuntime.setText(movie.getsRunningTime());
        tvDescription.setText(movie.getsDetail());


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}