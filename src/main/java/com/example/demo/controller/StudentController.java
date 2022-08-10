package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/create")
    public StudentModel create(String surName, String name) {
        StudentEntity student = new StudentEntity(surName, name);
        return studentService.create(student);
    }

    @GetMapping(value = "/getOne")
    public StudentModel getOneStudent(Integer id) {
         return studentService.getOne(id);
        }


    @DeleteMapping(value = "/deleteById")
    public void deleteById(Integer id){
        studentService.delete(id);
    }
}
