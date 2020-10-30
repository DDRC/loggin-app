package com.example.logginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
// Base Stitch Packages
/*import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;

// Packages needed to interact with MongoDB and Stitch
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

// Necessary component for working with MongoDB Mobile
import com.mongodb.stitch.android.services.mongodb.local.LocalMongoDbService;*/

public class registro extends AppCompatActivity {
private EditText psw,confPsw,user;
    /*// Create the default Stitch Client
    final StitchAppClient client =
            Stitch.initializeDefaultAppClient("<APP ID>");

    // Create a Client for MongoDB Mobile (initializing MongoDB Mobile)
    final MongoClient mobileClient =
            client.getServiceClient(LocalMongoDbService.clientFactory);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        psw=(EditText)findViewById(R.id.pass);
        confPsw=(EditText)findViewById(R.id.passConfirm);
        user=(EditText)findViewById(R.id.user);
    }
    public void Registrar(View view){
        String usuario=user.getText().toString();
        String contraseña=psw.getText().toString();
        String confPass=confPsw.getText().toString();
        if (contraseña.length()==0 && confPass.length()==0 && usuario.length()==0) {
            Toast.makeText(this, "Todos los campos deben llenarse", Toast.LENGTH_SHORT).show();
        }else{
            if(contraseña.equals(confPass)){
                //aqui se llenan los datos en la base de mongodb
            }
        }
    }
    public void Cancelar(View view){
        Intent login =new Intent(this,MainActivity.class);
        startActivity(login);
    }
}