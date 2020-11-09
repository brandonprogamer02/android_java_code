package com.example.segundoparcialprog2;

import android.content.res.ColorStateList;
import android.widget.RadioGroup;

public class Logica {

    public static int getPuntuacion(){
        int puntuacion = 0;
        if (MainActivity.unoa.isChecked()) puntuacion +=5;
        if(MainActivity.dosb.isChecked()) puntuacion +=5;
        if(MainActivity.tresa.isChecked()) puntuacion +=5;
        if(MainActivity.cuatroa.isChecked()) puntuacion +=5;
        if(MainActivity.cincoa.isChecked()) puntuacion +=5;

        return puntuacion;
    }
    public static void resolver(){
        int puntuacion = getPuntuacion();
        MainActivity.resultado.setText(String.format("Tu puntuacion fue de: %s",puntuacion));

    }

}
