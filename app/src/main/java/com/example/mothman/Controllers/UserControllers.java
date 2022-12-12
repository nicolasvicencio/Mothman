package com.example.mothman.Controllers;

import com.example.mothman.Models.User;

import java.util.ArrayList;

public class UserControllers {
    private String id;
    private String username;
    private String password;
    private ArrayList<User> listUsers;

    public UserControllers(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public void addUser(String username, String password){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
