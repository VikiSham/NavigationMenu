package com.example.navigationmenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class NaviMenu extends AppCompatActivity {

    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    protected FrameLayout mainContent;
    protected MaterialToolbar toolbar;


    // Method to set content view with menu layout
    protected void setContentViewWithMenu(@LayoutRes int layoutResID) {
        setContentView(R.layout.menu_layout);

        drawerLayout = findViewById(R.id.drawerLayout);

        // Set up the MaterialToolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Set the main content view
        mainContent = findViewById(R.id.mainContent);
        getLayoutInflater().inflate(layoutResID, mainContent, true);

        // Set up the navigation drawer
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if(id == R.id.activity1) {
                Intent go = new Intent(this, MainActivity.class);
                startActivity(go);
            }
            if(id == R.id.activity2) {
                Intent go = new Intent(this, MainActivity2.class);
                startActivity(go);
            }
            if(id == R.id.activity3) {
                Intent go = new Intent(this, MainActivity3.class);
                startActivity(go);
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
}
