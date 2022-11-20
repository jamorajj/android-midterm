package com.example.midtermtest;

public class ProgrammeView {

    private String id;
    private String name;
    private String hours;

    public ProgrammeView(String id, String name, String hours) {
        this.id = id;
        this.name = name;
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }
}
