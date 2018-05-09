package com.juanp.yourtrip;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    public static final String TABLE_USUARIOS = "usuarios";
    public static final String TABLE_VIAJES= "viajes";
    public static final String TABLE_CATEGORIA_VIAJES= "categoria_viajes";
    public static final String TABLE_SITIO_SUGERIDO= "sitio_sugerido";
    public static final String TABLE_COMENTARIOS= "comentarios";
    public static final String TABLE_CALIFICACION= "calificacion";
    public static final String TABLE_IMAGENES= "imagenes";
    public static final String DATABASE_NAME = "yourTrip.db";
    public static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table usuarios (id_usuario integer primary key autoincrement,nom_us varchar(20),ape_us varchar(20),mail_us varchar(50),pas_us varchar(50)"+")");
        database.execSQL("create table viajes (id_viaje  integer primary key autoincrement," +
                "nom_viaje varchar(20),fecha_viaje datetime"+")"
        );
        database.execSQL("create table categoria_viajes (id_categoria_viaje   integer primary key autoincrement," +
                "descripcion varchar(50)"+")"
        );
        database.execSQL("create table sitio_sugerido (id_sitio integer primary key autoincrement," +
                "nom_sit_sugerido varchar(50),"+"lat_sit_sugerido numeric (20),lon_sit_sugerido numeric (20)"+")"
        );
        database.execSQL("create table comentarios (id_comentario integer primary key autoincrement," +
                "des_comentario  varchar(50)"+")"
        );
        database.execSQL("create table calificacion (id_comentario integer primary key autoincrement," +
                "des_comentario  varchar(50)"+")"
        );
        database.execSQL("create table calificacion (id_calificacion integer primary key autoincrement," +
                "val_calificacion  varchar(50)"+")"
        );
        database.execSQL("create table imagenes (id_imagen integer primary key autoincrement," +
                "ruta_imagen varchar(50)"+")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(Database.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIAJES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIA_VIAJES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITIO_SUGERIDO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMENTARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALIFICACION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGENES);
        onCreate(db);
    }
}
