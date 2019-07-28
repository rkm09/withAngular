package com.example.withAngular.juice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Juice {
    @Id
    @GeneratedValue
    private Long id;
    String name;

    public Juice() {
    }

    public Juice(String name) {
        this.name = name;
    }

    public Juice(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Juice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
