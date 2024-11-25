package com.example.aplic;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText editadito;
    EditText editadito2;

    Button botoncito;
    Spinner combito;
    ArrayAdapter adaptadito;
    String cadenitas [] = {"Selecciona opción","cuadrado","rectangulo","triangulo"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editadito = findViewById(R.id.edit1);
        editadito2 = findViewById(R.id.edit2);

        combito = findViewById(R.id.combo);
        combito.setOnItemSelectedListener(this);

        botoncito = findViewById(R.id.boton);
        botoncito.setOnClickListener(this);

        adaptadito = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,cadenitas);

        combito.setAdapter(adaptadito);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cadenita = parent.getItemAtPosition(position).toString();
        if (cadenita.equals("cuadrado"))
            editadito.setEnabled(true);

        else
            if (cadenita.equals("rectangulo") || (cadenita.equals("triangulo"))){
                editadito.setEnabled(true);
                editadito2.setEnabled(true);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        String cadenita = combito.getSelectedItem().toString();
        if (cadenita.equals("cuadrado")){
            Clasesita objetito = new Clasesita();
            objetito.setDatito1(Integer.parseInt(editadito.getText().toString()));
            Toast.makeText(this,"area cuadrado"+objetito.cuadradito(),
                    Toast.LENGTH_LONG).show();
        }
        else
            if (cadenita.equals("rectangulo") || cadenita.equals("triangulo")) {
                Clasesita objetito = new Clasesita();
                objetito.setDatito1(Integer.parseInt(editadito.getText().toString()));
                objetito.setDatito2(Integer.parseInt(editadito2.getText().toString()));
                if (cadenita.equals("triangulo"))
                    Toast.makeText(this, "area tri" + objetito.triangulo(),
                            Toast.LENGTH_LONG).show();
                else
                    if (cadenita.equals("rectangulo"))
                        Toast.makeText(this, "area rec" + objetito.rectangulito(),
                                Toast.LENGTH_LONG).show();
        }
    }
}