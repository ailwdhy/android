package com.example.chill_de_cojones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class AboutFragment extends Fragment implements View.OnClickListener {

    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,container,false);
        button = view.findViewById(R.id.botonabout);

        button.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Estas en about", Toast.LENGTH_SHORT).show();
    }
}