package com.example.pertemuan4.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pertemuan4.EditActivity;
import com.example.pertemuan4.MainActivity;
import com.example.pertemuan4.R;

import java.util.Objects;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    TextView tvUsername, tvEmail, tvPhone;
    Button btnEdit, btnLogout;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvUsername = view.findViewById(R.id.tv_username);
        tvEmail = view.findViewById(R.id.tv_email);
        tvPhone = view.findViewById(R.id.tv_phone);

        btnEdit = view.findViewById(R.id.btn_edit);
        btnLogout = view.findViewById(R.id.btn_logout);

        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        retrieveData();

        btnEdit.setOnClickListener(this);
        btnLogout.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveData();
    }

    @SuppressLint("SetTextI18n")
    private void retrieveData(){
        String sUsername = sharedPreferences.getString(KEY_USERNAME,null);
        String sEmail = sharedPreferences.getString(KEY_EMAIL,null);
        String sPhone = sharedPreferences.getString(KEY_PHONE,null);

        tvUsername.setText(sUsername);
        tvEmail.setText(": " + sEmail);
        tvPhone.setText(": " + sPhone);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_edit:
                intent = new Intent(getContext(), EditActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_logout:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                intent = new Intent(getContext(), MainActivity.class);
                Objects.requireNonNull(getActivity()).finish();
                Objects.requireNonNull(getContext()).startActivity(intent);
                break;
        }
    }
}