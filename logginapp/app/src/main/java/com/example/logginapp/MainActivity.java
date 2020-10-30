package com.example.logginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.Arrays;

import static java.util.Collections.singletonList;


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
        final String uriString = "mongodb+srv://DDRC:C%40p0l1f3@apptest.3euu1.mongodb.net/Android?retryWrites=true&w=majority";
        MongoClient mongoClient = (MongoClient) MongoClients.create(uriString);
        MongoDatabase mongoDB = mongoClient.getDatabase("Android");
        MongoCollection<Document> collection = mongoDB.getCollection("login");
        Document canvas = new Document("item", "canvas")
                .append("qty", 100)
                .append("tags", singletonList("cotton"));
        Document size = new Document("h", 28)
                .append("w", 35.5)
                .append("uom", "cm");
        canvas.put("size", size);

        collection.insertOne(canvas);
        mongoClient.close();

        String UserText = etUser.getText().toString();
        String PswText = etPsw.getText().toString();
        if (UserText.length() == 0 && PswText.length() == 0) {
            Toast.makeText(this, "LLene todos los campos primero", Toast.LENGTH_SHORT).show();
        }

        if (PswText.length() != 0 && UserText.length() != 0 && UserText.equals("Daniel") && PswText.equals("1234") ) {
            Intent entrar= new Intent(this,entrance.class);
            entrar.putExtra("nombre",UserText);
            startActivity(entrar);
        } else {
            Toast.makeText(this, "Usuario o Contraseña Erroneos", Toast.LENGTH_SHORT).show();
        }
    }
    public void regiter(View view){
        Intent reg =new Intent(this,registro.class);
        startActivity(reg);
    }
}
