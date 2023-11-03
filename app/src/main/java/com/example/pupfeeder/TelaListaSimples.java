package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TelaListaSimples extends AppCompatActivity {

    ListView listasimples;

    Button novalista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_simples);

        listasimples = (ListView) findViewById(R.id.ListViewListaSimples);

        novalista = (Button) findViewById(R.id.buttonListaNova);

        novalista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaListaSimples.this, TelaCadastroListas.class));
            }
        });

        String [] lista = new String[]{"Simples", "Comum", "Rara", "Limitada"};

        ArrayAdapter <String> listasimplesadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);

        listasimples.setAdapter(listasimplesadapter);
    }
}