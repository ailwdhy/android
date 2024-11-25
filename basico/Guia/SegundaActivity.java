package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {

    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda); // Enlazar con el layout activity_segunda.xml

        // Inicializar el botón
        btnRegresar = findViewById(R.id.btnRegresar);

        // Asignar listener para regresar a la primera pantalla
        btnRegresar.setOnClickListener(v -> {
            Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finalizar la segunda actividad
        });
    }
}
