package com.example.mothman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
    }

    public void enviar(View v){

        if ("root".equals(etUsuario.getText().toString()) && "root".equals(etContrasena.getText().toString())) {
            Intent i = new Intent(this, ListData.class);

            //i.putExtra("miDato", etV1.getText().toString());

            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(),"El usuario o contraseña no son válidos", Toast.LENGTH_SHORT).show();
        }
    }
}