package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sur_name")
    private String surName;
    @Column(name = "name")
    private String name;
    @Column(name = "passport_number")
    private Integer passportNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "students")
    private List<BookEntity> books;

    public StudentEntity() {
    }

    public StudentEntity(String surName, String name, Integer passportNumber) {
        this.surName = surName;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public StudentEntity(int id, String surName, String name, Integer passportNumber) {
        this.id = id;
        this.surName = surName;
        this.name = name;
        this.passportNumber = passportNumber;
    }
}
