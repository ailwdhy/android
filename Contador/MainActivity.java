package com.example.numerillos;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener, View.OnClickListener {

    private EditText numerito;
    private TextView textito;
    private Button boton;
    private CountDownTimer countDownTimer;
    Numero numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        numerito = findViewById(R.id.numerito);
        textito = findViewById(R.id.textito);
        boton = findViewById(R.id.boton);

        numero = new Numero();

        boton.setOnClickListener(this);
        numerito.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        // verificamos si la tecla fue soltada
        if (event.getAction() == KeyEvent.ACTION_UP) {
            String inputText = numerito.getText().toString();
            // try catch para validar el numerito
            try {
                int inputNumber = Integer.parseInt(inputText);
                // verificamos si el numero esta en el rango permitido
                if (inputNumber >= 0 && inputNumber < 1000000) {
                    String textoEnPalabras = numero.convertirMiles(inputNumber);
                    textito.setText(textoEnPalabras);
                } else {
                    textito.setText("tu numerito es incorrecto");
                }
            } catch (NumberFormatException e) {
                textito.setText("pon un numerito");
            }
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        // obtenemos el texto del edittext
        String inputText = numerito.getText().toString();
        // convertimos el texto a numero entero
        int inputNumber = Integer.parseInt(inputText);
        // creamos un nuevo timer
        countDownTimer = new CountDownTimer(99000, 1000) {
            // inicializamos x con el numero ingresado
            int x = inputNumber;

            @Override
            public void onTick(long millisUntilFinished) {
                // actualizamos el edittext con el valor de x
                numerito.setText(String.valueOf(x));
                // convertimos el numero a palabras
                String textoEnPalabras = numero.convertirMiles(x);
                // actualizamos el textview con el texto en palabras
                textito.setText(textoEnPalabras);
                // decrementamos x para que el numerito vaya disminuyendo
                x--;
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

}