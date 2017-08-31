package com.crcr.listagatos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.crcr.listagatos.pojo.Gato;

import java.util.ArrayList;

/**
 * Created by Criro on 29/08/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Aqui se define toda la composicion de las tablas
        String queryCrearTablaGato = "CREATE TABLE " + ConstantesBaseDatos.TABLE_CATS + "(" +
                                        ConstantesBaseDatos.TABLE_CATS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                        ConstantesBaseDatos.TABLE_CATS_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_CATS_FOTO + " INTEGER, " + ")";

        String queryCrearTablaLikesGato = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_CAT + "(" +
                                        ConstantesBaseDatos.TABLE_LIKES_CAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_LIKES_CAT_ID_CAT + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_LIKES_CAT_NUMERO_LIKES + " INTEGER, " +
                                        "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_CAT_ID_CAT + ") " +
                                        "REFERENCES " + ConstantesBaseDatos.TABLE_CATS + "("+ConstantesBaseDatos.TABLE_CATS_ID+")"+
                                        ")";

        db.execSQL(queryCrearTablaGato);
        db.execSQL(queryCrearTablaLikesGato);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_CATS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_CAT);
        onCreate(db);
    }

    public ArrayList<Gato> obtenerTodosLosGatos(){
        ArrayList<Gato> gatos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CATS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Gato gatoActual = new Gato();
            gatoActual.setId(registros.getInt(0));
            gatoActual.setNombre(registros.getString(1));
            gatoActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CAT_NUMERO_LIKES+") as likes"+
                                " FROM " + ConstantesBaseDatos.TABLE_LIKES_CAT +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CAT_ID_CAT + "=" + gatoActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
                if (registrosLikes.moveToNext()){
                    gatoActual.setPuntuacion(registrosLikes.getInt(0));
                }else{
                    gatoActual.setPuntuacion(0);
                }

            gatos.add(gatoActual);
        }

        db.close();

        return gatos;
    }

    public void insertarGato(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CATS,null, contentValues);
        db.close();
    }

    public void insertarLikeGato(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CAT, null, contentValues);
        db.close();
    }

    public int obtenerLikesGato(Gato gato){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CAT_NUMERO_LIKES+")" +
                        " FROM " + ConstantesBaseDatos.TABLE_LIKES_CAT +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CAT_ID_CAT + "="+gato.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }



}
