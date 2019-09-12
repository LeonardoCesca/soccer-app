package com.example.soccerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class JogadorDAO {

    public static void inserirJogador(Context contexto, Jogador jogador) {
        Banco banco = new Banco(contexto);
        SQLiteDatabase database = banco.getWritableDatabase();

        ContentValues valoresCampos = new ContentValues();
        valoresCampos.put("nome", jogador.getNome());
        valoresCampos.put("apelido", jogador.getApelido());
        valoresCampos.put("numCamiseta", jogador.getNumeroCamiseta());

        database.insert("jogadores", null, valoresCampos);
    }

    public static void editarJogador(Context contexto, Jogador jogador) {
        Banco banco = new Banco(contexto);
        SQLiteDatabase database = banco.getWritableDatabase();

        ContentValues valoresCampos = new ContentValues();
        valoresCampos.put("nome", jogador.getNome());
        valoresCampos.put("apelido", jogador.getApelido());
        valoresCampos.put("numCamiseta", jogador.getNumeroCamiseta());

        database.update("jogadores", valoresCampos, " id = " + jogador.getId(), null);
    }

    public static void excluirJogador(Context contexto, int idJogador){
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("jogadores", " id = " + idJogador,null);
    }

}
