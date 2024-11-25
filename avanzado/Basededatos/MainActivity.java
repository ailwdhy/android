package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText etcodigo, etdescripcion, etprecio;
Button botoncitoa, botoncitoc,botoncitob,botoncitoco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etcodigo = findViewById(R.id.ecodigo);
        etdescripcion = findViewById(R.id.edescripcion);
        etprecio = findViewById(R.id.eprecio);

        botoncitoa = findViewById(R.id.altas);
        botoncitob = findViewById(R.id.bajas);
        botoncitoc = findViewById(R.id.cambios);
        botoncitoco = findViewById(R.id.consultas);

        botoncitoa.setOnClickListener(this);
        botoncitob.setOnClickListener(this);
        botoncitoc.setOnClickListener(this);
        botoncitoco.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String cadena  = ((Button)v).getText().toString();


        if ( cadena.equals("altas")){
            botoncitob.setEnabled(false);
            botoncitoc.setEnabled(false);
            botoncitoco.setEnabled(false);
            etcodigo.setEnabled(true);
            etprecio.setEnabled(true);
            etdescripcion.setEnabled(true);
            botoncitoa.setText("agregar");

        } else
        if (cadena.equals("agregar")) {
            Base admin = new Base(this, "administracion",null, 1);
            SQLiteDatabase basesita = admin.getWritableDatabase();
            int llavesita =Integer.parseInt(etcodigo.getText().toString());
            String titulito = etdescripcion.getText().toString();
            int costito =Integer.parseInt(etprecio.getText().toString());

            ContentValues registro = new ContentValues();
            registro.put("clave", llavesita);
            registro.put("descripcion", titulito);
            registro.put("precio", costito);
            basesita.insert("cinecito", null, registro);
            Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();

            basesita.close();
            botoncitoa.setText("restaurar");

        } else


                if (cadena.equals("cambios")) {
                    botoncitoa.setEnabled(false);
                    botoncitob.setEnabled(false);
                    botoncitoco.setEnabled(false);
                    etcodigo.setEnabled(true);
                    etprecio.setEnabled(true);
                    etdescripcion.setEnabled(true);
                    etcodigo.requestFocus();
                    botoncitoc.setText("actualizar");

                } else if (cadena.equals("actualizar")) {
                    Base admin = new Base(this, "administracion", null, 1);
                    SQLiteDatabase basesita = admin.getWritableDatabase();

                    String codigo = etcodigo.getText().toString();
                    String nuevaDescripcion = etdescripcion.getText().toString();
                    String nuevoPrecio = etprecio.getText().toString();

                    ContentValues valoresActualizados = new ContentValues();
                    valoresActualizados.put("descripcion", nuevaDescripcion);
                    valoresActualizados.put("precio", nuevoPrecio);

                    int filasAfectadas = basesita.update("cinecito", valoresActualizados, "clave=?", new String[]{codigo});

                    if (filasAfectadas > 0) {
                        Toast.makeText(this, "Registro actualizado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "No se encontró el registro", Toast.LENGTH_SHORT).show();
                    }

                    basesita.close();
                    botoncitoc.setText("restaurar");

                } else


                        if (cadena.equals("consultas")) {
                            botoncitoa.setEnabled(false);
                            botoncitoc.setEnabled(false);
                            botoncitob.setEnabled(false);
                            etcodigo.setEnabled(true);
                            etcodigo.requestFocus();
                            botoncitoco.setText("buscar");
                        } else
                        if (cadena.equals("buscar")) {
                            Base admin = new Base(this, "administracion",null, 1);
                            SQLiteDatabase basededatos = admin.getReadableDatabase();
                            String codigo =etcodigo.getText().toString();
                            Cursor fila = basededatos.rawQuery("select descripcion, precio from cinecito where clave="+codigo, null);
                            if(fila.moveToFirst()){
                                etdescripcion.setEnabled(true);
                                etprecio.setEnabled(true);
                                etcodigo.setEnabled(false);
                                etdescripcion.setText(fila.getString(0));
                                etdescripcion.setEnabled(false);
                                etprecio.setText(fila.getString(1));
                                etprecio.setEnabled(false);
                            } else
                                Toast.makeText(getApplicationContext(),"No existe el registro", Toast.LENGTH_SHORT).show();

                            botoncitoco.setText("restaurar");
                            basededatos.close();
                        }



                                else if (cadena.equals("bajas")) {
                                    etcodigo.setEnabled(true);
                                    botoncitoa.setEnabled(false);
                                    botoncitoc.setEnabled(false);
                                    botoncitoco.setEnabled(false);
                                    botoncitob.setText("eliminar");

                                } else if (cadena.equals("eliminar")) {
                                    Base admin = new Base(this, "administracion", null, 1);
                                    SQLiteDatabase basesita = admin.getWritableDatabase();

                                    String codigo = etcodigo.getText().toString();
                                    int filasAfectadas = basesita.delete("cinecito", "clave=" + codigo, null);

                                    if (filasAfectadas > 0) {
                                        Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(this, "No se encontró el registro", Toast.LENGTH_SHORT).show();
                                    }

                                    basesita.close();
                                    botoncitob.setText("restaurar");

                                } else
                                    if (cadena.equals("restaurar")) {
                                        etcodigo.setEnabled(false); etcodigo.setText("");
                                        etdescripcion.setEnabled(false); etdescripcion.setText("");
                                        etprecio.setEnabled(false); etprecio.setText("");
                                        botoncitoa.setText("altas"); botoncitoa.setEnabled(true);
                                        botoncitob.setText("bajas"); botoncitob.setEnabled(true);
                                        botoncitoco.setText("consultas"); botoncitoco.setEnabled(true);
                                        botoncitoc.setText("cambios"); botoncitoc.setEnabled(true);
                                    }

    }
}