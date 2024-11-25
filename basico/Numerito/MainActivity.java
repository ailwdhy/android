package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText variable;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        variable = findViewById(R.id.variable);
        boton = findViewById(R.id.boton);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = variable.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "ingresa un número!", Toast.LENGTH_SHORT).show();
            return;
        }

        int number = Integer.parseInt(input);

        Numerito numero = new Numerito();
        numero.setNumero(number);

        Toast.makeText(this, "es: " + numero.convierteATexto(),
                Toast.LENGTH_LONG).show();
    }
}