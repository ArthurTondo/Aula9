package com.example.aula6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    String [] nameColors = {"Preto", "Gris", "Cinza"};
    String [] colors = {"#000000", "#444444", "#888888"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = new MeuArrayAdapter(this, android.R.layout.simple_spinner_item, nameColors);
        spinner.setAdapter(adapter);
    }

    private class MeuArrayAdapter extends ArrayAdapter {


        int resources;


        public MeuArrayAdapter(Context c, int item, String[] nameColors) {
            super(c, item, nameColors);
            resources = item;

        }

        private View CustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(resources, parent, false);

            TextView tv = view.findViewById(android.R.id.text1);
            tv.setText(nameColors[position]);
            tv.setTextColor(Color.WHITE);
            view.setBackgroundColor(Color.parseColor(colors[position]));
            return view;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return CustomView(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return CustomView(position, convertView, parent);
        }
    }
}
