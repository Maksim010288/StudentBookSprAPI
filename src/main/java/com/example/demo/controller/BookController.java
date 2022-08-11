package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(value = "/students/{studentId}/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookModel addBook(@RequestBody BookEntity book, @PathVariable Integer studentId) {
        return bookService.createBook(book, studentId);
    }

    @GetMapping("/books/{id}")
    public BookModel getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }
}
