package com.juanp.yourtrip;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.juanp.yourtrip.Login;

public class Perfil extends AppCompatActivity {

    EditText Txt_Nombres, Txt_Apellidos, Txt_Email, Txt_Contrasena;
    Button Btn_Guardar;
    ImageButton ImgBtn_Mis_viajes, ImgBtn_Explorar, ImgBtn_Notificacion, ImgBtn_Contactos;

    private Cursor Usuario;

    Login Lg = new Login();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Txt_Nombres = findViewById(R.id.Txt_Nombres);
        Txt_Apellidos = findViewById(R.id.Txt_Apellidos);
        Txt_Email = findViewById(R.id.Txt_Email);
        Txt_Contrasena = findViewById(R.id.Txt_Contrasena);

        ImgBtn_Mis_viajes=findViewById(R.id.ImgBtn_Mis_viajes);
        ImgBtn_Explorar=findViewById(R.id.ImgBtn_Explorar);
        ImgBtn_Notificacion=findViewById(R.id.ImgBtn_Notificacion);
        ImgBtn_Contactos=findViewById(R.id.ImgBtn_Contactos);

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
    }
    private void ir_perfil(View view) {
        Intent sitios_Sugeridos = new Intent(this,Perfil.class);
        startActivity(sitios_Sugeridos);
    }
    private void sitios_Sugeridos(View view) {
        Intent sitios_Sugeridos = new Intent(this,Actividad2.class);
        startActivity(sitios_Sugeridos);
    }

    private void Mis_viajes(View view) {
        Intent Mis_viajes = new Intent(this,Actividad.class);
        startActivity(Mis_viajes);
    }

}
