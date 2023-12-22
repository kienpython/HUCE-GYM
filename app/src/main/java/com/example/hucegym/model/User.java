package com.example.hucegym.model;

public class User {
    private String username;
    private String password;
    private String name;
    private int id_hv;

    public int getId_hv() {
        return id_hv;
    }

    public void setId_hv(int id_hv) {
        this.id_hv = id_hv;
    }

    public User(String username, String password, String name,int id_hv) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.id_hv = id_hv;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
