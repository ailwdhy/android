package com.example.nuevo;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Clasesita> kekas = new ArrayList<>();
    private ArrayList<Integer> cantidades = new ArrayList<>();

    public void agregarAlCarrito(Clasesita seleccion, int cantidad) {
        kekas.add(seleccion);
        cantidades.add(cantidad);
    }

    public ArrayList<Clasesita> getKekasSeleccionadas() {
        return kekas;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }
}