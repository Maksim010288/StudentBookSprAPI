package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(value = "/post")
    public BookModel addBook(String title, String writer, Integer idStudent) {
        BookEntity book = new BookEntity(title, writer);
        return bookService.createBook(book, idStudent);
    }

    @GetMapping(value = "/get")
    public BookModel getBook(Integer id) {
        return bookService.complete(id);
    }
}
