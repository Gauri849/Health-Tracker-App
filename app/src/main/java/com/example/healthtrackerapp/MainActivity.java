package com.example.healthtrackerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.bottom_nav);
        loadFragment(new HomeFragment());

        nav.setOnItemSelectedListener(item -> {
            Fragment selected = null;

            int id = item.getItemId();
            if (id==R.id.nav_home){
                selected = new HomeFragment();
            } else if (id==R.id.nav_log) {
                selected = new LogFragment();
            } else if (id==R.id.nav_profile) {
                selected = new ProfileFragment();
            }
            if (selected!=null){
                loadFragment(selected);
                return true;
            }
            return false;

        });

    }
    private void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}