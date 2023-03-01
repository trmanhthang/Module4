package com.example.demouploadfile.model;

public class Employee {
    private static Integer INDEX = 0;
    private Integer id;
    private String name;
    private String contactNumber;
    private Brand brand;

    public Employee() {
    }

    public Employee(String name, String contactNumber, Brand brand) {
        this.id = ++INDEX;
        this.name = name;
        this.contactNumber = contactNumber;
        this.brand = brand;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
