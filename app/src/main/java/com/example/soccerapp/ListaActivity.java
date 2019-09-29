package com.example.soccerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListaActivity extends AppCompatActivity {


    private ListView lvTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvTimes = findViewById(R.id.lvTimes);

        lvTimes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                excluir((Time)adapterView.getItemAtPosition(i));
                return false;
            }
        });


    }

    private void excluir(final Time nomeTime){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Excluir Time");
        alerta.setMessage("Voce deseja excluir o time " + nomeTime.getNomeTime()+"?");
        alerta.setNeutralButton("Cancelar", null);
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                TimeDAO.excluirTime(ListaActivity.this, nomeTime.getId());
            }
        });
        alerta.show();
        }

    @Override
    protected void onStart() {
        super.onStart();
        carregarLista();
    }

    private void carregarLista(){
        List<Time> listaTimes = TimeDAO.getTime(this);



        if (listaTimes.size()==0){
            lvTimes.setEnabled(false);
            Time fake = new Time();
            fake.setAnoFundacao("0");
            fake.setNomeTime("Lista Vazia");
            listaTimes.add(fake);

        }else{
            lvTimes.setEnabled(true);
        }

        AdapterTime adapterTime = new AdapterTime(this, listaTimes);
}
    }


