package com.example.nuevo;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class Paguito {

    public void mostrarPago(Context context, Carrito carrito) {
        ArrayList<Clasesita> kekasSeleccionadas = carrito.getKekasSeleccionadas();
        ArrayList<Integer> cantidades = carrito.getCantidades();
        int total = 0;

        for (int i = 0; i < kekasSeleccionadas.size(); i++) {
            Clasesita keka = kekasSeleccionadas.get(i);
            int cantidad = cantidades.get(i);
            int costoPorTipo = keka.getCosto() * cantidad;
            total += costoPorTipo;
            Toast.makeText(context, cantidad + " " + keka.toString(), Toast.LENGTH_LONG).show();
        }
        Toast.makeText(context, "total " + total, Toast.LENGTH_LONG).show();
    }
}