package com.example.soccerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Jogador> getJogadores(Context contexto){
        List<Jogador> listaJogadores = new ArrayList<>();
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM jogadores ORDER BY nome",null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Jogador jogador = new Jogador();
                jogador.setId(  cursor.getInt( 0 ) );
                jogador.setNome( cursor.getString( 1 ) );
                jogador.setApelido( cursor.getString( 1 ) );
                jogador.setNumeroCamiseta( cursor.getString(   1) );
                listaJogadores.add( jogador );
            } while ( cursor.moveToNext() );
        }
        return listaJogadores;
    }

    public static Jogador getJogadorId(Context contexto, int idJogador){
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getReadableDatabase();

        String sql = "SELECT * FROM jogadores WHERE id = " + idJogador;
        Cursor cursor = db.rawQuery( sql ,null);

        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            Jogador jogador = new Jogador();
            jogador.setId(  cursor.getInt( 0 ) );
            jogador.setNome( cursor.getString( 1 ) );
            jogador.setApelido( cursor.getString( 1 ) );
            jogador.setNumeroCamiseta( cursor.getString(   1 ) );

            return jogador;
        }else {
            return null;
        }
    }

}
