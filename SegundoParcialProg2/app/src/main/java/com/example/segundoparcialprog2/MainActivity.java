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

    static TextView titulo,resultado;
    static RadioGroup grupo1;
    static RadioButton unoa,unob,unoc,unod,dosa,dosb,dosc,dosd,tresa,tresb,tresc,tresd,cuatroa,cuatrob,cuatroc,cuatrod,cincoa,cincob,cincoc,cincod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // cargamos las importanciones del xml
        cargarImportacionaesXML();
        //-----------------------------------------------------------------------------------------------------------------

        titulo.setText(Html.fromHtml("<b>REAL QUIZ PROGRAMACION 2<BR/>BRANDOX MEJIA</b>"));

        findViewById(R.id.verResultado).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Logica.resolver();
            }
        });

    }
    public void cargarImportacionaesXML(){
        titulo =  findViewById(R.id.tituloprincipal);
        resultado =  findViewById(R.id.resultado);
        grupo1 = findViewById(R.id.radioGroup1);
        unoa = findViewById(R.id.unoa); unob = findViewById(R.id.unob); unoc = findViewById(R.id.unoc); unod = findViewById(R.id.unod);
        dosa = findViewById(R.id.dosa); dosb = findViewById(R.id.dosb); dosc = findViewById(R.id.dosc); dosd = findViewById(R.id.dosd);
        tresa = findViewById(R.id.tresa); tresb = findViewById(R.id.tresb); tresc = findViewById(R.id.tresc); tresd = findViewById(R.id.tresd);
        cuatroa = findViewById(R.id.cuatroa); cuatrob = findViewById(R.id.cuatrob); cuatroc = findViewById(R.id.cuatroc); cuatrod = findViewById(R.id.cuatrod);
        cincoa = findViewById(R.id.cincoa); cincob = findViewById(R.id.cincob); cincoc = findViewById(R.id.cincoc); cincod = findViewById(R.id.cincod);
    }

}