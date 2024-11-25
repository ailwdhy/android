package com.example.saludo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button botoncito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        botoncito = findViewById(R.id.boton);
        botoncito.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();
        Saludos saludos = new Saludos();
        if (cadenita.equals("Saludo")){
            Toast.makeText(this,saludos.saludito1(),
                    Toast.LENGTH_LONG).show();
            botoncito.setText("otro saludo");
        }
        else
        if (cadenita.equals("otro saludo")){
            Toast.makeText(this,saludos.saludito2(),
                    Toast.LENGTH_LONG).show();
            botoncito.setText("salud");

        }

    }
}