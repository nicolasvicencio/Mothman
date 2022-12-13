package com.example.mothman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mothman.Models.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Register extends AppCompatActivity {
    private EditText inputUsername, inputPassword, inputPassword2;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        inputPassword2 = findViewById(R.id.inputPassword2);
        startFirebase();
    }

    public void startFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void createNewUser(View v){
        User newUser = new User();
        String id = UUID.randomUUID().toString();
        newUser.setId(id);
        newUser.setUsername(inputUsername.getText().toString());
        newUser.setPassword(inputPassword.getText().toString());

        databaseReference.child("User").child(id).setValue(newUser);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}