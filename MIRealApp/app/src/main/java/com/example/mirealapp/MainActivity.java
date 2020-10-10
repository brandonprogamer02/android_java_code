package com.example.mirealapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView mensage;
    private int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = findViewById(R.id.button);
        mensage = findViewById(R.id.textView3);

        contador  = 1;
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String texto = String.format("EL CONTADOR ESTA EN: %S",contador);
                    mensage.setText(texto);
                    contador++;
            }
        });
    }
}