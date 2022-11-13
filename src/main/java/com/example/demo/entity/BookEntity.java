package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Data
@Entity(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "writer")
    private String writer;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private StudentEntity students;

    public BookEntity() {
    }

    public BookEntity(String title, String writer) {
        this.title = title;
        this.writer = writer;
    }

    public BookEntity(Integer id, String title, String writer, StudentEntity student) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.students = student;
    }
}
