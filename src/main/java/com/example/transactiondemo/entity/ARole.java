package com.example.transactiondemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.mockito.exceptions.misusing.NotAMockException;

@Table(name = "AROLE")
@Entity
public class ARole {
    @Id
    private Long id;
    private String name;

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
        return "ARole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
