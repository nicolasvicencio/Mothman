package com.example.mothman.Models;

public class Sensor {
    private String type;
    private String name;
    private String output;


    public Sensor(String type, String name, String output) {
        this.type = type;
        this.name = name;
        this.output = output;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getOutput() {
        return output;
    }
    public void setOutput(String output) {
        this.output = output;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
