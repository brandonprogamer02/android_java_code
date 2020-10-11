package com.example.brandoxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pantalla = findViewById(R.id.pantalla);

    }

    public void onClickBoton1(View view){

        pantalla.setText(pantalla.getText() + "1");
    }
    public void onClickBoton2(View view){
        pantalla.setText(pantalla.getText() +"2");
    }
    public void onClickBoton3(View view){
        pantalla.setText(pantalla.getText() +"3");
    }
    public void onClickBoton4(View view){
        pantalla.setText("4");
    }
    public void onClickBoton5(View view){
        pantalla.setText("5");
    }
    public void onClickBoton6(View view){
        pantalla.setText("6");
    }
    public void onClickBoton7(View view){
        pantalla.setText("7");
    }
    public void onClickBoton8(View view){
        pantalla.setText("8");
    }
    public void onClickBoton9(View view){
        pantalla.setText("9");
    }
    public void onClickBoton0(View view){
        pantalla.setText("0");
    }
    public void onClickBotonMas(View view){
        System.out.println("se le dio click al boton mas");
        Operaciones.efectuarOperacion("+");

    }
    public void onClickBotonMenos(View view){

    }
    public void onClickBotonDivision(View view){

    }
    public void onClickBotonMultiplicacion(View view){

    }
    public void onClickBotonBorrar(View view){

    }
    public void onClickBotonPunto(View view){

    }
    public void onClickBotonBorrarTodo(View view){

    }
    public void onClickBotonIgual(View view){

    }
    public void onClickBotonPi(View view){

    }
    public void onClickBotonE(View view){

    }

    public static TextView getPantalla(){ return pantalla;}

    private static TextView pantalla;
}