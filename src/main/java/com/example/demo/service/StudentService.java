package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public StudentEntity create(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity getOne(Integer id) {
        return studentRepository.findById(id).get();
    }

    public StudentEntity update(Integer id, StudentEntity entity) {
        entity.setId(id);
        return studentRepository.saveAndFlush(entity);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
