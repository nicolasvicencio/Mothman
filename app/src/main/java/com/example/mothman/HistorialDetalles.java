package com.example.mothman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mothman.Controllers.HistoricController;
import com.example.mothman.Models.Historic;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistorialDetalles extends AppCompatActivity {
    private ListView historicList;
    private TextView tvTipoHistorial;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_detalles);

        tvTipoHistorial = findViewById(R.id.tvTipoHistorial);
        Bundle bundle = getIntent().getExtras();
        tvTipoHistorial.setText(bundle.getString("miDato"));
        
        startFirebase();
        CargarHistorial();
    }

    public void startFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void CargarHistorial() {
        // Variable que capture el tipo de historial del text view
        String tituloHistorial = "";
        if (tvTipoHistorial.getText().equals("Historial Temblores")) {
            tituloHistorial = "Historic/inclinacion";
        }

        if (tvTipoHistorial.getText().equals("Historial Temperatura")) {
            tituloHistorial = "Historic/temperatura";
        }

        if (tvTipoHistorial.getText().equals("Historial CO2")) {
            tituloHistorial = "Historic/co2";
        }

        databaseReference.child(tituloHistorial).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot i : dataSnapshot.getChildren()) {
                    Historic h = i.getValue(Historic.class);

                    System.out.println("Detector de errores: ");

                    //HistoricController.fillSensorList(h.getId(), h.getDate(), h.getDescription());
                    HistoricController.fillSensorList(h.getId(), h.getDate(), h.getDescription());
                    AdapterHistoric adapter = new AdapterHistoric(HistorialDetalles.this);

                    historicList = (ListView) findViewById(R.id.listViewData);
                    historicList.setAdapter(adapter);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                throw error.toException();
            }
        });
    }

    class AdapterHistoric extends ArrayAdapter<Historic> {
        AppCompatActivity appCompatActivity;

        public AdapterHistoric(AppCompatActivity context){
            super(context, R.layout.historial_layout, HistoricController.findAll());
            appCompatActivity = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.historial_layout, null);

            TextView tvId = item.findViewById(R.id.tvId);
            tvId.setText(HistoricController.findAll().get(position).getId());

            TextView tvDate = item.findViewById(R.id.tvDate);
            tvDate.setText(HistoricController.findAll().get(position).getDate());

            TextView tvDescription = item.findViewById(R.id.tvDescription);
            tvDescription.setText(HistoricController.findAll().get(position).getDescription());

            return item;
        }
    }

    public void volver (View v){
        finish();
    }
}