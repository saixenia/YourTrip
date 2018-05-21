package com.juanp.yourtrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Viaje extends AppCompatActivity {
    Button Btn_Viaje,Btn_escapada,Btn_Vcotidiana,Btn_Familia,Btn_Bebe,Btn_Mascota,Btn_OViaje;
    TextView textView3,textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viaje);
        Btn_Viaje=findViewById(R.id.Btn_Viaje);
        Btn_escapada=findViewById(R.id.Btn_escapada);
        Btn_Vcotidiana=findViewById(R.id.Btn_Vcotidiana);
        Btn_Familia=findViewById(R.id.Btn_Familia);
        Btn_Bebe=findViewById(R.id.Btn_Bebe);
        Btn_Mascota=findViewById(R.id.Btn_Mascota);
        Btn_OViaje=findViewById(R.id.Btn_OViaje);
        textView3=findViewById(R.id.textView3);
        textView=findViewById(R.id.textView);

        Btn_Viaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioViaje(view);
            }
        });
        Btn_escapada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioViaje(view);
            }
        });
        Btn_Vcotidiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioHistoriaViaje(view);
            }
        });
        Btn_Familia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioViaje(view);
            }
        });
        Btn_Bebe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioHistoriaViaje(view);
            }
        });
        Btn_Mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioHistoriaViaje(view);
            }
        });
        Btn_OViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioHistoriaViaje(view);
            }
        });
    }
    public void inicioViaje(View view){
        Intent Inicio_Viaje = new Intent(this,Viaje2.class);
        startActivity(Inicio_Viaje);
    }
    public void inicioHistoriaViaje(View view){
        Intent Inicio_Historia_Viaje = new Intent(this,Viaje3.class);
        startActivity(Inicio_Historia_Viaje);
    }
}
