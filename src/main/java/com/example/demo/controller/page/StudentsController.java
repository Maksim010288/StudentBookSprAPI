package com.example.demo.controller.page;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.validation.StudentsValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentsController {
    Logger log = LoggerFactory.getLogger(StudentsController.class);
    StudentsValidator validator = new StudentsValidator();
    @Autowired
    StudentRepository repository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentService service;

    @GetMapping("/")
    public String findStudent(Model model) {
        Iterable<StudentEntity> studentsList = repository.findAll();
        model.addAttribute("studentsList", studentsList);
        return "find";
    }

    @GetMapping("/add")
    public String studentAdd(Model model) {
        return "listForm";
    }

    @PostMapping("/add")
    public String studAdd(@RequestParam String name,
                          @RequestParam String surName,
                          @RequestParam String passport,
                          Model model) {
        StudentEntity studentEntity = new StudentEntity(name, surName, Integer.parseInt(passport));
        validator.validates(studentEntity);
        validator.validEnteringPassportNumber(studentEntity);
        service.validPassportNumbers(studentEntity);
        repository.save(studentEntity);
        return "redirect:/stud";
    }

    @GetMapping("/find")
    public String findById() {
        return "search";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam String id, Model model) {
        int idStud = Integer.parseInt(id);
        List<StudentEntity> studentEntities = new ArrayList<>() ;
        for (StudentEntity lists : repository.findAll()){
            if (lists.getId()==idStud){
                studentEntities.add(lists);
            }
        }
        model.addAttribute("list", studentEntities);
        log.info("{}", studentEntities);
        return "search";
    }
}
