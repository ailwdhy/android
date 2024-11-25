package com.example.uwu;

public class Clasesita {
    private int datito1;
    private int datito2;

    public Clasesita(int datito1) {
        this.datito1 = datito1;
    }

    public Clasesita(int datito1, int datito2) {
        this.datito1 = datito1;
        this.datito2 = datito2;
    }

    public int arear() {
        return datito1 * datito2;
    }

    public int areac() {
        return datito1 * datito1;
    }



}