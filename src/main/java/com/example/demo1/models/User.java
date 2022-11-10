package com.example.demo1.models;

public class User {
    int id;
    String fname;
    String lname;
    String login;
    String password;

    public User(int id, String fname, String lname, String login, String password){
        this.id = id;
        this.login= login;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
