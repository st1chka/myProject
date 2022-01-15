package com.st1ch.andersenWeb.models;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Roles(String name) {
        this.name = name;
    }

    public Roles() {
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Roles roles = (Roles) obj;
        if (!Objects.equals(this.name, roles.name)) {
            return false;
        }

        return Objects.equals(this.name, roles.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}