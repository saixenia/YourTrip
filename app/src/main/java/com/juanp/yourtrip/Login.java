package com.juanp.yourtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*sharedpreferences para las sesiones
* */

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        }

        public void olvidoContrasena(View view){
        Intent Olvido_Contrasena = new Intent(this,OlvidoContrasena.class);
        startActivity(Olvido_Contrasena);
    }
    public void registrarNuevoUsuario(View view){
        Intent Registrar = new Intent(this,Registro.class);
        startActivity(Registrar);
    }
}

