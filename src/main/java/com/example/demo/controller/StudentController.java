package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentModel create(String surName, String name) {
        StudentEntity student = new StudentEntity(surName, name);
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    public StudentModel getOneStudent(@PathVariable Integer id) {
         return studentService.getOne(id);
        }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        studentService.delete(id);
    }
}
