package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody StudentEntity studentEntity) throws InterruptedException {
//        if (new Random(Instant.now().toEpochMilli()).nextBoolean()) {
//            Thread.sleep(6000);
//        }
        StudentEntity student = new StudentEntity(studentEntity.getSurName(),
                studentEntity.getName(), studentEntity.getPassportNumber());
        studentService.create(student);
        return ResponseEntity.ok().body("Added: " + student.getSurName() + " " + student.getName());
    }

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping("students/{id}")
    public ResponseEntity<StudentModel> getOneStudent(@PathVariable Integer id) {
        StudentModel studentModel = StudentModel.toModel(studentService.getOne(id));
        return ResponseEntity.ok().body(studentModel);
    }

    @GetMapping(value = "students/getAll")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
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
