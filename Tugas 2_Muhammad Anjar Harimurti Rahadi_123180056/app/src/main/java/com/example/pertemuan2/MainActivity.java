package com.example.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etAngka1, etAngka2;
    TextView tvResult;
    Button btnTambah, btnKurang, btnKali, btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAngka1 = findViewById(R.id.et_angka_satu);
        etAngka2 = findViewById(R.id.et_angka_dua);
        tvResult = findViewById(R.id.tv_result);
        btnTambah = findViewById(R.id.btn_tambah);
        btnKurang = findViewById(R.id.btn_kurang);
        btnKali = findViewById(R.id.btn_kali);
        btnBagi = findViewById(R.id.btn_bagi);

        btnTambah.setOnClickListener(this);
        btnKurang.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btnBagi.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        double dAngka1 = Double.parseDouble(etAngka1.getText().toString());
        double dAngka2 = Double.parseDouble(etAngka2.getText().toString());

        String sHasil = "0";
        switch (v.getId()) {
            case R.id.btn_tambah:
                sHasil = String.valueOf(dAngka1 + dAngka2);
                break;
            case R.id.btn_kurang:
                sHasil = String.valueOf(dAngka1 - dAngka2);
                break;
            case R.id.btn_kali:
                sHasil = String.valueOf(dAngka1 * dAngka2);
                break;
            case R.id.btn_bagi:
                sHasil = String.valueOf(dAngka1 / dAngka2);
                break;
        }
        tvResult.setText(sHasil);
    }
}