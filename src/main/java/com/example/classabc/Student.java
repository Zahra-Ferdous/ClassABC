package com.example.classabc;

public class Student {

    String name , roll , email , password;

    public Student(String name, String roll, String email, String password) {
        this.name = name;
        this.roll = roll;
        this.email = email;
        this.password = password;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
