package com.example.demo.model;

import com.example.demo.entity.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StudentModel {
   private Integer id;
   private final String name;
   private final String surName;
   private List<BookModel> books;

    public static StudentModel toModel(StudentEntity entity){
        StudentModel student = new StudentModel(entity.getId(), entity.getSurName(), entity.getName());
        student.setBooks(entity.getBooks().stream().map(BookModel::toModelBook).collect(Collectors.toList()));
        return student;
    }

    public StudentModel(Integer id, String surName, String name) {
        this.id = id;
        this.surName = surName;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
