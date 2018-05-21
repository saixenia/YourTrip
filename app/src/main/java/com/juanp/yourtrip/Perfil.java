package com.juanp.yourtrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Perfil extends AppCompatActivity {
    ImageButton imgBtn_Mis_viajes,imgBtn_Explorar,imgBtn_Notificacion,imgBtn_Contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        imgBtn_Mis_viajes=findViewById(R.id.imgBtn_Mis_viajes);
        imgBtn_Explorar=findViewById(R.id.imgBtn_Explorar);
        imgBtn_Notificacion=findViewById(R.id.imgBtn_Notificacion);
        imgBtn_Contactos=findViewById(R.id.imgBtn_Contactos);
        imgBtn_Contactos.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                ir_perfil(view);
            }
        });
        imgBtn_Mis_viajes.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Mis_viajes(view);
            }
        });
        imgBtn_Explorar.setOnClickListener(new View.OnClickListener() {
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
