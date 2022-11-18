package com.example.mothman.Models;

public class Sensor {
    private String type;
    private String name;
    private int hour;
    private String place;
    private String output;

    public Sensor(String type, int hour, String place, String output) {
        this.type = type;
        this.hour = hour;
        this.place = place;
        this.output = output;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getOutput() {
        return output;
    }
    public void setOutput(String output) {
        this.output = output;
    }
}
