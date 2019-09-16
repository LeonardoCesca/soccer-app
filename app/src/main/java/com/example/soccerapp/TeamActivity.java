package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.MenuItem;

public class TeamActivity extends AppCompatActivity {

    private EditText edtNomeTime, edtAnoFundacao;
    private Button btnSalvarTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        edtNomeTime = (EditText) findViewById(R.id.nomeTime);
        edtAnoFundacao = (EditText) findViewById(R.id.anoFundacao);
        btnSalvarTime = (Button) findViewById(R.id.salvarJogadorBtn);

        btnSalvarTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              salvar();
            }
        });


        }
    private void salvar(){
        String nomeTime = edtNomeTime.getText().toString();
        String anoFundacao = edtAnoFundacao.getText().toString();
    }
}
