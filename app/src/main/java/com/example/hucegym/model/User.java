package com.example.hucegym.model;

public class User {
    private String username;
    private String password;
    private String chuc_vu;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getChuc_vu() {
        return chuc_vu;
    }
    public void setChuc_vu(String chuc_vu) {
        this.chuc_vu = chuc_vu;
    }
}

