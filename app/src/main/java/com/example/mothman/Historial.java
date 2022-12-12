package com.example.mothman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Historial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
    }

    public void btnInclinacion(View v) {
        Intent i = new Intent(this, HistorialDetalles.class);
        //i.putExtra("miDato", etV1.getText().toString());
        startActivity(i);
    }

    public void btnCo2(View v) {
        Intent i = new Intent(this, HistorialDetalles.class);
        //i.putExtra("miDato", etV1.getText().toString());
        startActivity(i);
    }

    public void btnTemperatura(View v) {
        Intent i = new Intent(this, HistorialDetalles.class);
        //i.putExtra("miDato", etV1.getText().toString());
        startActivity(i);
    }

    public void volver (View v){
        finish();
        //comentario
    }
}