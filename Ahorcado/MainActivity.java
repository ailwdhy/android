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

    // array palabras
    public String[] palabras = {"holiwis", "kekitas", "kikin"};
    // palabra seleccionada random
    public String seleccionadito;
    // palabra que despliega con letras adivinadas
    public String desplegado;
    // cuenta los intentos que has usado
    public int intentos;

    // imagenes segun los errores que hayas tenido
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

        // inicia el juego
        iniciadito();

        // el boton se da click cuando se pone una letra en el EditText textito
        botoncito.setOnClickListener(this);
    }

    private void iniciadito() {
        Random random = new Random(); // objeto Random para elegir palabra random
        // guarda la palabra random en seleccionadito con sintaxis de random
        seleccionadito = palabras[random.nextInt(palabras.length)];

        desplegado = "";

        // crea un for para guardar en desplegado para poner un _ segun la longitud de la palabra seleccionada
        for (int i = 0; i < seleccionadito.length(); i++) {
            desplegado += "_";
        }

        palabrita.setText(desplegado); // muestra desplegado con puros guines bajo
        intentos = 0; // inicializa intentos
        imagenAhorcado.setImageResource(imagenesAhorcado[intentos]); // muestra imagencita prede
    }

    @Override
    public void onClick(View v) {
        // obtiene la letra ingresada por el usuario en minúscula
        String letra = textito.getText().toString().toLowerCase();
        textito.setText(""); // limpia el campo para que puedas poner otra letra

        // para el caso: solo una letra
        if (letra.length() == 1) {
            String nuevaPalabra = ""; // variable para la nueva palabra que se va a desplegar
            boolean letrita = false;  // para controlar si se suma un intento

            // va por cada letra seleccionada
            for (int i = 0; i < seleccionadito.length(); i++) {
                // si la letra puesta iguala a la letra de la palabra
                if (seleccionadito.substring(i, i + 1).equals(letra)) {
                    nuevaPalabra += letra;  // agrega la letra al desplegado
                    letrita = true;  // el intento fue bueno :)
                } else {
                    // si la letra no iguala deja la letra que tenía anteriormente desplegado
                    nuevaPalabra += desplegado.substring(i, i + 1);
                }
            }

            // nuevaPalabra la despliega
            desplegado = nuevaPalabra;
            palabrita.setText(desplegado); // imprime en pantalla el nuevo desplegado

            // si se completo la palabra correctamente
            if (desplegado.equals(seleccionadito)) {
                Toast.makeText(this, "ganaste!", Toast.LENGTH_SHORT).show(); // ganaste
                iniciadito(); // reiniciar el juego
            } else if (!letrita) {
                // si tuviste un error, se aumenta el valor de los intentos
                intentos++;

                // si tienes intentos aun
                if (intentos < imagenesAhorcado.length) {
                    imagenAhorcado.setImageResource(imagenesAhorcado[intentos]); // actualiza la nueva imagen de acuerdo a los intentos que tienes
                } else {
                    // si ya no tienes intentos, perdiste e inicia el juego de nuevo
                    Toast.makeText(this, "perdiste :(", Toast.LENGTH_SHORT).show();
                    iniciadito();
                }
            }
        } else {
            // más de una letra
            Toast.makeText(this, "pon solo una letra", Toast.LENGTH_SHORT).show();
        }
    }
}