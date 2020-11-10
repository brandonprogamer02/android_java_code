package com.example.segundoparcialprog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static TextView titulo,resultado,respuesta1,respuesta2,respuesta3,respuesta4,respuesta5;
    static RadioGroup grupo1;
    static RadioButton unoa,unob,unoc,unod,dosa,dosb,dosc,dosd,tresa,tresb,tresc,tresd,cuatroa,cuatrob,cuatroc,cuatrod,cincoa,cincob,cincoc,cincod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //----------------------------------------------------------------------------------------------------------------
        cargarImportacionaesXML();
        loadEvents();

        //-----------------------------------------------------------------------------------------------------------------
        titulo.setText(Html.fromHtml("<b>REAL QUIZ PROGRAMACION 2<BR/>BRANDOX MEJIA</b>"));

    }
    public void loadEvents(){
        findViewById(R.id.verResultado).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Logica.getInstance().resolver();
            }
        });
        findViewById(R.id.salir).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


    }
    public void cargarImportacionaesXML(){
        titulo =  findViewById(R.id.tituloprincipal);
        resultado =  findViewById(R.id.resultado);
        respuesta1  = findViewById(R.id.respuesta1); respuesta2  = findViewById(R.id.respuesta2); respuesta3  = findViewById(R.id.respuesta3);
        respuesta4  = findViewById(R.id.respuesta4);respuesta5  = findViewById(R.id.respuesta5);
        grupo1 = findViewById(R.id.radioGroup1);
        unoa = findViewById(R.id.unoa); unob = findViewById(R.id.unob); unoc = findViewById(R.id.unoc); unod = findViewById(R.id.unod);
        dosa = findViewById(R.id.dosa); dosb = findViewById(R.id.dosb); dosc = findViewById(R.id.dosc); dosd = findViewById(R.id.dosd);
        tresa = findViewById(R.id.tresa); tresb = findViewById(R.id.tresb); tresc = findViewById(R.id.tresc); tresd = findViewById(R.id.tresd);
        cuatroa = findViewById(R.id.cuatroa); cuatrob = findViewById(R.id.cuatrob); cuatroc = findViewById(R.id.cuatroc); cuatrod = findViewById(R.id.cuatrod);
        cincoa = findViewById(R.id.cincoa); cincob = findViewById(R.id.cincob); cincoc = findViewById(R.id.cincoc); cincod = findViewById(R.id.cincod);
    }


}