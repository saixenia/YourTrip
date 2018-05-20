package com.juanp.yourtrip;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

//poui

public class Registro extends AppCompatActivity {

    EditText Txt_Identificacion, Txt_Nombres, Txt_Apellidos, Txt_Email, Txt_Contrasena;
    ImageButton Img_Siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Txt_Identificacion = findViewById(R.id.Txt_Identificacion);
        Txt_Nombres = findViewById(R.id.Txt_Nombres);
        Txt_Apellidos =  findViewById(R.id.Txt_Apellidos);
        Txt_Email = findViewById(R.id.Txt_Email);
        Txt_Contrasena = findViewById(R.id.Txt_Contrasena);
        Img_Siguiente = findViewById(R.id.Img_Siguiente);

        Img_Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resgistro(view);
            }
        });
    }



    private void resgistro(View view) {

        Database Admin = new Database(this);
        SQLiteDatabase DB_YourTrip = Admin.getWritableDatabase();

        Txt_Identificacion.setError(null);
        Txt_Nombres.setError(null);
        Txt_Apellidos.setError(null);
        Txt_Email.setError(null);
        Txt_Contrasena.setError(null);

        int id_usuario = Integer.parseInt(String.valueOf(Txt_Identificacion.getText()));
        String usu_nombre = Txt_Nombres.getText().toString();
        String usu_apellido = Txt_Apellidos.getText().toString();
        String usu_email = Txt_Email.getText().toString();
        String usu_contrase = Txt_Contrasena.getText().toString();

        boolean cancel = false;
        View focusView = null;

        ContentValues Values = new ContentValues();
        Values.put("id_usuario", id_usuario);
        Values.put("usu_nombre", usu_nombre);
        Values.put("usu_apellido", usu_apellido);
        Values.put("usu_email", usu_email);
        Values.put("usu_contrase", usu_contrase);

        DB_YourTrip.insert("usuarios", null, Values);
        DB_YourTrip.close();

        if (!TextUtils.isEmpty(usu_contrase) && !isPasswordValid(usu_contrase)) {
            Txt_Contrasena.setError(getString(R.string.error_invalido_contraseña));
            focusView = Txt_Contrasena;
            cancel = true;
        }

        if (TextUtils.isEmpty(usu_email)) {
            Txt_Email.setError(getString(R.string.error_campo_requerido));
            focusView = Txt_Email;
            cancel = true;
        } else if (!isEmailValid(usu_email)) {
            Txt_Email.setError(getString(R.string.error_invalido_correo));
            focusView = Txt_Email;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        }

        Intent Main = new Intent(Registro.this, Login.class);
        Registro.this.startActivity(Main);
    }

    public boolean isEmailValid(String usu_email) {
        return usu_email.contains("@");
    }

    public boolean isPasswordValid(String usu_contrase) {
        //TODO: Replace this with your own logic
        return usu_contrase.length() > 4;
    }

}
