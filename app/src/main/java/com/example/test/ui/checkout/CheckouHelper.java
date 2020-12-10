package com.example.test.ui.checkout;

public class CheckouHelper {
    String name,number,email,date,service;

    public CheckouHelper() {
    }

    public CheckouHelper(String name, String number, String email, String date, String service) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.date = date;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
