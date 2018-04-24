package com.juanp.yourtrip;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    public static final String TABLE_CONTACTS = "usuarios";
    public static final String COLUMN_ID = "id_usuario";
    public static final String COLUMN_NAME = "nombre";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_EMAIL = "email";

    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;
//puta
    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CONTACTS+ "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_NAME+ " text not null,"
            + COLUMN_LASTNAME+ " text not null,"
            + COLUMN_ADDRESS+ " text not null,"
            + COLUMN_EMAIL+ " text not null"
            + ");";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create table usuarios (id_usuario integer primary key autoincrement," +
                "nom_us varchar(20),ape_us varchar(20),mail varchar(50),contrasena varchar(50)"+")"
        );
        database.execSQL("create table viajes (id_viaje  integer primary key autoincrement," +
                "nom_viaje varchar(20),fecha_viaje datetime"+")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(Database.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }
}
