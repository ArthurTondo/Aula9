package com.example.exercicioaula5;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class Nomes extends ListActivity implements AdapterView.OnItemClickListener {
    private String [] nomes= {"Lamb Ari","Beto Neira","Brita Deira","Gil Ete","Astolfo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nomes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,nomes);
        setListAdapter(adapter);
        ListView listview = getListView();
        listview.setOnItemClickListener(this);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selecao = nomes[position];
        Intent intent = new Intent(this,EstadosCidadesActivity.class);
        intent.putExtra("nome",selecao);
        startActivity(intent);

    }
}
