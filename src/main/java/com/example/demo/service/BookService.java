package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.model.BookModel;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    public BookModel createBook(BookEntity book, Integer idStudent) {
        StudentEntity student = studentRepository.findById(idStudent).get();
        book.setStudent(student);
        return BookModel.toModel(bookRepository.save(book));
    }

    public BookModel getBook(Integer id) {
        BookEntity book = bookRepository.findById(id).get();
        book.setId(book.getId());
        return BookModel.toModel(bookRepository.save(book));
    }

}
