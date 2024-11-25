package com.example.nuevito;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner combito;
    ArrayAdapter<Clasesita> adaptadorcito;
    Arraysito Akekitas;
    ArrayList<Clasesita> Aregreso = new ArrayList<>();
    TextView vistita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        vistita = findViewById(R.id.vista);
        Akekitas = new Arraysito();
        Aregreso = Akekitas.regresa();

        combito = findViewById(R.id.combo);
        combito.setOnItemSelectedListener(this);

        adaptadorcito = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Aregreso);
        combito.setAdapter(adaptadorcito);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        float datito = (float)1;
        Clasesita objetito = new Clasesita();
        String cadenita = "";
        if (position > 0) {
            objetito = (Clasesita) combito.getSelectedItem();
            cadenita = "clave: " + objetito.getClave() + "\n" + "deque: " + objetito.toString() + "\n" + "costo: " + objetito.getCosto();
            vistita.setText(cadenita);
        } else if (position == 0) {
            vistita.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}