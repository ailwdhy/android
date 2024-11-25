package com.example.switchingmenu;

public class Operaciones {

    public int x, y;

    // constructor de la clase, inicia las variables
    public Operaciones(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int suma (){ return x + y;}
    public int resta (){ return x - y;}
    public int multi (){ return x * y;}
    public int divi (){
        // para cuando no es division entre cero
        if (y != 0)
            return x / y;
        else
            // indeterminacion para division entre cero
            return 0;
    }
}
