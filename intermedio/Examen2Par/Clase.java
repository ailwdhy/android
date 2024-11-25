package com.example.examen2par;

public class Clase {
    public int suma(int value1, int value2) {
        return value1 + value2;
    }

    public int resta(int value1, int value2) {
        return value1 - value2;
    }

    public int multiplicacion(int value1, int value2) {
        return value1 * value2;
    }

    public String division(int value1, int value2) {
        if (value2 == 0)
            return "No se puede dividir entre cero";
        return String.valueOf(value1 / value2);
    }

    private int dato;
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    public int doble(){
        return dato * 2;
    }
    public int triple(){
        return dato * 3;
    }
    public int cuadruple(){
        return dato * 4;
    }
}
