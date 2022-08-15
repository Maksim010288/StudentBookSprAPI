package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.model.BookModel;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    public BookEntity createBook(BookEntity book, Integer idStudent) {
        StudentEntity student = studentRepository.findById(idStudent).get();
        book.setStudent(student);
        return bookRepository.save(book);
    }


    public BookEntity getBook(Integer id) {
        BookEntity book = bookRepository.findById(id).get();
        book.setId(book.getId());
        return bookRepository.save(book);
    }

    public BookEntity updateBook(BookEntity bookEntity, Integer idStudents, Integer idBook) {
        StudentEntity studentEntity = studentRepository.findById(idStudents).get();
        bookEntity.setStudent(studentEntity);
        bookEntity.setId(idBook);
        return bookRepository.saveAndFlush(bookEntity);
    }

    public BookEntity deleteBook(Integer id) {
        BookEntity bookEntity = bookRepository.findById(id).get();
        bookEntity.setId(bookEntity.getId());
        bookRepository.delete(bookEntity);
        return bookEntity;
    }
}
