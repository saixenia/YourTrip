package com.juanp.yourtrip;

import android.Manifest;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Viaje3 extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;
    Button Btn_atras;
    TextView Titulo;
    GridView Gv_dynamic;
    ImageButton imgBtn_Cam,imgBtn_Avion,imgBtn_Mis_viajes;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viaje3);
        imgBtn_Mis_viajes=findViewById(R.id.imgBtn_Mis_viajes);
        Btn_atras=findViewById(R.id.Btn_atras);
        imageView=findViewById(R.id.imageView);
        Titulo=findViewById(R.id.Titulo);
        Gv_dynamic=findViewById(R.id.Gv_dynamic);
        imgBtn_Cam=findViewById(R.id.imgBtn_Cam);
        imgBtn_Avion=findViewById(R.id.imgBtn_Avion);
        editText=findViewById(R.id.editText);


        imgBtn_Mis_viajes.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Mis_viajes(view);
            }
        });

        Titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = editText.getText().toString();
                Titulo.setText(titulo);
                Titulo.setTextColor(R.color.black);
                Titulo.setEnabled(false);
            }
        });
      /*  imgBtn_Cam.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });*/
    }

    private void Mis_viajes(View view) {
        Intent Mis_viajes = new Intent(this,Actividad.class);
        startActivity(Mis_viajes);
    }


}
