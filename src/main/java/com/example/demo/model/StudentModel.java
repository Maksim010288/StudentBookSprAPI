package com.example.demo.model;

import com.example.demo.entity.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StudentModel {
   private final Integer id;
   private final String title;
   private final String writer;
   private List<BookModel> books;

    public static StudentModel toModel(StudentEntity entity){
        StudentModel student = new StudentModel(entity.getId(), entity.getSurName(), entity.getName());
        student.setBooks(entity.getBooks().stream().map(BookModel::toModel).collect(Collectors.toList()));
        return student;
    }

    public StudentModel(Integer id, String title, String writer) {
        this.id = id;
        this.title = title;
        this.writer = writer;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
