package com.example.demo_product2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private Long id;

    private String name;

    
}
