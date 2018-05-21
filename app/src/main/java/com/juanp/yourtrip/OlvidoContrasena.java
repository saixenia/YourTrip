package com.juanp.yourtrip;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class OlvidoContrasena extends AppCompatActivity {

    EditText Txt_Email;
    ImageButton Img_Siguiente;
    private  final int duracionsplash=1500;
    public Cursor Usuario;

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

        Database Admin = new Database(this);
        SQLiteDatabase DB_YourTrip = Admin.getWritableDatabase();

        String Email = Txt_Email.getText().toString();

        Usuario = DB_YourTrip.rawQuery("SELECT usu_email,usu_contrase FROM usuarios WHERE usu_email='"+Email+"'", null);

        if (Usuario.moveToFirst()){
            String Usu_Email = String.valueOf(Usuario.getString(0));
            String Usu_Contra = Usuario.getString(1);
            if (Email.equals(Usu_Email)){
                Toast.makeText(OlvidoContrasena.this,Usu_Contra, Toast.LENGTH_SHORT).show();
                Txt_Email.setText("");
                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        Intent intent = new Intent(OlvidoContrasena.this,Login.class);
                        startActivity(intent);
                        finish();
                    }
                },duracionsplash);
            }
        }else{
            Toast.makeText(getBaseContext(),"Correo no registrado", Toast.LENGTH_LONG).show();
            Txt_Email.setText("");
        }

    }
}
