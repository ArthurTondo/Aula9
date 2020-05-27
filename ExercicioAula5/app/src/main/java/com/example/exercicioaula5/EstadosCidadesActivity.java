package com.example.exercicioaula5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;


public class EstadosCidadesActivity extends AppCompatActivity {

    private TextView txtNome;
    private Spinner SpnUf;
    private ListView ListviewCidade;
    String[] uf = {"SP", "RS", "SC"};
    String[][] cidades={
    new String []{"São Paulo", "Santo André", "Jundiai"},
    new String[]{"Santa Cruz do Sul", "Porto Alegre", "Caxias do Sul"},
    new String [] {"Florianópolis", "Blumenau", "São José"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados_cidades);
        txtNome = findViewById(R.id.textNome);
        SpnUf = findViewById(R.id.spinnerUF);
        ListviewCidade = findViewById(R.id.ListCidades);

        Intent intent = getIntent();
        txtNome.setText(intent.getStringExtra("nome"));

        ArrayAdapter<CharSequence> adapterSpinner = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,uf);
        SpnUf.setAdapter(adapterSpinner);
        SpnUf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String Seleçao[] = getRow(position);
                ArrayAdapter<String> adapterListView=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, Arrays.asList(Seleçao));
                ListviewCidade.setAdapter(adapterListView);
            }

            private String[] getRow(int position) {
                String[] row = new String[cidades[position].length];
                for (int i=0;i<row.length;i++)
                    row[i]=cidades[position][i];
                return row;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}