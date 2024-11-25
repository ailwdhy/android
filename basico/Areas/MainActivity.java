package com.example.uwu;

import android.os.Bundle;
import android.view.View; // Importar la clase View
import android.widget.Button; // Importar la clase Button
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editadito1, editadito2;
    Button botoncitor, botoncitoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editadito1 = findViewById(R.id.editado);
        editadito2 = findViewById(R.id.editado2);

        botoncitor = findViewById(R.id.brectangulo);
        botoncitoc = findViewById(R.id.bcuadrado);

        botoncitor.setOnClickListener(this);
        botoncitoc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();

        if (cadenita.equals("cuadrado")) {
            Clasesita objetito = new Clasesita(Integer.parseInt(editadito1.getText().toString()));
            Toast.makeText(this, "area cuadrado " + objetito.areac(), Toast.LENGTH_LONG).show();
        }
        else
            if (cadenita.equals("rectangulo")) {
            Clasesita objetito = new Clasesita(Integer.parseInt(editadito1.getText().toString()), (Integer.parseInt(editadito2.getText().toString())));
            Toast.makeText(this, "area rectangulo " + objetito.arear(), Toast.LENGTH_LONG).show();
            }
    }
}