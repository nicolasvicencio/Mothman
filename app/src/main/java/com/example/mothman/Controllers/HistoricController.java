package com.example.mothman.Controllers;

import com.example.mothman.Models.Historic;
import com.example.mothman.Models.Sensor;

import java.util.ArrayList;

public class HistoricController {
    private static ArrayList<Historic> listHistoric = new ArrayList<>();

    public static String addHistoric(String id, String date,  String description){
        try{
            Historic historic = new Historic(id, date ,description);
            listHistoric.add(historic);
            return "Sensor agregado";
        }catch(Exception e){
            return "Error: "+e.getMessage();
        }
    }

    public static ArrayList<Historic> findAll()
    {
        return listHistoric;
    }

    public static void fillSensorList(String id, String date,  String description){
        addHistoric(id, date, description);
    }
}
