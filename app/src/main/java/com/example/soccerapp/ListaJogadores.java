package com.example.soccerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListaJogadores extends AppCompatActivity {

    private ListView lvJogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogadores);

        lvJogadores = findViewById(R.id.lvJogadores);

        lvJogadores.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                excluir((Jogador) adapterView.getItemAtPosition(i));
                return false;
            }
        });

    }

    private void excluir(final Jogador nome){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Excluir Time");
        alerta.setMessage("Voce deseja excluir o jogador " + nome.getNome()+"?");
        alerta.setNeutralButton("Cancelar", null);
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                JogadorDAO.excluirJogador(ListaJogadores.this, nome.getId());
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
        List<Jogador> listaJogadores = JogadorDAO.getJogadores(this);

        if (listaJogadores.size()==0){
            lvJogadores.setEnabled(false);
            Jogador fake = new Jogador();
            fake.setApelido("");
            fake.setNome("Lista Vazia");
            listaJogadores.add(fake);

        }else{
            lvJogadores.setEnabled(true);
        }

        AdapterJogador adapterJogador = new AdapterJogador(this, listaJogadores);
        lvJogadores.setAdapter(adapterJogador);
    }
}


