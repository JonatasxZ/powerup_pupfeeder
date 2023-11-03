package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaSelecao extends AppCompatActivity {


    Button lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_selecao);

        lista = (Button) findViewById(R.id.buttonSelecaoLista);

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaSelecao.this, TelaListaSimples.class));
            }
        });
    }
}