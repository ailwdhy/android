package com.example.ahorcadito;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView palabrita;
    public EditText textito;
    public Button botoncito;
    public ImageView imagenAhorcado;

    public String[] palabras = {"holiwis", "kekitas", "kikin"};
    public String seleccionadito;
    public String desplegado;
    public int intentos;

    public int[] imagenesAhorcado = {
            R.drawable.prede,
            R.drawable.error1,
            R.drawable.error2,
            R.drawable.error3,
            R.drawable.error4,
            R.drawable.error5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palabrita = findViewById(R.id.palabra);
        textito = findViewById(R.id.texto);
        botoncito = findViewById(R.id.boton);
        imagenAhorcado = findViewById(R.id.imagenAhorcado);

        iniciadito();

        botoncito.setOnClickListener(this);
    }

    private void iniciadito() {
        Random random = new Random();
        seleccionadito = palabras[random.nextInt(palabras.length)];

        desplegado = "";

        for (int i = 0; i < seleccionadito.length(); i++) {
            desplegado += "_";
        }

        palabrita.setText(desplegado); 
        intentos = 0; 
        imagenAhorcado.setImageResource(imagenesAhorcado[intentos]); 
    }

    @Override
    public void onClick(View v) {
        String letra = textito.getText().toString().toLowerCase();
        textito.setText("");

        if (letra.length() == 1) {
            String nuevaPalabra = ""; 
            boolean letrita = false;  

            for (int i = 0; i < seleccionadito.length(); i++) {
                if (seleccionadito.substring(i, i + 1).equals(letra)) {
                    nuevaPalabra += letra;  
                    letrita = true; 
                } else {
                    nuevaPalabra += desplegado.substring(i, i + 1);
                }
            }

            desplegado = nuevaPalabra;
            palabrita.setText(desplegado);

            if (desplegado.equals(seleccionadito)) {
                Toast.makeText(this, "ganaste!", Toast.LENGTH_SHORT).show();
                iniciadito(); 
            } else if (!letrita) {
                intentos++;

                if (intentos < imagenesAhorcado.length) {
                    imagenAhorcado.setImageResource(imagenesAhorcado[intentos]); 
                } else {
                    Toast.makeText(this, "perdiste :(", Toast.LENGTH_SHORT).show();
                    iniciadito();
                }
            }
        } else {
            Toast.makeText(this, "pon solo una letra", Toast.LENGTH_SHORT).show();
        }
    }
}