package com.example.puntito;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView vistita;
    CheckBox cgabachito, citalianito, cfrancesito;
    Button botoncito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //hola kikin yo tqm apruebanos gracias
        vistita = findViewById(R.id.vista);
        cgabachito = findViewById(R.id.checking);
        cfrancesito = findViewById(R.id.checkfra);
        citalianito = findViewById(R.id.checkita);

        botoncito =findViewById(R.id.desplegar);
        botoncito.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();
        String mensajito = "hablas";
        if (cadenita.equals("desplegado"));
        Clasesita objetito = new Clasesita();
        if (cgabachito.isChecked())
            mensajito = mensajito + " " + objetito.ingles();
        if (citalianito.isChecked())
            mensajito = mensajito + " " + objetito.italiano();
        if (cfrancesito.isChecked())
            mensajito = mensajito + " " +  objetito.frances();

        if (cgabachito.isChecked() == false && cfrancesito.isChecked() == false && citalianito.isChecked() == false)
            mensajito = objetito.nada();

        vistita.setText(mensajito);

    }
}