package com.example.logginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class entrance extends AppCompatActivity {
    private TextView saludos;
    private WebView navegador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        saludos=(TextView) findViewById(R.id.tv1);
        String Nombre=getIntent().getStringExtra("nombre");
        saludos.setText("Bienvenido " + Nombre);
        navegador=(WebView)findViewById(R.id.wv1);
        navegador.setWebViewClient(new WebViewClient());
        navegador.loadUrl("http://www.google.com");
    }
    public void Salir(View view){
        Intent salir= new Intent(this,MainActivity.class);
        startActivity(salir);

    }
}