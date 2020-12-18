package com.example.test.ui.JoinUs;

public class JobsHelper {
    String name, email,phone, category;


    public JobsHelper() {
    }

    public JobsHelper(String name, String email, String phone, String category) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
