package com.example.brandoxcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        pantalla.setText("4");

    }

    public void onClickBoton5(View view) {
        pantalla.setText("5");

    }

    public void onClickBoton6(View view) {
        pantalla.setText("6");

    }

    public void onClickBoton7(View view) {
        pantalla.setText("7");

    }

    public void onClickBoton8(View view) {
        pantalla.setText("8");

    }

    public void onClickBoton9(View view) {
        pantalla.setText("9");

    }

    public void onClickBoton0(View view) {
        pantalla.setText("0");

    }

    public void onClickBotonMas(View view) {
        // le mandamos el contexto por parametro
        validarClickOperacion("+",getApplicationContext());


    }
    public static void validarClickOperacion(String tipoOperacion, Context context){
        System.out.println("se le dio click al boton mas");
        // obtenemos la ultima letra del texto introducido
        String ultimo = String.valueOf(textointroducido.charAt(textointroducido.length() - 1));
        // validacion para que no se pueda poner un simbolo operacional seguido de otro
        if (ultimo.equals(tipoOperacion)) {
            // recibimos el contexto del activity por parametro
            Toast.makeText(context, "DEBES COLOCAR UNA CANTIDAD NUMERICA", Toast.LENGTH_SHORT).show();
        } else {
            Operaciones.setSelectedOperation(tipoOperacion);
            getCantidadIntroducida();
            pintarTextoPantalla(tipoOperacion);
        }

    }

    public static double getCantidadIntroducida() {
        double value = 0;
        String texto = textointroducido;
        System.out.println("EL TEXTO TIENE ESTE FLOW:" + texto);
        if (texto.contains("+") || texto.contains("-") || texto.contains("*") || texto.contains("/")) {
            // se obtiene una lista con las posiciones del simbolo de operacion que actualmente esta en uso
            List<Integer> ocurrencias = getPosOcurrencias(texto, Operaciones.getSelectedOperation());
            // si es la primera operacion en curso entonces se coje toda la expresion eliminando la ultima que es el simbolo
            if (ocurrencias.size() == 1) {
                System.out.println("la real es que: " + (texto.length() - 1));

            } else if (ocurrencias.size() > 1) {
                // en caso contrario de que hallan 2 o mas operaciones entonces se apica este algoritmo
                // .subtring(desde la ultima ocurrencia de un simbolo operacional hasta el final del string)
                int desde = ocurrencias.get(ocurrencias.size() - 1) + 1;
                System.out.println("RECORRIENDO LAS OCURRENCIAS AVER KLK");
                for (int f : ocurrencias) {
                    System.out.println(f);
                }

                int hasta = texto.length();
                System.out.println(String.format("DESDE: %s, HASTA: %S", desde, hasta));
                String real = texto.substring(desde, hasta);
                // en ocurrencias.size() -2 se le resta dos para elegir la penultima ocurrencia
                // en el primer parametro de la linea anterior se le suma uno para no incluir el simbolo operacional

                value = Double.valueOf(real);
            }

        } else {
            value = Double.valueOf(texto);
        }
        System.out.println("LA CANTIDAD ES: " + value);
        return value;
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

    private static List<Integer> getPosOcurrencias(String cadena, String substr) {
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

    }

    public void onClickBotonDivision(View view) {

    }

    public void onClickBotonMultiplicacion(View view) {

    }

    public void onClickBotonBorrar(View view) {

    }

    public void onClickBotonPunto(View view) {

    }

    public void onClickBotonBorrarTodo(View view) {

    }

    public void onClickBotonIgual(View view) {

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
    private static String textointroducido = "";

}