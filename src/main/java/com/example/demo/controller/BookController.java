package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.model.BookModel;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(value = "/students/{studentId}/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBooks(@RequestBody BookEntity book, @PathVariable Integer studentId) {
        BookModel bookModel = BookModel.toModelBook(bookService.createBook(book, studentId));
        return ResponseEntity.badRequest().body(bookModel.getTitle() + ": "
                + bookModel.getWriter() + " was added to the student id number (" + studentId + ")");
    }

    @GetMapping("/books/{id}")
    public ResponseEntity getBook(@PathVariable Integer id) {
        StudentEntity entity = bookService.getBook(id).getStudent();
        BookModel bookModel = BookModel.toModelBook(bookService.getBook(id));
        return ResponseEntity.badRequest().body("Book: id(" + bookModel.getId() + ")\n " +
                "title: " + bookModel.getTitle() + "\n " +
                "writer: " + bookModel.getWriter() + "\n" +
                "Student: \n id: " + entity.getId() + ") " +
                entity.getSurName() + " " + entity.getName() + ";");
    }

    @GetMapping("/books/getAll")
    public ResponseEntity getAllBooks(){
        List<BookEntity> studentEntityList = bookService.getAll();
       List<BookEntity> books = studentEntityList.stream()
                .filter(bookEntity -> bookEntity.getId() > 0)
                .collect(Collectors.toList());
       return ResponseEntity.badRequest().body(books );
    }

    @PutMapping("/students/{studentId}/books/{bookId}")
    public ResponseEntity updateBook(@PathVariable Integer studentId, @PathVariable Integer bookId,
                                     @RequestBody BookEntity bookEntity) {
        BookModel bookModel = BookModel.toModelBook(bookService.updateBook(bookEntity, studentId, bookId));
        return ResponseEntity.badRequest().body("Book: id(" + bookModel.getId() + ") rename");
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        BookModel bookModel = BookModel.toModelBook(bookService.deleteBook(id));
        return ResponseEntity.badRequest().body("Book: \n " +
                "title: " + bookModel.getTitle() + "\n " +
                "writer: " + bookModel.getWriter() + "\n was withdrawn from the student");
    }
}
