package com.example.myapplication;

public class Numerito {
    private int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String convierteATexto() {
        if (numero > 0 && numero <= 15) {
            if (numero > 8) {
                if (numero > 12) {
                    if (numero > 14) {
                        return "quince";
                    } else {
                        if (numero > 13) {
                            return "catorce";
                        } else {
                            return "trece";
                        }
                    }
                } else {
                    if (numero > 11) {
                        return "doce";
                    } else {
                        if (numero > 10) {
                            return "once";
                        } else {
                            return "diez";
                        }
                    }
                }
            } else {
                if (numero > 6) {
                    if (numero > 7) {
                        return "ocho";
                    } else {
                        return "siete";
                    }
                } else {
                    if (numero > 2) {
                        if (numero > 4) {
                            if (numero > 5) {
                                return "seis";
                            } else {
                                return "cinco";
                            }
                        } else {
                            if (numero > 3) {
                                return "cuatro";
                            } else {
                                return "tres";
                            }
                        }
                    } else {
                        if (numero > 1) {
                            return "dos";
                        } else {
                            return "uno";
                        }
                    }
                }
            }
        } else {
            return "dato erroneo";
        }
    }
}