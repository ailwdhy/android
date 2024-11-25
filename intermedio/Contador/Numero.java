package com.example.numerillos;

public class Numero {
    private final String[] unidades = {
            "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"
    };

    private final String[] especiales = {
            "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"
    };

    private final String[] veinteEspeciales = {
            "veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco",
            "veintiséis", "veintisiete", "veintiocho", "veintinueve"
    };

    private final String[] decenas = {
            "", "", "", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"
    };

    private final String[] centenas = {
            "", "cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"
    };

    private final String[] decenasEspeciales = {
            "", "", "veintiun", "treinta y un", "cuarenta y un", "cincuenta y un", "sesenta y un", "setenta y un", "ochenta y un", "noventa y un"
    };

    public String convertirUnidades(int numero) {
        return unidades[numero];
    }

    public String convertirDecenas(int numero) {
        if (numero < 10) {
            return convertirUnidades(numero);
        } else if (numero < 20) {
            return especiales[numero - 10];
        } else if (numero < 30) {
            return veinteEspeciales[numero - 20];
        } else {
            int unidad = numero % 10;
            int decena = numero / 10;
            if (unidad == 0) {
                return decenas[decena];
            } else {
                return decenas[decena] + " y " + convertirUnidades(unidad);
            }
        }
    }

    public String convertirDecenasEspeciales(int numero) {
        if (numero < 10) {
            return convertirUnidades(numero);
        } else {
            int unidad = numero % 10;
            int decena = numero / 10;
            if (unidad == 0) {
                return decenas[decena];
            } else {
                return decenasEspeciales[decena];
            }
        }
    }

    public String convertirCentenas(int numero) {
        if (numero < 100) {
            return convertirDecenas(numero);
        } else {
            int centena = numero / 100;
            int resto = numero % 100;
            if (resto == 0) {
                return centenas[centena];
            } else {
                return (centena == 1 ? "ciento" : centenas[centena]) + " " + convertirDecenas(resto);
            }
        }
    }

    public String convertirCentenasEspeciales(int numero) {
        if (numero < 100) {
            return convertirDecenas(numero);
        } else {
            int centena = numero / 100;
            int resto = numero % 100;
            if (resto == 0) {
                return centenas[centena];
            } else if (resto == 1) {
                return (centena == 1 ? "ciento" : centenas[centena]) + " " + "un";
            } else {
                return (centena == 1 ? "ciento" : centenas[centena]) + " " + convertirDecenasEspeciales(resto);
            }
        }
    }

    public String convertirMiles(int numero) {
        if (numero < 1000) {
            return convertirCentenas(numero);
        } else {
            int miles = numero / 1000;
            int resto = numero % 1000;
            String milesTexto;
            if (resto == 0) {
                milesTexto = miles == 1 ? "mil" : convertirCentenas(miles) + " mil";
                return milesTexto;
            } else if (miles==101||miles==121||miles==131||miles==141||miles==151||miles==161||miles==171||miles==181||miles==191) {
                milesTexto = miles == 1 ? "mil" : convertirCentenasEspeciales(miles) + " mil";
                return milesTexto + " " + convertirCentenas(resto);
            } else {
                milesTexto = miles == 1 ? "mil" : convertirCentenas(miles) + " mil";
                return milesTexto + " " + convertirCentenas(resto);
            }
        }
    }
}
