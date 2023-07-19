package com.dwizard.bottomnevigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
   BottomNavigationView bnView;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView=findViewById(R.id.bnView);

       loadPage(new frag_Home(),true);
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                if(id==R.id.nav_home){
                    Toast.makeText(MainActivity.this, "item", Toast.LENGTH_SHORT).show();
                    loadPage(new frag_Home(),false);
                }
                else if(id==R.id.nav_search)
                    loadPage(new frag_search(),false);
                else if(id==R.id.nav_upload)
                    loadPage(new frag_upload(),false);
                else if(id==R.id.nav_reels)
                    loadPage(new frag_reels(),false);
                else loadPage(new frag_profile(),false);
                return true;
            }
        });
    }
    void loadPage(Fragment fragment,boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag)
        ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container, fragment);

            ft.commit();
    }
}