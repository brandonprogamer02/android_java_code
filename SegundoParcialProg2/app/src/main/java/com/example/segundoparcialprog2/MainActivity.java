package com.example.segundoparcialprog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        titulo =  findViewById(R.id.tituloprincipal);
        titulo.setText(Html.fromHtml("<b>REAL QUIZ PROGRAMACION 2<BR/>BRANDOX MEJIA</b>"));

        android.widget.Toast.makeText(this, "1a es: ", Toast.LENGTH_SHORT).show();

    }
}