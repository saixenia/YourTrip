package com.juanp.yourtrip;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Perfil extends AppCompatActivity {

    EditText Txt_Nombres, Txt_Apellidos, Txt_Email, Txt_Contrasena;
    Button Btn_Guardar;
    ImageButton ImgBtn_Mis_viajes, ImgBtn_Explorar, ImgBtn_Notificacion, ImgBtn_Contactos;

    //Intent Email_Recibir = getIntent();
    //String Email_Perfil = Email_Recibir.getStringExtra("Email");

    private Cursor Usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Txt_Nombres = findViewById(R.id.Txt_Nombres);
        Txt_Apellidos = findViewById(R.id.Txt_Apellidos);
        Txt_Email = findViewById(R.id.Txt_Email);
        Txt_Contrasena = findViewById(R.id.Txt_Contrasena);

        Btn_Guardar = findViewById(R.id.Btn_Guardar);

        ImgBtn_Mis_viajes=findViewById(R.id.ImgBtn_Mis_viajes);
        ImgBtn_Explorar=findViewById(R.id.ImgBtn_Explorar);
        ImgBtn_Notificacion=findViewById(R.id.ImgBtn_Notificacion);
        ImgBtn_Contactos=findViewById(R.id.ImgBtn_Contactos);

        //Txt_Email.setEnabled(Boolean.FALSE);
        //this.cargarPerfil();

        ImgBtn_Contactos.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                ir_perfil(view);
            }
        });

        ImgBtn_Mis_viajes.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Mis_viajes(view);
            }
        });

        ImgBtn_Explorar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                sitios_Sugeridos(view);
            }
        });

        /*Btn_Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar(view);
            }
        });*/


    }
    private void ir_perfil(View view) {
        Intent Perfil = new Intent(this,Perfil.class);
        //Perfil.putExtra("Email", Email_Perfil);
        startActivity(Perfil);
    }
    private void sitios_Sugeridos(View view) {
        Intent sitios_Sugeridos = new Intent(this,Actividad2.class);
        //sitios_Sugeridos.putExtra("Email",Email_Perfil);
        startActivity(sitios_Sugeridos);
    }

    private void Mis_viajes(View view) {
        Intent Mis_viajes = new Intent(this,Actividad.class);
        //Mis_viajes.putExtra("Email",Email_Perfil);
        startActivity(Mis_viajes);
    }

    /*private void cargarPerfil () {
        Database Admin = new Database(this);
        SQLiteDatabase DB_YourTrip = Admin.getWritableDatabase();

        Usuario = DB_YourTrip.rawQuery("SELECT * FROM usuarios WHERE usu_email='"+Email_Perfil+"'", null);

        if (Usuario.moveToFirst()) {

            String Usu_nombre = Usuario.getString(1);
            String Usu_apellido = Usuario.getString(2);
            String Usu_Email = Usuario.getString(3);
            String Usu_Contra = Usuario.getString(4);

            Txt_Nombres.setText(Usu_nombre);
            Txt_Apellidos.setText(Usu_apellido);
            Txt_Email.setText(Usu_Email);
            Txt_Contrasena.setText(Usu_Contra);
        }

        DB_YourTrip.close();
    }*/

    /*private void actualizar (View view) {
        Database Admin = new Database(this);
        SQLiteDatabase DB_YourTrip = Admin.getWritableDatabase();

        ContentValues Datos = new ContentValues();

        Datos.put(Database.Usuarios.COLUMN_NOMBRE,Txt_Nombres.getText().toString());
        Datos.put(Database.Usuarios.COLUMN_APELLIDO,Txt_Apellidos.getText().toString());
        Datos.put(Database.Usuarios.COLUMN_CONTRASENA, Txt_Email.getText().toString());

        String Registro = Database.Usuarios.COLUMN_EMAIL + " LIKE " + Email_Perfil;

        int Count = DB_YourTrip.update("usuarios", Datos, Registro, null);

        DB_YourTrip.close();
    }*/
}
