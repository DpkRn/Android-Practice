package com.dwizard.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class fragmentA extends Fragment {


    public fragmentA() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView txtA;
        View view= inflater.inflate(R.layout.fragment_a, container, false);
        txtA=view.findViewById(R.id.txtA);
        Button btn=view.findViewById(R.id.btnA);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Fragment A button", Toast.LENGTH_SHORT).show();
            }
        });
    return view;
    }
}