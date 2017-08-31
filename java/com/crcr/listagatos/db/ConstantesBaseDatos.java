package com.crcr.listagatos.db;

/**
 * Created by Criro on 29/08/2017.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "gatos";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CATS           = "gato";
    public static final String TABLE_CATS_ID        = "id";
    public static final String TABLE_CATS_NOMBRE    = "nombre";
    public static final String TABLE_CATS_FOTO      = "foto";

    public static final String TABLE_LIKES_CAT = "gato_likes";
    public static final String TABLE_LIKES_CAT_ID = "id";
    public static final String TABLE_LIKES_CAT_ID_CAT = "id_gato";
    public static final String TABLE_LIKES_CAT_NUMERO_LIKES = "numero_likes";
}
