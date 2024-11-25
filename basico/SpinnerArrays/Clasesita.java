package com.example.nuevito;

public class Clasesita {
    private int clave;
    private String deque;
    private int costo;

    public Clasesita(int clave, String deque, int costo) {
        this.clave = clave;
        this.deque = deque;
        this.costo = costo;
    }

    public Clasesita() {}

    public int getClave() {
        return clave;
    }

    public String toString() {
        return deque;
    }

    public int getCosto() {
        return costo;
    }
}