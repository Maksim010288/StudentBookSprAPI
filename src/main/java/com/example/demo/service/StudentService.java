package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public StudentModel create(StudentEntity student) {
        return StudentModel.tuModel(studentRepository.save(student));
    }

    public StudentModel getOne(Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        return StudentModel.tuModel(studentEntity);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
