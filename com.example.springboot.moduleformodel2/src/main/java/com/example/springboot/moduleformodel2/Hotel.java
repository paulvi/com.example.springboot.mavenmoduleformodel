package com.example.springboot.moduleformodel2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;

    protected Hotel() {}

    public Hotel(String name) {
        this.name = name;
    }
}
