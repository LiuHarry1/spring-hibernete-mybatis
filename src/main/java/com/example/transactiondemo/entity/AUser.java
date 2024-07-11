package com.example.transactiondemo.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUSER")
public class AUser {
    @Id
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "fk_role_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Set<ARole> roles = new HashSet<>();

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

    public Set<ARole> getRoles() {
        return roles;
    }

    public void setRoles(Set<ARole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
