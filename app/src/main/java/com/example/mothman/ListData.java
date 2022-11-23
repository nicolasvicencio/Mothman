package com.example.mothman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mothman.Controllers.SensorController;
import com.example.mothman.Models.Sensor;

import java.util.ArrayList;

public class ListData extends AppCompatActivity {
    private ListView sensorList;
    private ArrayList<String> sensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        SensorController.fillSensorList();
        AdapterSensor adapter = new AdapterSensor(this);

        sensorList = (ListView) findViewById(R.id.listViewData);
        sensorList.setAdapter(adapter);

        sensorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                detalleSensor(view);

                Toast.makeText(ListData.this, "Sensor: "+SensorController.findAll().get(i).getName(), Toast.LENGTH_SHORT);
            }
        });
    }

    public void detalleSensor(View v) {
        Intent i = new Intent(this, Login.class);
    }

    class AdapterSensor extends ArrayAdapter<Sensor>{
        AppCompatActivity appCompatActivity;

        public AdapterSensor(AppCompatActivity context){
            super(context, R.layout.sensor_layout, SensorController.findAll());
            appCompatActivity = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.sensor_layout, null);

            TextView tvSensorName = item.findViewById(R.id.tvSensorName);
            tvSensorName.setText(SensorController.findAll().get(position).getName());

            TextView tvSensorData = item.findViewById(R.id.tvSensorData);
            tvSensorData.setText(SensorController.findAll().get(position).getOutput());

            return item;
        }
    }
}





