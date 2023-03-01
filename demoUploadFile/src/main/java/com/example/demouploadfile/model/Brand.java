package com.example.demouploadfile.model;

public class Brand {
    private Integer INDEX = 0;
    private Integer id;
    private String name;

    public Brand() {
    }

    public Brand(String name) {
        this.id = ++INDEX;
        this.name = name;
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
}
