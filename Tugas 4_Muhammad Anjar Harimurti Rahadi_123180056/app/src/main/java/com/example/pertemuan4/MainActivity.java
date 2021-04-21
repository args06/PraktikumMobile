package com.example.pertemuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etUsername, etPassword;
    Button btnSignin;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnSignin = findViewById(R.id.btn_signin);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String sUsername = sharedPreferences.getString(KEY_USERNAME, null);

        if (sUsername != null){
            Intent intent = new Intent(getApplicationContext(), ContentActivity.class);
            startActivity(intent);
            finish();
        }

        btnSignin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin:
                if (TextUtils.isEmpty(etUsername.getText())){
                    etUsername.setError( "Username is required!" );
                }

                if (TextUtils.isEmpty(etPassword.getText())){
                    etPassword.setError( "Password is required!" );
                }

                if(!TextUtils.isEmpty(etUsername.getText()) && !TextUtils.isEmpty(etPassword.getText())){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_USERNAME,etUsername.getText().toString());
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), ContentActivity.class);
                    startActivity(intent);
                    finish();
                }
        }
    }
}