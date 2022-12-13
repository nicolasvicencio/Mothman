package com.example.mothman.Models;

public class Historic {
    private String id;
    private String date;
    private String description;

    public Historic(String id, String date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }

    public Historic() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
