package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TelaListaSimples extends AppCompatActivity {

    ListView listasimples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_simples);

        listasimples = (ListView) findViewById(R.id.ListViewListaSimples);

        String [] lista = new String[]{"Simples", "Comum", "Rara", "Limitada"};

        ArrayAdapter <String> listasimplesadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);

        listasimples.setAdapter(listasimplesadapter);
    }
}