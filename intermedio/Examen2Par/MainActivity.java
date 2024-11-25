package com.example.examen2par;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] titles = {" Actividad 1", " Actividad 2", " Actividad 3"};
    String[] descriptions = {"Clic aqui para Actividad 1", "Clic aqui para Actividad 2", "Clic aqui para Actividad 3"};
    int[] images = {R.drawable.ope, R.drawable.dos, R.drawable.tres};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.vistita);
        Adaptador adapter = new Adaptador(this, titles, descriptions, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, MainActivity2.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, MainActivity3.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, MainActivity4.class);
                        break;
                    default:
                        intent = null;
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}