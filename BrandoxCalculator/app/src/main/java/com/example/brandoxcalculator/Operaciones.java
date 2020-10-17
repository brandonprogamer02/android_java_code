package com.example.brandoxcalculator;

import android.content.Context;
import android.widget.TextView;

public class Operaciones {
    public static void efectuarOperacion(String tipoOperacion, Context context) {
        TextView pantallaResultado = MainActivity.getPantallaResultado();
        System.out.println("valorA[0] comienzo:" + resultadoMemoriaRam[0]);
        // entramos a la de igual
        if(salidoIgual){
            // esta variable salidoIgual es para que despues de que se le de al igual y se le de a un boton de
            // operacion no la haga la operacion
            salidoIgual = false;
            return;
        }
        if (tipoOperacion.equals("=")) {
            // le agregamos un valor cualquiera a lo ultimo(porque asi es que funciona el algoritmo de getValorIntroducido())
            // buscamos de nuevo el valorIntroducido(); y luego le quitamos el valor que le agregamos para dejarlo virgen
            MainActivity.textointroducido += "+";
            double valorPantalla = MainActivity.getValorIntroducido();
            MainActivity.textointroducido = MainActivity.textointroducido.substring(0, MainActivity.textointroducido.length() - 1);

            double result = 0;
            // determinamos que operacion es que se va a hacer
            switch (operacionAnt) {
                case "+":
                    result = sumar((double) resultadoMemoriaRam[0], valorPantalla);
                    break;
                case "-":
                    result = restar((double) resultadoMemoriaRam[0], valorPantalla);
                    break;
                case "*":
                    result = multiplicar((double) resultadoMemoriaRam[0], valorPantalla);
                    break;
                case "/":
                    result = dividir((double) resultadoMemoriaRam[0], valorPantalla);
                    break;
            }
            // al resultado en memoria ram(valorA[0]) le asignamos el resultado hallado
            resultadoMemoriaRam[0] = result;
            resultadoMemoriaRam[1] = true;
            pantallaResultado.setText(String.valueOf(result));
            // le damos true a esta variable salidoIgual para que la proxima vez que se le de a un simbolo de operacion
            // no haga la operacion
            salidoIgual = true;
            return;
        } else {
            if (operacionAnt == null) {
                // esto se hace con el fin de que se efectue la operacion anterior a la que se esta presionando en boton
                // si la operacion anterior es null entonces la operacion anterir es igual a la que se presiono (esto se hace cuando es la primera operacion)
                operacionAnt = tipoOperacion;
            }
            double valorPantalla = MainActivity.getValorIntroducido();
            switch (operacionAnt) {
                case "+":
                    // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
                    if (!(boolean) resultadoMemoriaRam[1]) {
                        resultadoMemoriaRam[0] = valorPantalla;
                        resultadoMemoriaRam[1] = true;
                    } else if ((boolean) resultadoMemoriaRam[1]) { // encambio si tiene algun valor resolvemos
                        double result = sumar(valorPantalla, (double) resultadoMemoriaRam[0]);
                        resultadoMemoriaRam[0] = result;
                        pantallaResultado.setText(String.valueOf(result));
                    }
                    setSelectedOperation("+");
                    break;

                case "*":
                    // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
                    if (!(boolean) resultadoMemoriaRam[1]) {
                        resultadoMemoriaRam[0] = valorPantalla;
                        resultadoMemoriaRam[1] = true;

                    } else if ((boolean) resultadoMemoriaRam[1]) { // encambio si tiene algun valor resolvemos

                        double result = multiplicar(valorPantalla, (double) resultadoMemoriaRam[0]);
                        resultadoMemoriaRam[0] = result;
                        pantallaResultado.setText(String.valueOf(result));
                    }
                    setSelectedOperation("*");
                    break;

                case "/":
                    // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
                    if (!(boolean) resultadoMemoriaRam[1]) {
                        resultadoMemoriaRam[0] = valorPantalla;
                        resultadoMemoriaRam[1] = true;
                    } else if ((boolean) resultadoMemoriaRam[1]) { // encambio si tiene algun valor resolvemos

                        double result = dividir((double) resultadoMemoriaRam[0], valorPantalla);
                        resultadoMemoriaRam[0] = result;
                        pantallaResultado.setText(String.valueOf(result));
                    }
                    setSelectedOperation("/");


                    break;

                case "-":
                    // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
                    if (!(boolean) resultadoMemoriaRam[1]) {
                        resultadoMemoriaRam[0] = valorPantalla;
                        resultadoMemoriaRam[1] = true;
                    } else if ((boolean) resultadoMemoriaRam[1]) { // encambio si tiene algun valor resolvemos

                        double result = restar((double) resultadoMemoriaRam[0], valorPantalla);
                        resultadoMemoriaRam[0] = result;
                        pantallaResultado.setText(String.valueOf(result));
                    }
                    setSelectedOperation("-");

                    break;
            }

            System.out.println("valorA[0] final:" + resultadoMemoriaRam[0]);
            operacionAnt = tipoOperacion;


        }


    }
    public static void setSelectedOperation(String value) {
        String valueFicticio = value;
        isSuma = false;
        isResta = false;
        isMultiplicacion = false;
        isDivision = false;
        switch (valueFicticio) {
            case "+": isSuma = true; break;
            case "*": isMultiplicacion = true; break;
            case "/": isDivision = true; break;
            case "-":isResta = true; break;
        }
    }

    public static String getSelectedOperation() {
        if (isResta) return "-";
        else if (isSuma) return "+";
        else if (isMultiplicacion) return "*";
        else if (isDivision) return "/";
        else return null;
    }

    private Operaciones() {

    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }

    private static boolean isSuma = false;
    private static boolean isResta = false;
    private static boolean isMultiplicacion = false;
    private static boolean isDivision = false;

    // en resultadoMemoriaRam. la primera posicion es el valor y la
    // segunda posicion es si tiene algun valor o no. ya que no se puede validar si esta
    // vacio o no con numeros ya que esta variable contiene to do tipo de numeros incuidos 0 y numeros negativos

    public static String operacionAnt;
    public static Object[] resultadoMemoriaRam = {0, false};
    private static boolean salidoIgual = false;

}
