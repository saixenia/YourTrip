package com.juanp.yourtrip;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class Contact {
    public int id;
    public String nombre;
    public String apellido;
    public String email;
    public String contra;

    public Contact(int id) {
        this.id = id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }


    public int getId() {
        return id;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return nombre + " "+ apellido;
    }
    private SQLiteDatabase database;
    private Database dbHelper;

    public Contact(Context context) {
        dbHelper = new Database(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Contact createContact(int id,String name, String lastname, String address, String email, String pass) {
        ContentValues values = new ContentValues();
        values.put("id_usuario",getId());
        values.put("nom_us",getNombre());
        values.put("ape_us", getApellido());
        values.put("mail_us", getEmail());
        values.put("pas_us", getContra());
        long insertId = database.insert(Database.TABLE_USUARIOS, null,
                values);        String[] campos = {"ID, MES, CONSUMO"};
        Cursor cursor = database.query(Database.TABLE_USUARIOS,campos, id + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Contact newContact= cursorToContact(cursor);
        cursor.close();
        return newContact;
    }

    /*public void updateContact(long id, String name, String lastname, String address, String email, String pass) {
        ContentValues values = new ContentValues();
        values.put(Database.COLUMN_NAME, name);
        values.put(Database.COLUMN_LASTNAME, lastname);
        values.put(Database.COLUMN_ADDRESS, address);
        values.put(Database.COLUMN_EMAIL, email);
        values.put(Database.COLUMN_PHONE, pass);
        String where = "id=?";
        String[] whereargs = new String[]{String.valueOf(id)};
        long insertId = database.update(Database.TABLE_CONTACTS,
                values,where,whereargs );
        Cursor cursor = database.query(Database.TABLE_CONTACTS,
                allColumns, Database.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        cursor.close();

    }

    public void deleteContact(long id) {
        System.out.println("Contact deleted with id: " + id);
        database.delete(Database.TABLE_CONTACTS, Database.COLUMN_ID
                + " = " + id, null);
    }

    public List<Contact> getAll() {
        List<Contact> comments = new ArrayList<Contact>();

        Cursor cursor = database.query(Database.TABLE_CONTACTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact contact= cursorToContact(cursor);
            comments.add(contact);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return comments;
    }
*/
    private Contact cursorToContact(Cursor cursor) {
        Contact c = new Contact(null);
        c.id = cursor.getInt(0);
        c.name = cursor.getString(1);
        c.lastname = cursor.getString(2);
        c.email = cursor.getString(3);
        c.pass = cursor.getString(4);

        return c;
    }
}
