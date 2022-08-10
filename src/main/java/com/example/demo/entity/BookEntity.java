package com.example.demo.entity;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public StudentEntity getStudent() {
        return students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setStudent(StudentEntity student) {
        this.students = student;
    }
}
