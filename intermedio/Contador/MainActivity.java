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
        if (event.getAction() == KeyEvent.ACTION_UP) {
            String inputText = numerito.getText().toString();
            try {
                int inputNumber = Integer.parseInt(inputText);
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
        String inputText = numerito.getText().toString();
        int inputNumber = Integer.parseInt(inputText);
        countDownTimer = new CountDownTimer(99000, 1000) {
            int x = inputNumber;

            @Override
            public void onTick(long millisUntilFinished) {
                numerito.setText(String.valueOf(x));
                String textoEnPalabras = numero.convertirMiles(x);
                textito.setText(textoEnPalabras);
                x--;
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

}