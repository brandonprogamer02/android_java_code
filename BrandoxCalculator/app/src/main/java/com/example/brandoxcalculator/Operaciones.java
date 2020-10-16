package com.example.brandoxcalculator;
// me quede bregando para que se elija la operacion anterior

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class Operaciones {

    public static void efectuarOperacion(String tipoOperacion, Context context) {
        double valorPantalla = MainActivity.getValorIntroducido();
        TextView pantallaResultado = MainActivity.getPantallaResultado();
        if( operacionAnt == null){
            operacionAnt = tipoOperacion;
        }
        switch (operacionAnt) {
            case "+":
                // si valorA esta vacio(osea esta en false su segunda pos)le asignamos el valor
                if (!(boolean) valorA[1]) {
                    valorA[0] = valorPantalla;
                    valorA[1] = true;
                } else if ((boolean) valorA[1]) { // encambio si tiene algun valor resolvemos

                    double result = sumar(valorPantalla,(double) valorA[0]);
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

                    double result = dividir((double) valorA[0],valorPantalla);
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

                    double result = restar((double) valorA[0],valorPantalla);
                    valorA[0] = result;
                    pantallaResultado.setText(String.valueOf(result));
                }
                setSelectedOperation("-");

                break;
            case "=":

                break;
        }
        operacionAnt = tipoOperacion;
    }

    public static void setSelectedOperation(String value) {

        // verificamos si hay una operacion activa -> en caso de true le damos a evaluar esa operacion
        // en caso se que no haya operacion activa entonces le damos la que nos da por parametro

        // esto se hace con el fin de que coja siempre la operacion anterior a la que se presiona

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

    private static String operacionAnt;
    private static String operacionAct;

    private static Object[] valorA = {0, false};
    private static boolean operationProcess;
}
