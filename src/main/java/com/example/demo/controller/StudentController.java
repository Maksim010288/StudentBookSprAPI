package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.BookModel;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import com.example.demo.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody StudentEntity studentEntity) {
        StudentEntity student = new StudentEntity(studentEntity.getSurName(),
                studentEntity.getName(),
                studentEntity.getPassportNumber());
        studentService.create(student);
        return ResponseEntity.badRequest().body("Added: " + student.getSurName() + " " + student.getName());
    }

    @GetMapping("students/{id}")
    public ResponseEntity<StudentModel> getOneStudent(@PathVariable Integer id) {
        StudentModel studentModel = StudentModel.toModel(studentService.getOne(id));
        return ResponseEntity.badRequest().body(studentModel);
    }

    @GetMapping("student/getAll")
    public List<StudentEntity> getAll() {
        List<StudentEntity> studentEntities = new ArrayList<>();
        studentEntities.addAll(studentService.getAll());
        return studentEntities;
    }

    @PutMapping("students/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody StudentEntity entity) {
        studentService.update(id, entity);
        return ResponseEntity.badRequest().body("Student id number " + id + " was changed");
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.badRequest().body("Student id number " + id + " was deleted");
    }
}
