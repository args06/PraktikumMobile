package com.example.coronajabar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.coronajabar.fragment.CaseFragment;
import com.example.coronajabar.fragment.RSFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new CaseFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.kasus_menu:
                loadFragment(new CaseFragment());
                break;

            case R.id.faskes_menu:
                loadFragment(new RSFragment());
                break;
        }
        return true;
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container,selectedFragment)
                    .commit();
            return true;
        }
        else
        {
            return false;
        }

    }
}