package com.example.trabajo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String deportescomenta[] ={"cero", "uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};

    String deporteslista[]={"tigre","hipo","animal1","huron","gato","dos","pandita","jaguar","pere","elefante"};
    int deporteimagenes [] = {
                R.drawable.tigre, R.drawable.hipo,
                R.drawable.animal1, R.drawable.huron,
                R.drawable.gato, R .drawable.dos,
                R.drawable.pandita, R.drawable.jaguar,
                R.drawable.pere, R.drawable.elefante
                            };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.vistita);
        listView.setOnItemClickListener(this);
        Adaptador adaptadorcito = new Adaptador(getApplicationContext(),deportescomenta,deporteslista,deporteimagenes);
        listView.setAdapter(adaptadorcito);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,String.valueOf(position),Toast.LENGTH_SHORT).show();


    }
}