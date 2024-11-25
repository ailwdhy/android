package com.example.examen2par;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    Button boton;
    EditText vista;
    TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        vista = findViewById(R.id.texto);
        editText = findViewById(R.id.resultado);
        boton = findViewById(R.id.boton);
        boton.setOnClickListener(this);

        Button bvolver = findViewById(R.id.volver);
        bvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        String cadena = boton.getText().toString();
        Clase operar = new Clase();
        operar.setDato(Integer.parseInt(vista.getText().toString()));

        if (cadena.equals("doble")) {
            boton.setText("triple");
            editText.setText("El doble es: " + operar.doble());
        } else if (cadena.equals("triple")) {
            boton.setText("cuadruple");
            editText.setText("El triple es: " + operar.triple());
        } else if (cadena.equals("cuadruple")) {
            boton.setText("doble");
            editText.setText("El cuadruple es: " + operar.cuadruple());
        }
    }
}
