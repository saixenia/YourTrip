package com.juanp.yourtrip;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*sharedpreferences para las sesiones
* */

public class Login extends AppCompatActivity {

    AutoCompleteTextView Txt_Email;
    EditText Txt_Contrasena;
    Button Btn_Ingresar;
    TextView Txt_Olvido_Contrasena, Txt_Registro;
    SharedPreferences sharedPreferences;
    public final static String SETTING_USER = "setting_user";
    public final static String SETTING_PASS = "setting_pass";

    public Cursor Usuario;

    Perfil Pf = new Perfil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Txt_Email = findViewById(R.id.Txt_Email);
        Txt_Contrasena = findViewById(R.id.Txt_Contrasena);
        Btn_Ingresar = findViewById(R.id.Btn_Ingresar);
        Txt_Olvido_Contrasena = findViewById(R.id.Txt_Olvido_Contrasena);
        Txt_Registro = findViewById(R.id.Txt_Registro);
        sharedPreferences = getApplicationContext().getSharedPreferences("com.juanp.yourtrip", Context.MODE_PRIVATE);
        Btn_Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicioSesion(view);
            }
        });

        Txt_Olvido_Contrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                olvidoContrasena(view);
            }
        });

        Txt_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarNuevoUsuario(view);
            }
        });
    }

        public void inicioSesion(View view) {
            Database Admin = new Database(this);
            SQLiteDatabase DB_YourTrip = Admin.getWritableDatabase();

            String Email = Txt_Email.getText().toString();
            String Contrasena = Txt_Contrasena.getText().toString();

            Usuario = DB_YourTrip.rawQuery("SELECT usu_email,usu_contrase FROM usuarios WHERE usu_email='"+Email+"' AND usu_contrase='"+Contrasena+"'", null);

            if (Usuario.moveToFirst()){
                String Usu_Email = String.valueOf(Usuario.getString(0));
                String Usu_Contra = Usuario.getString(1);
                if (Email.equals(Usu_Email) && Contrasena.equals(Usu_Contra)){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(SETTING_USER, Usu_Email);
                    editor.putString(SETTING_PASS, Usu_Contra);

                    editor.commit();
                    Txt_Email.setText("");
                    Txt_Contrasena.setText("");
                    Intent Actividad = new Intent(Login.this,Actividad.class);
                    startActivity(Actividad);
                }
            }else{
                Txt_Email.setText("");
                Txt_Contrasena.setText("");
                Toast.makeText(getBaseContext(), "Credenciales invalidas",Toast.LENGTH_LONG).show();
            }
        }

        public void olvidoContrasena(View view){
        Intent Olvido_Contrasena = new Intent(this,OlvidoContrasena.class);
        startActivity(Olvido_Contrasena);
    }

        public void registrarNuevoUsuario(View view){
        Intent Registrar = new Intent(this,Registro.class);
        startActivity(Registrar);
    }

    public void cargarDatos(View view) {
        Database Admin = new Database(this);
        SQLiteDatabase DB_YourTrip = Admin.getWritableDatabase();

        String Email = Txt_Email.getText().toString();

        Usuario = DB_YourTrip.rawQuery("SELECT * FROM usuarios WHERE usu_email='" + Email + '"', null);

        if (Usuario.moveToFirst()) {
            String Usu_Nombre = String.valueOf(Usuario.getString(1));
            String Usu_Apellido = String.valueOf(Usuario.getString(2));
            String Usu_Email = String.valueOf(Usuario.getString(3));
            String Usu_Contrasena = String.valueOf(Usuario.getString(4));

            Pf.Txt_Nombres.setText(Usu_Nombre);
            Pf.Txt_Apellidos.setText(Usu_Apellido);
            Pf.Txt_Email.setText(Usu_Email);
            Pf.Txt_Contrasena.setText(Usu_Contrasena);

        }
    }
}

