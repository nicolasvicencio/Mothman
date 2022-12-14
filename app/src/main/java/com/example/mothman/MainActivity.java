package com.example.mothman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mothman.Models.User;
import com.example.mothman.Services.FBConnection;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etContrasena;
    private String dbUsername;
    private String dbPassword;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFirebase();
        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
    }

    public void startFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void enviar(View v){
        databaseReference.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    for (DataSnapshot el : snapshot.getChildren()) {
                        User user = el.getValue(User.class);
                        if (user.getUsername().equals(etUsuario.getText().toString())) {
                            if (user.getPassword().equals(etContrasena.getText().toString())) {
                                Intent i = new Intent(MainActivity.this, ListData.class);
                                i.putExtra("username", user.getUsername());
                                startActivity(i);
                                return;
                            }else {
                                Toast.makeText(MainActivity.this, "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                                etUsuario.setText("");
                                etContrasena.setText("");
                                return;
                            }
                        }
                    }
                }catch (Exception e) {

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
               throw error.toException();
            }
        });

        //if ("root".equals(etUsuario.getText().toString()) && "root".equals(etContrasena.getText().toString())) {
          //  Intent i = new Intent(this, ListData.class);

            //i.putExtra("miDato", etV1.getText().toString());

          //  startActivity(i);
       // } else {
      //      Toast.makeText(getApplicationContext(),"El usuario o contraseña no son válidos", Toast.LENGTH_SHORT).show();
      //  }

    }

    public void register(View v){
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }


}