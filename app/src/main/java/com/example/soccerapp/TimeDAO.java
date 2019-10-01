package com.example.soccerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TimeDAO {

    public static void inserirTime(Context contexto, Time time) {
        Banco banco = new Banco(contexto);
        SQLiteDatabase database = banco.getWritableDatabase();

        ContentValues valoresCampos = new ContentValues();
        valoresCampos.put("nomeTime", time.getNomeTime());
        valoresCampos.put("anoFundacao", time.getAnoFundacao());

        database.insert("times", null, valoresCampos);
    }

    public static void editarTime(Context contexto, Time time) {
        Banco banco = new Banco(contexto);
        SQLiteDatabase database = banco.getWritableDatabase();

        ContentValues valoresCampos = new ContentValues();
        valoresCampos.put("nomeTime", time.getNomeTime());
        valoresCampos.put("anoFundacao", time.getAnoFundacao());


        database.update("times", valoresCampos, " id = " + time.getId(), null);
    }

    public static void excluirTime(Context contexto, int idTime){
        Banco banco = new Banco(contexto);
        SQLiteDatabase database = banco.getWritableDatabase();
        database.delete("times", " id = " + idTime,null);
    }

    public static List<Time> getTime(Context contexto){
        List<Time> listaTime = new ArrayList<>();
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM times ORDER BY nomeTime",null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Time time = new Time();
                time.setId(  cursor.getInt( 0 ) );
                time.setNomeTime( cursor.getString( 1 ) );
                time.setAnoFundacao( cursor.getString( 2 ) );
                listaTime.add( time );
            } while ( cursor.moveToNext() );
        }
        return listaTime;
    }

    public static Time getTimeId(Context contexto, int idTime){
        Banco banco = new Banco(contexto);
        SQLiteDatabase database = banco.getReadableDatabase();

        String sql = "SELECT * FROM times WHERE id = " + idTime;
        Cursor cursor = database.rawQuery( sql ,null);

        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            Time time = new Time();
            time.setId(  cursor.getInt( 0 ) );
            time.setNomeTime( cursor.getString( 1 ) );
            time.setAnoFundacao( cursor.getString( 1 ) );

            return time;
        }else {
            return null;
        }
    }
}
