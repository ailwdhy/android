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
        Imagenes imagenes = new Imagenes(imagenesId, textos1, textos2, this);
        listView.setAdapter(imagenes);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedItem = (String) String.valueOf(i);
        if (selectedItem.equals("0")){
            Intent intent = new Intent(MainActivity.this, Actividad2.class);
            startActivity(intent);
        }
    }
}
