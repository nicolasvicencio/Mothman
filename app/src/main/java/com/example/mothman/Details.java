package com.example.mothman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    private TextView tvName;
    private TextView tvType;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvName = findViewById(R.id.tvName);
        tvType = findViewById(R.id.tvType);
        tvOutput = findViewById(R.id.tvOutput);

        Bundle bundle = getIntent().getExtras();

        tvName.setText(bundle.getString("sensorName"));
        tvType.setText(bundle.getString("sensorType"));
        tvOutput.setText(bundle.getString("sensorOutput"));
    }
    public void volver (View v){
        Intent i = new Intent(this, ListData.class);
        startActivity(i);
    }
}