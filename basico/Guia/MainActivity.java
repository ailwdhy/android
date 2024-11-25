package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    // Declarar los elementos de UI
    EditText edit1, edit2;
    Button btnCalcular, btnSegundaPantalla;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Enlazar con el layout activity_main.xml

        // Inicializar los elementos de UI
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnSegundaPantalla = findViewById(R.id.btnSegundaPantalla);
        spinner = findViewById(R.id.spinner);

        // Array de opciones para el Spinner
        String[] opciones = {"Seleccione", "Cuadrado", "Rectángulo", "Triángulo"};

        // Configurar ArrayAdapter para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // Asignar listeners a los botones
        btnCalcular.setOnClickListener(this);
        btnSegundaPantalla.setOnClickListener(v -> {
            // Navegar a la segunda pantalla
            Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Habilitar o inhabilitar los campos de texto según la opción seleccionada
        String seleccion = parent.getItemAtPosition(position).toString();

        if (seleccion.equals("Cuadrado")) {
            edit1.setEnabled(true);
            edit2.setEnabled(false);
            btnCalcular.setEnabled(true);
        } else if (seleccion.equals("Rectángulo") || seleccion.equals("Triángulo")) {
            edit1.setEnabled(true);
            edit2.setEnabled(true);
            btnCalcular.setEnabled(true);
        } else {
            edit1.setEnabled(false);
            edit2.setEnabled(false);
            btnCalcular.setEnabled(false);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // No hacer nada si no se selecciona nada
    }

    @Override
    public void onClick(View v) {
        // Obtener el valor del Spinner
        String seleccion = spinner.getSelectedItem().toString();

        try {
            int valor1 = Integer.parseInt(edit1.getText().toString());
            int valor2 = edit2.isEnabled() ? Integer.parseInt(edit2.getText().toString()) : 0;
            
            double resultado = 0;
            if (seleccion.equals("Cuadrado")) {
                resultado = Math.pow(valor1, 2);
            } else if (seleccion.equals("Rectángulo")) {
                resultado = valor1 * valor2;
            } else if (seleccion.equals("Triángulo")) {
                resultado = (valor1 * valor2) / 2.0;
            }

            // Mostrar el resultado usando un Toast
            Toast.makeText(this, "Resultado: " + resultado, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese valores válidos", Toast.LENGTH_LONG).show();
        }
    }
}
