package com.example.testspring2class.model;

public class Student {
    private Integer id;
    private String name;
    private String address;
    private Classroom classroom;

    public Student(Integer id, String name, String address, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
