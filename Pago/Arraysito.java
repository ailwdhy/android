package com.example.nuevo;

import java.util.ArrayList;

public class Arraysito {
    ArrayList<Clasesita> kekitas = new ArrayList<>();

    public Arraysito() {
        kekitas.add(new Clasesita(0, "cuál", 0));
        kekitas.add(new Clasesita(1, "queso", 30));
        kekitas.add(new Clasesita(2, "papa", 20));
        kekitas.add(new Clasesita(3, "picadillo", 40));
    }

    public ArrayList<Clasesita> regresa() {
        return kekitas;
    }
}