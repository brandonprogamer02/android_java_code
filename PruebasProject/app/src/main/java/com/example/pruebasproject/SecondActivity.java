package com.example.pruebasproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text2 = findViewById(R.id.text2);

        String data = getIntent().getStringExtra("data");
        text2.setText(data);
    }
    public void onClickVolver(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}