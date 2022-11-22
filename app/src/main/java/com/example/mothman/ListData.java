package com.example.mothman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mothman.Controllers.SensorController;

import java.util.ArrayList;

public class ListData extends AppCompatActivity {
    private ListView sensorList;
    private ArrayList<String> sensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        SensorController.fillSensorList();
        sensorList = (ListView) findViewById(R.id.listViewData);
    }

    

}





