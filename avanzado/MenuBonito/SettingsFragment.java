package com.example.chill_de_cojones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class SettingsFragment extends Fragment implements View.OnClickListener {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings,container,false);
        button = view.findViewById(R.id.botonajustes);

        button.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Estas en settings", Toast.LENGTH_SHORT).show();
    }
}