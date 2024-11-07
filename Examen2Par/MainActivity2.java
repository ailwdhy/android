package com.example.examen2par;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    EditText dato1, dato2;
    Clase clase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

            dato1 = findViewById(R.id.dato1);
            dato2 = findViewById(R.id.dato2);

            clase = new Clase();

            Button bvolver = findViewById(R.id.volver);
            bvolver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menusito, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            String value1String = dato1.getText().toString();
            String value2String = dato2.getText().toString();

            if (value1String.isEmpty() || value2String.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa ambos valores.", Toast.LENGTH_SHORT).show();
                return false;
            }

            int value1 = Integer.parseInt(value1String);
            int value2 = Integer.parseInt(value2String);
            String resultado = "";

            if (item.getItemId() == R.id.sumar || item.getItemId() == R.id.suma) {
                resultado = "Resultado de la suma: " + clase.suma(value1, value2);
            } else if (item.getItemId() == R.id.restar || item.getItemId() == R.id.restita) {
                resultado = "Resultado de la resta: " + clase.resta(value1, value2);
            } else if (item.getItemId() == R.id.multiplicacion || item.getItemId() == R.id.multplicacion1) {
                resultado = "Resultado de la multiplicación: " + clase.multiplicacion(value1, value2);
            } else if (item.getItemId() == R.id.division || item.getItemId() == R.id.division1) {
                if (value2 == 0) {
                    resultado = "Error: No se puede dividir por cero.";
                } else {
                    resultado = "Resultado de la división: " + clase.division(value1, value2);
                }
            }

            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
            return true;
        }
    }