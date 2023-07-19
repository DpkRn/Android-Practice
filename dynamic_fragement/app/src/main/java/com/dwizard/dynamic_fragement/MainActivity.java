package com.dwizard.dynamic_fragement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
Button btnA,btnB,btnC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnA=findViewById(R.id.btnA);
        btnB=findViewById(R.id.btnB);
        btnC=findViewById(R.id.btnC);
       loadPage(new FragmentA(),0);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadPage(new FragmentA(),0);

            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPage(new FragmentB(),1);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPage(new FragmentC(),1);
            }
        });
    }
    void loadPage(Fragment fragment,int flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if(flag==0) {
            ft.add(R.id.container, fragment);
           //ft.addToBackStack(null);
            //below line pop back all the stack after upto root_null
            //benifit of that how many taps will be at another item if we are at home page and when pressed back button it will exit the 
            fm.popBackStack("root_null",FragmentManager.POP_BACK_STACK_INCLUSIVE);
             ft.addToBackStack("root_null");
        }
        else {
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }
}