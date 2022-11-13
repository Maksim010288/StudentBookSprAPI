package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
