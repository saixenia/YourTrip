package com.juanp.yourtrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

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

    }
    public void inicio_Opcion_Viaje(View view){
        Intent Inicio_Opcion_Viaje = new Intent(this,Viaje.class);
        startActivity(Inicio_Opcion_Viaje);
    }

}
