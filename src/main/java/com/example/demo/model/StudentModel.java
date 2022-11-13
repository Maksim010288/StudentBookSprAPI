package com.example.demo.model;

import com.example.demo.entity.StudentEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
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
}
