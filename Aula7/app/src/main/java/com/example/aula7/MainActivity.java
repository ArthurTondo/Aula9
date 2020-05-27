package com.example.aula7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickAula7(View view) {
        Intent intent = new Intent(this, Exemplo.class);
        startActivity(intent);
    }

    public void onClickEx7(View view) {
        Intent intent = new Intent(this, Ex7.class);
        startActivity(intent);
    }
}
