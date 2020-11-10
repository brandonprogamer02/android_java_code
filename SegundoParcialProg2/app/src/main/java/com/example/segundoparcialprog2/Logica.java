package com.example.segundoparcialprog2;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.RadioGroup;

public class Logica {
    private static Logica instance;
    private Logica() {}

    public static Logica getInstance(){
        if(instance == null) instance = new Logica();
        return instance;
    }
    public int getPuntuacion(){
        int puntuacion = 0;
        if (MainActivity.unoa.isChecked()) puntuacion +=5;
        if(MainActivity.dosb.isChecked()) puntuacion +=5;
        if(MainActivity.tresa.isChecked()) puntuacion +=5;
        if(MainActivity.cuatroa.isChecked()) puntuacion +=5;
        if(MainActivity.cincoa.isChecked()) puntuacion +=5;
        return puntuacion;
    }
    public void resolver(){
        int puntuacion = getPuntuacion();
        MainActivity.resultado.setText(String.format("Tu puntuacion fue de: %s/20",puntuacion));
        showAnswers();
    }
    private void showAnswers(){
        MainActivity.respuesta1.setVisibility(View.VISIBLE); MainActivity.respuesta2.setVisibility(View.VISIBLE); MainActivity.respuesta3.setVisibility(View.VISIBLE);
        MainActivity.respuesta4.setVisibility(View.VISIBLE); MainActivity.respuesta5.setVisibility(View.VISIBLE);
    }

}
