package com.example.mothman.Services;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBConnection {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public void startFirebase(Context c) {
        FirebaseApp.initializeApp(c);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }
}
