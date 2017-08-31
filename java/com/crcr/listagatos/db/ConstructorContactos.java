package com.crcr.listagatos.db;

import android.content.ContentValues;
import android.content.Context;

import com.crcr.listagatos.R;
import com.crcr.listagatos.pojo.Gato;

import java.util.ArrayList;

/**
 * Created by Criro on 29/08/2017.
 */

public class ConstructorContactos {

    private Context context;
    private static final int LIKE = 1;

    public ConstructorContactos(Context context){
        this.context = context;
    }

    public ArrayList<Gato> obtenerDatos(){
        /*
        ArrayList<Gato> gatos= new ArrayList<Gato>();
        gatos.add(new Gato(R.drawable.onegatosomali,"Gato Somali","3"));
        gatos.add(new Gato(R.drawable.twogatohimalayo,"Gato Himalayo","4"));
        gatos.add(new Gato(R.drawable.threecymric,"Cymric","2"));
        gatos.add(new Gato(R.drawable.foursnowshoe,"Snowshoe","5"));
        gatos.add(new Gato(R.drawable.fivegatopersa,"Gato Persa","4"));
        return gatos;
        */

        BaseDatos db = new BaseDatos(context);
        return db.obtenerTodosLosGatos();
    }

    public void insertarTresGatos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CATS_NOMBRE, "Gato Somali");
        contentValues.put(ConstantesBaseDatos.TABLE_CATS_FOTO, R.drawable.onegatosomali);

        db.insertarGato(contentValues);

        ContentValues contentValues2 = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CATS_NOMBRE, "Gato Himalayo");
        contentValues.put(ConstantesBaseDatos.TABLE_CATS_FOTO, R.drawable.twogatohimalayo);

        db.insertarGato(contentValues2);

        ContentValues contentValues3 = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CATS_NOMBRE, "Cymric");
        contentValues.put(ConstantesBaseDatos.TABLE_CATS_FOTO, R.drawable.threecymric);

        db.insertarGato(contentValues3);
    }

    public void darLikeGato(Gato gato){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CAT_ID_CAT, gato.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CAT_NUMERO_LIKES, LIKE);
        db.insertarLikeGato(contentValues);
    }

    public int obtenerLikesGato(Gato gato){
            BaseDatos db = new BaseDatos(context);
            return db.obtenerLikesGato(gato);
    }
}
