package com.example.substrings;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textito;
    Button botoncito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textito = findViewById(R.id.texto);
        botoncito = findViewById(R.id.boton);
        botoncito.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String cadenita = textito.getText().toString();
        Toast.makeText(this, cadenita.substring(0, 2), Toast.LENGTH_LONG).show();
    }
}