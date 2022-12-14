package com.example.mothman.Controllers;

import android.util.Log;

import com.example.mothman.Models.Sensor;

import java.util.ArrayList;

public class SensorController {
    private static ArrayList<Sensor> listSensor = new ArrayList<>();

    public static String addSensor(String type, String name,  String output){
        if(listSensor.size() == 3) {return "";}
        try{
            Sensor sensor = new Sensor(type, name ,output);
            listSensor.add(sensor);
            return "Sensor agregado";
        }catch(Exception e){
            return "Error: "+e.getMessage();
        }
    }

    public static ArrayList<Sensor> findAll()
    {
        return listSensor;
    }
    
    public static void fillSensorList(){
        addSensor("DHT22", "Sensor de Tº y Humedad", "28º");
        addSensor("Inclinacion", "Sensor de inclinacion", "0º");
        addSensor("CO2", "Sensor de CO2", "400 ppm");
    }
}
