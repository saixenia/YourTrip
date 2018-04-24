package com.juanp.yourtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

//poui

public class Registro extends AppCompatActivity {
    private EditText txtnombre;
    private EditText txtapellidos;
    private EditText txtemail;
    private EditText txtcontrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtnombre= (EditText) findViewById(R.id.Txt_nombre);
        txtapellidos= (EditText) findViewById(R.id.Txt_apellidos);
        txtemail= (EditText) findViewById(R.id.Txt_Email);
        txtcontrasena= (EditText) findViewById(R.id.Txt_contraseña);
    }
    public void registrarNuevoUsuario(View view){
        attemptLogin();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
    private void attemptLogin() {

        // Reset errors.
        txtemail.setError(null);
        txtcontrasena.setError(null);

        // Store values at the time of the login attempt.
        String email = txtemail.getText().toString();
        String password = txtcontrasena.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            txtcontrasena.setError(getString(R.string.error_invalido_contraseña));
            focusView = txtcontrasena;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            txtemail.setError(getString(R.string.error_campo_requerido));
            focusView = txtemail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            txtemail.setError(getString(R.string.error_invalido_correo));
            focusView = txtemail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }
    }
    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
}
