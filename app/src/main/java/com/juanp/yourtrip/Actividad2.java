package com.juanp.yourtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Actividad2 extends AppCompatActivity {
    ImageButton ImgBtn_Mis_viajes, ImgBtn_Explorar, ImgBtn_Notificacion, ImgBtn_Contactos;

    Intent Email_Recibir = getIntent();
    String Email_Actividad2 = Email_Recibir.getStringExtra("Email");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        ImgBtn_Mis_viajes = findViewById(R.id.ImgBtn_Mis_viajes);
        ImgBtn_Explorar = findViewById(R.id.ImgBtn_Explorar);
        ImgBtn_Notificacion = findViewById(R.id.ImgBtn_Notificacion);
        ImgBtn_Contactos = findViewById(R.id.ImgBtn_Contactos);

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
        Intent perfil = new Intent(this,Perfil.class);
        perfil.putExtra("Email", Email_Actividad2);
        startActivity(perfil);
    }
    private void sitios_Sugeridos(View view) {
        Intent sitios_Sugeridos = new Intent(this,Actividad2.class);
        sitios_Sugeridos.putExtra("Email",Email_Actividad2);
        startActivity(sitios_Sugeridos);
    }

    private void Mis_viajes(View view) {
        Intent Mis_viajes = new Intent(this,Actividad.class);
        Mis_viajes.putExtra("Email",Email_Actividad2);
        startActivity(Mis_viajes);
    }
}
