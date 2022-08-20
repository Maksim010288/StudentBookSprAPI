package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.validation.Validator;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {
    private final Validator validator = new Validator();
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity create(StudentEntity student) {
        validator.validates(student);
        validator.validEnteringPassportNumber(student);
        validPassportNumbers(student);
        return studentRepository.save(student);
    }

    public StudentEntity getOne(Integer id) {
        return studentRepository.findById(id).get();
    }

    public List<StudentEntity> getAll() {
        List<StudentEntity> studentEntities = new ArrayList<>();
        for (StudentEntity student : studentRepository.findAll()) {
            StudentEntity model = new StudentEntity(
                    student.getName(),
                    student.getSurName(),
                    student.getPassportNumber());
            studentEntities.add(model);
        }
        return studentEntities;
    }

    public StudentEntity update(Integer id, StudentEntity entity) {
        entity.setId(id);
        return studentRepository.saveAndFlush(entity);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    private void validPassportNumbers(StudentEntity student) {
        List<StudentEntity> studentEntities = getAll();
        for (StudentEntity studentEntity : studentEntities) {
            if (studentEntity.getPassportNumber() == student.getPassportNumber()) {
                throw new RuntimeException("such a passport number already exists");
            }
        }
    }
}
