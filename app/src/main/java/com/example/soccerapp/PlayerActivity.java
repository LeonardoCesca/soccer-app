package com.example.soccerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerActivity extends AppCompatActivity {

    private EditText edtNome, edtApelido, edtNumCamiseta;
    private Button btnSalvarJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        edtNome = (EditText) findViewById(R.id.nomeJogador);
        edtApelido = (EditText) findViewById(R.id.apelidoJogador);
        edtNumCamiseta = (EditText) findViewById(R.id.numeroCamiseta);
        btnSalvarJogador = (Button) findViewById(R.id.salvarJogadorBtn);

        btnSalvarJogador.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        //Botão de voltar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void salvar() {
        String nomeJogador = edtNome.getText().toString();
        String apelidoJogador = edtApelido.getText().toString();
        String numCamiseta = edtNumCamiseta.getText().toString();

        Jogador jogador = new Jogador();
        jogador.setNome(nomeJogador);
        jogador.setApelido(apelidoJogador);
        jogador.setNumeroCamiseta(numCamiseta);

        JogadorDAO.inserirJogador(this, jogador);

        this.finish();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
