package com.example.mothman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
    private String currentUsername;

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
                String type = SensorController.findAll().get(i).getType();
                String name = SensorController.findAll().get(i).getName();
                String output = SensorController.findAll().get(i).getOutput();
                sensorDetail(view, type, name, output);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.topbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.op1:
                Bundle bundle = getIntent().getExtras();
                currentUsername = bundle.getString("username");
                Intent i = new Intent(this, ModifyUser.class);
                i.putExtra("username", currentUsername );
                startActivity(i);
                break;
            case R.id.op2:
                Intent in = new Intent(this, MainActivity.class);
                startActivity(in);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sensorDetail(View v, String type, String name, String output) {
        Intent i = new Intent(this, Details.class);
        i.putExtra("sensorName", type);
        i.putExtra("sensorType", name);
        i.putExtra("sensorOutput", output);
        startActivity(i);
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

    public void verHistorial(View v) {
        Intent i = new Intent(this, Historial.class);
        //i.putExtra("miDato", etV1.getText().toString());
        startActivity(i);
    }

}





