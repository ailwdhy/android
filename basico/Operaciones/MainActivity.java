package com.example.main;

import android.os.Bundle;
import android.view.View; // Importar la clase View
import android.widget.Button; // Importar la clase Button
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editadito1, editadito2;
    Button botoncitos, botoncitor;
    Button botoncitom, botoncitod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editadito1 = findViewById(R.id.editado);
        editadito2 = findViewById(R.id.editado2);
        botoncitos = findViewById(R.id.bsuma);
        botoncitor = findViewById(R.id.bresta);
        botoncitom = findViewById(R.id.bmultiplica);
        botoncitod = findViewById(R.id.bdividir);

        botoncitos.setOnClickListener(this);
        botoncitor.setOnClickListener(this);
        botoncitom.setOnClickListener(this);
        botoncitod.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();
        Clasesita objetito = new Clasesita();
        try {
            int valor1 = Integer.parseInt(editadito1.getText().toString());
            int valor2 = Integer.parseInt(editadito2.getText().toString());
            objetito.setDatito1(valor1);
            objetito.setDatito2(valor2);

            if (cadenita.equals("suma")) {
                Toast.makeText(this, "resultado suma " + objetito.sumita(), Toast.LENGTH_LONG).show();
            } else if (cadenita.equals("resta")) {
                Toast.makeText(this, "resultado resta " + objetito.restita(), Toast.LENGTH_LONG).show();
            } else if (cadenita.equals("multiplica")) {
                Toast.makeText(this, "resultado multiplicación " + objetito.multiplicadita(), Toast.LENGTH_LONG).show();
            } else if (cadenita.equals("dividir")) {
                Toast.makeText(this, "resultado división " + objetito.divisioncita(), Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "error:" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}