package com.example.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class fragdatos extends Fragment implements View.OnClickListener {
EditText editadito;
Button botoncito;
TextView vistita;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view= inflater.inflate(R.layout.fragment_fragdatos,
                container, false);
     editadito=view.findViewById(R.id.texto);
     botoncito=view.findViewById(R.id.boton);
     botoncito.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        vistita=getActivity().findViewById(R.id.viresultado);
        String cadenita=((Button)v).getText().toString();
        operaciones operadito=new operaciones();
        operadito.setDatito(Integer.parseInt(editadito.getText().toString()));
        if(cadenita.equals("doble")){
            botoncito.setText("triple");
            vistita.setText("doble"+operadito.doble());
        }

    }
}