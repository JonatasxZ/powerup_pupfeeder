package com.example.pupfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaCadastroListas extends AppCompatActivity {

    DatabaseHelper helper;

    EditText raridade;
    EditText quantidade;
    Spinner tipo;
    Spinner tamanho;

    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_listas);

        raridade = findViewById(R.id.editTextTelaCadastroListaRaridade);
        quantidade = findViewById(R.id.editTextTelaCadastroListaQuantidade);
        tipo = findViewById(R.id.spinnerTelaCadastroListaTipo);
        tamanho = findViewById(R.id.spinnerTelaCadastroListaTamanho);
        salvar = findViewById(R.id.buttonTelaCadastroListaSalvar);
        helper = new DatabaseHelper(this);

        raridade.setText("");
        quantidade.setText("");

        salvar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarLista(view);
            }
        }));
    }

    public void salvarLista(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        if(raridade.getText().length() > 0 && quantidade.getText().length() > 0){
            valores.put("raridade", raridade.getText().toString());
            valores.put("quantidade", quantidade.getText().toString());
            valores.put("tipo", tipo.getSelectedItem().toString());
            valores.put("tamanho", tamanho.getSelectedItem().toString());

            long resultado = db.insert("listas",null, valores);

            if (resultado != -1) {
                Toast.makeText(this, getString(R.string.activity_tela_cadastro_lista_salvo_com_sucesso), Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, getString(R.string.activity_tela_cadastro_lista_erro_ao_salvar), Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, getString(R.string.activity_tela_cadastro_lista_campos_vazios), Toast.LENGTH_SHORT).show();
        }
    }
}