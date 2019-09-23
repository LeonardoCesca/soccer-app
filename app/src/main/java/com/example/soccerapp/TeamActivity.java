package com.example.soccerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.MenuItem;

public class  TeamActivity extends AppCompatActivity {

    private EditText edtNomeTime, edtAnoFundacao;
    private Button btnSalvarTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        edtNomeTime = (EditText) findViewById(R.id.nomeTime);
        edtAnoFundacao = (EditText) findViewById(R.id.anoFundacao);
        btnSalvarTime = (Button) findViewById(R.id.salvarTimeBtn);

        btnSalvarTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              salvarTime();
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }
    private void salvarTime(){
        String nomeTime = edtNomeTime.getText().toString();
        String anoFundacao = edtAnoFundacao.getText().toString();

        Time time = new Time();
        time.setNomeTime(nomeTime);
        time.setAnoFundacao(anoFundacao);

        TimeDAO.inserirTime(this, time);

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
