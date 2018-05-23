package com.juanp.yourtrip;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import static android.Manifest.permission.READ_CONTACTS;

public class Actividad extends AppCompatActivity {

    TextView textView2,textView;
    SearchView Sv_pais;
    Spinner   spinner;
    ImageButton imgBtn_Mis_viajes,imgBtn_Explorar,imgBtn_Notificacion,imgBtn_Contactos;
    FloatingActionButton ActBtn_adiciona;
    ListView lst_dynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        Sv_pais =findViewById(R.id.Sv_pais);
        spinner=findViewById(R.id.spinner);
        lst_dynamic=findViewById(R.id.lst_dynamic);
        imgBtn_Mis_viajes=findViewById(R.id.imgBtn_Mis_viajes);
        imgBtn_Explorar=findViewById(R.id.imgBtn_Explorar);
        imgBtn_Notificacion=findViewById(R.id.imgBtn_Notificacion);
        imgBtn_Contactos=findViewById(R.id.imgBtn_Contactos);
        ActBtn_adiciona=findViewById(R.id.ActBtn_adiciona);

        ActBtn_adiciona.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                inicio_Opcion_Viaje(view);
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
        imgBtn_Contactos.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                ir_perfil(view);
            }
        });

        Intent Email_Recibir = getIntent();
        String Email = Email_Recibir.getStringExtra("Email");


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


    public void inicio_Opcion_Viaje(View view){
        Intent Inicio_Opcion_Viaje = new Intent(this,Viaje.class);
        startActivity(Inicio_Opcion_Viaje);
    }


}
