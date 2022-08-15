package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody StudentEntity studentEntity) {
        StudentEntity student = new StudentEntity(studentEntity.getSurName(), studentEntity.getName());
        studentService.create(student);
        return ResponseEntity.badRequest().body("Added: " + student.getSurName() + " " + student.getName());
    }

    @GetMapping("students/{id}")
    public ResponseEntity<StudentModel> getOneStudent(@PathVariable Integer id) {
        StudentModel studentModel = StudentModel.toModel(studentService.getOne(id));
        return ResponseEntity.badRequest().body(studentModel);
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
