package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


