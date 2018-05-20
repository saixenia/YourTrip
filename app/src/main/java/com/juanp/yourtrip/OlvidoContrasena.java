package com.juanp.yourtrip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class OlvidoContrasena extends AppCompatActivity {

    EditText Txt_Email;
    ImageButton Img_Siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvido_contrasena);

        Txt_Email = findViewById(R.id.Txt_Email);
        Img_Siguiente = findViewById(R.id.Img_Siguiente);

        Img_Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                olvidoContraseña(view);
            }
        });
    }

    public void olvidoContraseña (View view) {

    }
}
