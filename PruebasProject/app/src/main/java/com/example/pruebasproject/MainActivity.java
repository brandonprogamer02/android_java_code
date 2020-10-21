package com.example.pruebasproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
    }
    public void onClickNext(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("data", text1.getText().toString());
        startActivity(intent);
    }

}