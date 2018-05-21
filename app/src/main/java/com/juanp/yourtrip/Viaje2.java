package com.juanp.yourtrip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class Viaje2 extends AppCompatActivity {
    TextView textView4,textView5;
    Button Btn_empezar,Btn_Atras;
    Spinner sp_opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viaje2);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        Btn_empezar=findViewById(R.id.Btn_empezar);
        Btn_Atras=findViewById(R.id.Btn_Atras);
        sp_opciones=findViewById(R.id.sp_opciones);
    }
}