package com.example.mothman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mothman.Models.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class ModifyUser extends AppCompatActivity {
    private EditText currentPassword, newPassword, newPassword2;
    private String currentUsername;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);

        startFirebase();
        Bundle bundle = getIntent().getExtras();
        currentUsername = bundle.getString("username");
        currentPassword = findViewById(R.id.inputCurrentPassword);
        newPassword = findViewById(R.id.inputNewPassword);
        newPassword2 = findViewById(R.id.inputNewPassword2);

    }


    public void modifyPassword(View v){
        if(!newPassword.getText().toString().equals(newPassword2.getText().toString())){
            Toast.makeText(ModifyUser.this, "Las contraseñas no coinciden, por favor intente nuevamente", Toast.LENGTH_SHORT).show();
            return;
        }
        if(newPassword.getText().toString().length() == 0 || newPassword2.getText().toString().length() == 0 || currentPassword.getText().toString().length() == 0){
            Toast.makeText(ModifyUser.this, "Debe ingresar todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        databaseReference.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot el : snapshot.getChildren()) {
                    User user = el.getValue(User.class);
                    if(user.getUsername().equals(currentUsername)){
                        if(! user.getPassword().equals(currentPassword.getText().toString())){
                            Toast.makeText(ModifyUser.this, "Contraseña incorrecta para el usuario " + currentUsername, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(user.getPassword().equals(newPassword.getText().toString())){
                            Toast.makeText(ModifyUser.this, "La contraseña que ingresaste no puede ser igual a la anterior", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Map<String, Object> userMap = new HashMap<>();
                        userMap.put("password", newPassword.getText().toString());
                        userMap.put("id", user.getId());
                        userMap.put("username", user.getUsername());
                        databaseReference.child("User").child(user.getId()).updateChildren(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(ModifyUser.this, "Contraseña modificada exitosamente!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(ModifyUser.this, MainActivity.class);
                                startActivity(i);
                                return;
                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ModifyUser.this, error.toString(), Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }

    public void startFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void goBack(View v){
        Intent i = new Intent(this, ListData.class);
        startActivity(i);
    }
}