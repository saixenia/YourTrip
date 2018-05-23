package com.juanp.yourtrip;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

    public static final String TABLE_USUARIOS = "usuarios";
    public static final String TABLE_VIAJES= "viajes";
    public static final String TABLE_CATEGORIA_VIAJES= "categoria_viajes";
    public static final String TABLE_SITIO_SUGERIDO= "sitio_sugerido";
    public static final String TABLE_COMENTARIOS= "comentarios";
    public static final String TABLE_CALIFICACION= "calificacion";
    public static final String TABLE_IMAGENES= "imagenes";
    public static final String TABLE_PAISES= "paises";

    public static final String DATABASE_NAME = "yourTrip.db";
    public static final int DATABASE_VERSION = 1;

    public static abstract class Usuarios implements BaseColumns {
        public static final String TABLE_NAME = "usuarios";
        public static final String COLUMN_NOMBRE = "usu_nombre";
        public static final String COLUMN_APELLIDO = "usu_apellido";
        public static final String COLUMN_EMAIL = "usu_email";
        public static final String COLUMN_CONTRASENA = "usu_contrase";
    }

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table usuarios (" +
                "id_usuario integer primary key," +
                "usu_nombre varchar(20)," +
                "usu_apellido varchar(20)," +
                "usu_email varchar(50)," +
                "usu_contrase varchar(50)"+")");

        database.execSQL("create table viajes (" +
                "id_viaje  integer primary key autoincrement," +
                "nom_viaje varchar(20)," +
                "fecha_viaje datetime"+")");

        database.execSQL("create table categoria_viajes (" +
                "id_categoria_viaje integer primary key autoincrement," +
                "descripcion varchar(50)"+")");

        database.execSQL("create table sitio_sugerido (" +
                "id_sitio integer primary key autoincrement," +
                "sit_sugerido_nom varchar(50)," +
                "sit_sugerido_lati numeric (20)," +
                "sit_sugerido_long numeric (20)"+")");

        database.execSQL("create table comentarios (" +
                "id_comentario integer primary key autoincrement," +
                "id_viaje integer," +
                "des_comentario varchar(50)"+")");

        database.execSQL("create table calificacion (" +
                "id_calificacion integer primary key autoincrement," +
                "id_sitio integer," +
                "val_calificacion varchar(50)"+")");

        database.execSQL("create table imagenes (" +
                "id_imagen integer primary key autoincrement," +
                "ruta_imagen varchar(50)"+")");

    /*    database.execSQL("create table paises (" +
                "id_pais integer primary key autoincrement," +
                "nom_pais varchar(50)"+")");
        database.execSQL("insert into  paises (id_pais,nom_pais)values(1,Colombia)");
        database.execSQL("insert into  paises (id_pais,nom_pais)values(2,Francia)");
        database.execSQL("insert into  paises (id_pais,nom_pais)values(3,USA)");
        database.execSQL("insert into  paises (id_pais,nom_pais)values(4,Mexico)");
        database.execSQL("insert into  paises (id_pais,nom_pais)values(5,Peru)");
        */
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
