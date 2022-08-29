package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.model.BookModel;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.validation.BooksValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    public BookEntity createBook(BookEntity book, Integer idStudent) {
        BooksValidator.validation(book);
        BooksValidator.repeatOfTheBooksValidation(book, bookRepository);
        StudentEntity student = studentRepository.findById(idStudent).get();
        book.setStudent(student);
        return bookRepository.save(book);
    }


    public BookEntity getBook(Integer id) {
        BookEntity book = bookRepository.findById(id).get();
        book.setId(book.getId());
        return bookRepository.save(book);
    }

    public List<BookEntity> getAll(){
        List<BookEntity> bookEntities = new LinkedList<>();
        for (BookEntity bookEntity : bookRepository.findAll()){
            BookEntity book = new BookEntity(bookEntity.getId(),
                    bookEntity.getTitle(),
                    bookEntity.getWriter(),
                    bookEntity.getStudent());
            bookEntities.add(book);
        }
        return bookEntities;
    }

    public BookEntity updateBook(BookEntity bookEntity, Integer idStudents, Integer idBook) {
        BooksValidator.validation(bookEntity);
        BooksValidator.repeatOfTheBooksValidation(bookEntity, bookRepository);
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
