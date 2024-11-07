package com.example.switchingmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] textos1 = {"calculadora", "imagen", "imagen", "imagen"};
        String[] textos2 = {"ir a la calculadora", "texto", "texto", "texto"};
        int[] imagenesId = {
                R.drawable.ternurin1,
                R.drawable.ternurin2,
                R.drawable.ternurin3,
                R.drawable.ternurin4
        };

        ListView listView = findViewById(R.id.lista);
        listView.setOnItemClickListener(this);
        // adaptador para la lista de imagenes y textos
        Imagenes imagenes = new Imagenes(imagenesId, textos1, textos2, this);
        // asignar el el adaptador a imagenes
        listView.setAdapter(imagenes);
    }

    @Override
    // al hacer click en lista
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // obtiene el item seleccionado
        String selectedItem = (String) String.valueOf(i);
        // para el item 0 (primer ternurin) se abre la actividad de operaciones con el menusito
        if (selectedItem.equals("0")){
            // intent para redireccionar al menusito
            Intent intent = new Intent(MainActivity.this, Actividad2.class);
            startActivity(intent);
        }
    }
}
