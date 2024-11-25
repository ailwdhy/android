package com.example.spinnerdinamico;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textito1, textito2;
    Spinner spinner1, spinner2;
    String [] op1 = {"seleccionar", "kekitas", "sopecitos", "huaraches"};
    String [] op2 = {"seleccionar", "papa", "queso", "picadillo"};
    String [] op3 = {"seleccionar", "queso", "frijoles", "carne"};
    String [] op4 = {"seleccionar", "salsa", "choriqueso", "salchicha"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textito1 = findViewById(R.id.text1);
        textito2 = findViewById(R.id.text2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, op1);
        spinner1.setAdapter(adapter1);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.spinner1) {
            if (i == 1) {
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, op2);
                spinner2.setAdapter(adapter2);
            } else if (i == 2) {
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, op3);
                spinner2.setAdapter(adapter2);
            } else if (i == 3) {
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, op4);
                spinner2.setAdapter(adapter2);
            }
            textito1.setText((String) adapterView.getItemAtPosition(i));
        } else if (adapterView.getId() == R.id.spinner2) {
            textito2.setText((String) adapterView.getItemAtPosition(i));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}