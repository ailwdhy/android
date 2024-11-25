package com.example.aplic;

public class Clasesita {
    private int datito1;
    private int datito2;

    public void setDatito1(int datito1) {
        this.datito1 = datito1;
    }

    public void setDatito2(int datito2) {
        this.datito2 = datito2;
    }
    public double cuadradito(){
        return Math.pow(datito1,2);
    }

    public double triangulo(){
        return datito1*datito2/2;
    }

    public double rectangulito(){
        return datito1*datito2;
    }
}