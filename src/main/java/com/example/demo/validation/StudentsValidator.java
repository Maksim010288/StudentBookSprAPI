package com.example.demo.validation;

import com.example.demo.entity.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class Validator {

    public void validates(StudentEntity studentEntity) {
        if (studentEntity.getName() == null || studentEntity.getName().isEmpty() ||
                studentEntity.getSurName() == null || studentEntity.getSurName().isEmpty()) {
            throw new RuntimeException("name or surName not filed");
        }
    }

    public void validEnteringPassportNumber(StudentEntity entity) {
        if (entity.getPassportNumber() <= 0) {
            throw new RuntimeException("the number cannot be equal to or less than zero");
        } else if (entity.getPassportNumber() <= 100000 || entity.getPassportNumber() >= 999999) {
            throw new RuntimeException("enter the six-digit number from the passport");
        }
    }
}
