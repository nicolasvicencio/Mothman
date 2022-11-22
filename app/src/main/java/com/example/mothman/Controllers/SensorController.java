package com.example.mothman.Controllers;

import com.example.mothman.Models.Sensor;

import java.util.ArrayList;

public class SensorController {
    private static ArrayList<Sensor> listSensor = new ArrayList<>();

    public static String addSensor(String type, String name,  String output){
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
        addSensor("DHT22", "Sensor de T y Humedad", "Dato de prueba");
        addSensor("Inclinacion", "Sensor de inclinacion", "Dato de prueba");
        addSensor("CO2", "Sensor de CO2", "Dato de prueba");
    }
    

    
    


}
