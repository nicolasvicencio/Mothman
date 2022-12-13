package com.example.mothman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mothman.Models.Historic;
import com.example.mothman.Models.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HistorialDetalles extends AppCompatActivity {
    private TextView tvTipoHistorial;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_detalles);

        startFirebase();
        CargarHistorial();

        tvTipoHistorial = findViewById(R.id.tvTipoHistorial);
    }

    public void startFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void CargarHistorial() {

        // Variable que capture el tipo de historial del text view
        databaseReference.child("Historic/inclinacion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    Historic h = i.getValue(Historic.class);

                    Toast.makeText(HistorialDetalles.this, h.getId(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(HistorialDetalles.this, h.getDate(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(HistorialDetalles.this, h.getDescription(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });
    }

    public void volver (View v){
        finish();
    }
}