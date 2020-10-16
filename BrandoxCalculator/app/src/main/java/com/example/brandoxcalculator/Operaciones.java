package com.example.brandoxcalculator;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class Operaciones {

    public static void efectuarOperacion(String tipoOperacion, Context context) {
        TextView pantallaResultado = MainActivity.getPantallaResultado();
        System.out.println("valorA[0] comienzo:" + valorA[0]);
        // entramos a la de igual
        if (tipoOperacion.equals("=")) {
            // le agregamos un valor cualquiera a lo ultimo(porque asi es que funciona el algoritmo de getValorIntroducido())
            // buscamos de nuevo el valorIntroducido(); y luego le quitamos el valor que le agregamos para dejarlo virgen
            MainActivity.textointroducido += "+";
            double valorPantalla = MainActivity.getValorIntroducido();
            MainActivity.textointroducido = MainActivity.textointroducido.substring(0, MainActivity.textointroducido.length() - 1);
            // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
            // encambio si tiene algun valor resolvemos
            System.out.println("ESTE ES EL VALOR EN PANTALLA:" + valorPantalla + ", este es el  valorA[0]:" + valorA[0]);
            double result = 0;
            switch (operacionAnt) {
                case "+":
                    result = sumar((double) valorA[0], valorPantalla);
                    break;
                case "-":
                    result = restar((double) valorA[0], valorPantalla);
                    break;
                case "*":
                    result = multiplicar((double) valorA[0], valorPantalla);
                    break;
                case "/":
                    result = dividir((double) valorA[0], valorPantalla);
                    break;
            }
            valorA[0] = result;
            valorA[1] = false;
            MainActivity.textointroducido = String.valueOf(result);
            pantallaResultado.setText(String.valueOf(result));
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
                    if (!(boolean) valorA[1]) {
                        valorA[0] = valorPantalla;
                        valorA[1] = true;
                    } else if ((boolean) valorA[1]) { // encambio si tiene algun valor resolvemos
                        double result = sumar(valorPantalla, (double) valorA[0]);
                        valorA[0] = result;
                        pantallaResultado.setText(String.valueOf(result));
                    }
                    setSelectedOperation("+");

                    break;

                case "*":
                    // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
                    if (!(boolean) valorA[1]) {
                        valorA[0] = valorPantalla;
                        valorA[1] = true;

                    } else if ((boolean) valorA[1]) { // encambio si tiene algun valor resolvemos

                        double result = multiplicar(valorPantalla, (double) valorA[0]);
                        valorA[0] = result;
                        pantallaResultado.setText(String.valueOf(result));
                    }
                    setSelectedOperation("*");
                    break;

                case "/":
                    // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
                    if (!(boolean) valorA[1]) {
                        valorA[0] = valorPantalla;
                        valorA[1] = true;
                    } else if ((boolean) valorA[1]) { // encambio si tiene algun valor resolvemos

                        double result = dividir((double) valorA[0], valorPantalla);
                        valorA[0] = result;
                        pantallaResultado.setText(String.valueOf(result));
                    }
                    setSelectedOperation("/");


                    break;

                case "-":
                    // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
                    if (!(boolean) valorA[1]) {
                        valorA[0] = valorPantalla;
                        valorA[1] = true;
                    } else if ((boolean) valorA[1]) { // encambio si tiene algun valor resolvemos

                        double result = restar((double) valorA[0], valorPantalla);
                        valorA[0] = result;
                        pantallaResultado.setText(String.valueOf(result));
                    }
                    setSelectedOperation("-");

                    break;
            }

            System.out.println("valorA[0] final:" + valorA[0]);
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
            case "+":
                isSuma = true;
                break;
            case "*":
                isMultiplicacion = true;
                break;
            case "/":
                isDivision = true;
                break;
            case "-":
                isResta = true;
                break;
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

    // los valores A es un array de objetos. la primera posicion es el valor y la
    // segunda posicion es si tiene algun valor o no. ya que no se puede validar si esta
    // vacio o no con numeros ya que esta variable contiene todo tipo de numeros

    public static String operacionAnt;
    public static Object[] valorA = {0, false};

}
