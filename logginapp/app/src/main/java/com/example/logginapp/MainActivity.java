package com.example.logginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUser, etPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = (EditText) findViewById(R.id.user);
        etPsw = (EditText) findViewById(R.id.pass);
    }

    public void Ingreso(View view) {
        String UserText = etUser.getText().toString();
        String PswText = etPsw.getText().toString();
        if (UserText.length() == 0) {
            Toast.makeText(this, "Ingrese algo en el campo usuario", Toast.LENGTH_SHORT).show();
        }
        if (PswText.length() == 0) {
            Toast.makeText(this, "Ingrese algo en el campo Contraseña", Toast.LENGTH_SHORT).show();
        }

        if (PswText.length() != 0 && UserText.length() != 0 && UserText.equals("Daniel") && PswText.equals("1234") ) {
            Intent entrar= new Intent(this,entrance.class);
            entrar.putExtra("nombre",UserText);
            startActivity(entrar);
        } else {
            Toast.makeText(this, "Usuario o Contraseña Erroneos", Toast.LENGTH_SHORT).show();
        }
    }
}
