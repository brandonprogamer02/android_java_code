package com.example.brandoxcalculator;
// me quede modificando el metodo Operaciones.getSelectedOperaction();

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.DoubleBuffer;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("============================================================================================");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pantalla = findViewById(R.id.pantalla);
        pantallaResultado = findViewById(R.id.pantallaResultado);
    }

    public void onClickBoton1(View view) {

        pintarTextoPantalla("1");
    }

    public void onClickBoton2(View view) {
        pintarTextoPantalla("2");

    }

    public void onClickBoton3(View view) {

        pintarTextoPantalla("3");

    }

    public void onClickBoton4(View view) {
        pintarTextoPantalla("4");

    }

    public void onClickBoton5(View view) {
        pintarTextoPantalla("5");

    }

    public void onClickBoton6(View view) {
        pintarTextoPantalla("6");

    }

    public void onClickBoton7(View view) {
        pintarTextoPantalla("8");

    }

    public void onClickBoton8(View view) {
        pintarTextoPantalla("8");

    }

    public void onClickBoton9(View view) {
        pintarTextoPantalla("9");

    }

    public void onClickBoton0(View view) {
        pintarTextoPantalla("0");

    }

    public void onClickBotonMas(View view) {
        // le mandamos el contexto por parametro
        validarClickOperacion("+", getApplicationContext());

    }

    public static void validarClickOperacion(String tipoOperacion, Context context) {
        // obtenemos la ultima letra del texto introducido
        // validacion para que no se pueda poner un simbolo operacional seguido de otrot
        String ultimo;
        try {
            ultimo = String.valueOf(textointroducido.charAt(textointroducido.length() - 1));
        }catch (IndexOutOfBoundsException e){
            // con esto se valida que el primer caracter introducido no sea una simbolo operacional
            Toast.makeText(context, "DEBES INTRODUCIR UNA CANTIDAD NUMERICA", Toast.LENGTH_SHORT).show();
            return;
        }

        if(ultimo.equals("+") || ultimo.equals("-") || ultimo.equals("*") || ultimo.equals("/")  ){
            Toast.makeText(context, "DEBES PONER UNA CANTIDAD NUMERICA", Toast.LENGTH_SHORT).show();
            return;
        }
        pintarTextoPantalla(tipoOperacion);
        Operaciones.setSelectedOperation(tipoOperacion);
        Operaciones.efectuarOperacion(tipoOperacion, context);
    }

    private static String reverse(String s) {
        if (s.length() <= 1) // este metodo te devuelve el reverso de un String
        {
            return s;
        }
        return reverse(s.substring(1, s.length())) + s.charAt(0);
    }

    public static Double getValorIntroducido() {
        String input = textointroducido;
        String lastChar = String.valueOf(textointroducido.charAt(textointroducido.length() - 1));
        // este metodo te devuelve el ultimo valor introducido
        // el recorre el string desde el final hasta el principio y va agregando cada caracter a otro string
        // que es el que se retornara, si se topa con un caracter operacional entoces se sale del bucle y retorna
        String resultado = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.println("mera cabra");
            String caracter = String.valueOf(input.charAt(i));
            if (caracter.equals(lastChar) && i == input.length() - 1) {
                System.out.println("ENTRO IF ");
                // la primera posicion siempre tendra el simbolo de la operacion actual, por eso lo ignoramos
                continue;
            } else if (caracter.equals("-") || caracter.equals("+")
                    || caracter.equals("*") || caracter.equals("/")) {
                System.out.println("ENTRO ELSE IF");
                // si te topas con otro signo operacional sal del bucle
                break;
            } else {
                System.out.println("entro en else bro");
                // en caso contrario agrega el caracter actual a la pila
                resultado = resultado + caracter;
            }

        }

        System.out.println("el resultado " + reverse(resultado));
        return Double.valueOf(reverse(resultado));
    }


    private static void pintarTextoPantalla(String substr) {
        textointroducido += substr;
        String texto = textointroducido;
        // el limite de caracteres en pantalla es de 11
        if (texto.length() >= 11) {// si se pasa se 11 caracteres se procede a ejecutar la magia
            // para pintarlo en pantalla ponemos solamente los ultimo 11 catacteres
            int miNumero = texto.length() - 11; // obtenemos la posicion en el string donde empiezan los ultimos 11 caracteres
            String real = texto.substring(miNumero);// los extremos
            //System.out.println(real);
            pantalla.setText(real);// lo pintamos
        } else {
            // en caso de que no exeda los 11 caracteres simplemente lo pintamos tal cual
            pantalla.setText(textointroducido);
        }
    }

    public static List<Integer> getPosOcurrencias(String cadena, String substr) {
        String str = cadena;
        String findStr = substr;
        int lastIndex = 0;
        List<Integer> result = new ArrayList<Integer>();

        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                result.add(lastIndex);
                lastIndex += 1;
            }

        }
        return result;

    }


    public void onClickBotonMenos(View view) {
        validarClickOperacion("-", getApplicationContext());
    }

    public void onClickBotonDivision(View view) {
        validarClickOperacion("/", getApplicationContext());
    }

    public void onClickBotonMultiplicacion(View view) {
        validarClickOperacion("*", getApplicationContext());
    }

    public void onClickBotonBorrar(View view) {

    }

    public void onClickBotonPunto(View view) {

    }

    public void onClickBotonBorrarTodo(View view) {
        pantallaResultado.setText("");
        pantallaResultado.setText("");
        textointroducido = "";

    }

    public void onClickBotonIgual(View view) {

        int ocurrencias =
                getPosOcurrencias(textointroducido, "+").size() + getPosOcurrencias(textointroducido, "-").size() +
                        getPosOcurrencias(textointroducido, "*").size() + getPosOcurrencias(textointroducido, "/").size();

        if (ocurrencias == 0) { // no nay ninguna operacion activa
            Toast.makeText(this, "no hay ninguna operacion o cantidad", Toast.LENGTH_SHORT).show();


        } else if (ocurrencias == 1) {
            List<Integer> lista = getPosOcurrencias(textointroducido, "-");
//            String valorA = textointroducido.substring(0,);

        } else {
            String operacionEncurso = Operaciones.getSelectedOperation();
            switch (operacionEncurso) {
                case "+":

                    List<Integer> ocurrencia = getPosOcurrencias(textointroducido, "+");

                    int posUltimoSignoMas = ocurrencia.get(ocurrencia.size() - 1);
                    int antePenultimaPosicoin = ocurrencia.get(ocurrencia.size() - 2);
                    String valorA = textointroducido.substring(antePenultimaPosicoin + 1, posUltimoSignoMas + 1);
                    String valorB = textointroducido.substring(posUltimoSignoMas + 1, textointroducido.length() - 1);
                    double res = Operaciones.sumar(Double.valueOf(valorA), Double.valueOf(valorB));
                    System.out.println("EN RESULTADO LA SUMA ES: " + res);
                    break;
            }

        }

    }

    public void onClickBotonPi(View view) {

    }

    public void onClickBotonE(View view) {

    }

    public static TextView getPantalla() {
        return pantalla;
    }

    public static TextView getPantallaResultado() {
        return pantallaResultado;
    }

    private static TextView pantalla;
    private static TextView pantallaResultado;
    public static String textointroducido = "";


}