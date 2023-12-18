package com.example.hucegym.model;

public class User {
    private String username;
    private String password;
    private String name;
    private String chuc_vu;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.chuc_vu = "Hội Viên";
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

    public String getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(String chuc_vu) {
        this.chuc_vu = chuc_vu;
    }
}
