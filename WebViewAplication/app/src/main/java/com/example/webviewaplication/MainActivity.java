package com.example.webviewaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // es importante que para poder utilizar el navegador web integrado en nuestra app ahi que darle permisos
    // de internet mediante el AndroidManifest.xml
    EditText text1;
    private ListView listView;

    @Override
    protected void onResume() {
        // este metodo se dispara cada vez que se entra al Activity( ya se la primera vez que se carga o cuando se viene de otro activity)
        super.onResume();
        Toast.makeText(this, "I AM BACK", Toast.LENGTH_SHORT).show();

        try {
            // LLENAMOS EL HISTORIAL
            llenarHistorial();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // llenamos editText con la ultima pagina navegada
        // obtenemos la instancia de la  db con esa instruccion si no existe la db se crea
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // se obtiene el valor de la key 'url'de esta forma =>
        text1.setText(preferences.getString("url", ""));
        System.out.println("QUE DIOS MALDITA A CUPIDAO");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        listView = findViewById(R.id.list);

    }

    public void llenarHistorial() throws IOException {

        String[] ficheros = fileList();
        if (fileExists("bitacora.txt")) {
            // EN CASO DE QUE SI EXISTA
            List<String> contenido = getData();
            // se crea un adaptador param1: contexto, param2: componente que se va a usar, para3: data
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contenido);
            listView.setAdapter(adaptador);

        } else {
            /*
            // EN CASO DE QUE NO EXISTA
            // con esta linea de codigo abrimos para escribir un archivo en caso de que no exista se crea
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));
            // cerramos to-do
            archivo.flush();
            archivo.close(); */
        }

    }

    public void guardarData() throws IOException {
        // con esta linea de codigo abrimos para escribir un archivo en caso de que no exista se crea
        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));

        // OBTENEMOS LA DATA QUE AHI ANTERIORMENTE Y LE AGREGAMOS UN NUEVO ELEMENTO
        String data = "";
        List<String> contenido = getData();
        System.out.println("SE OBTUVO");
        System.out.println(contenido);
        // adadimos el la url que puso el usuario a la lista
        // ahora ponemos to do eso en un solo string
        contenido.add(text1.getText().toString());
        for(String elemento: contenido){
            data+= elemento + "\n";
        }
        System.out.println("MERE esto se agrego desde guardar Data:");
        System.out.println(data);
        archivo.write(data); // anadimos la url al historial
        // cerramos to-do
        archivo.flush();
        archivo.close();

    }

    public List<String> getData() throws IOException {
        // cargamos el fichero en la aplicacion para poder abrirlo con BufferedReader
        List<String> contenido = new ArrayList<String>();
        InputStreamReader fichero = new InputStreamReader(openFileInput("bitacora.txt"));
        // lo leemos con ayuda de esta clase
        BufferedReader br = new BufferedReader(fichero);
        // usamos un while para iterar con ayuda del rb.readLinea() que funciona como iterador
        String linea = br.readLine();
        // si linea difiere de null es porque ahi algo asi que sigue recorriendo y anadiendo en cada vuelta
        // de bucle cada linea al array contenido
        while (linea != null){
            contenido.add(linea + "\n");
            linea = br.readLine();
        }
        br.close();
        fichero.close();
        System.out.println("anted de salir de getData: \n"+ contenido);
        return contenido;
    }

    public boolean fileExists(String file) {
        String[] ficheros = fileList();
        for (String fichero : ficheros)
            if (fichero.equals(file))
                return true;
        return false;
    }

    public void onClickNavegar(View view) throws IOException {
        // cada vez que se da a navegar una url, esta se guarda en la mini db
        // obtenemos instancia de la db
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // obtenemos objeto con el cual se puede interactuar en esa db
        SharedPreferences.Editor editor = preferences.edit();
        // metemos data con la key de 'url' a la db
        editor.putString("url", text1.getText().toString());
        // confirmamos lo cambios (obligatorio)
        editor.commit();

        // ahora lo guardamos en el historial
        guardarData();

        // pasamos a la otra Activity con este Intent. Ademas le mandamos la url por parametro
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", text1.getText().toString());
        startActivity(intent);
    }
}