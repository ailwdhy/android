package com.example.chill_de_cojones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HomeFragment extends Fragment implements View.OnClickListener {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        button = view.findViewById(R.id.botoncacha);

        button.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Estas en cacha", Toast.LENGTH_SHORT).show();
    }
}