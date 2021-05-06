package com.example.lesson4;

public class TaskModel {

    private String tittle, description, date;

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public TaskModel(String tittle, String description, String date) {
        this.tittle = tittle;
        this.description = description;
        this.date = date;
    }
}
