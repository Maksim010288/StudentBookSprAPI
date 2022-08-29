package com.example.demo.validation;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class BooksValidator {

    public static void validation(BookEntity bookEntity) {
        if (bookEntity.getWriter().isEmpty() || bookEntity.getTitle().isEmpty() ||
                bookEntity.getWriter() == null || bookEntity.getTitle() == null) {
            throw new RuntimeException("title or writer is empty or null");
        }
    }

    public static void repeatOfTheBooksValidation(BookEntity bookEntity, BookRepository bookRepository) {
        List<BookEntity> studentEntities = new ArrayList<>(bookRepository.findAll());
        for (BookEntity book : studentEntities) {
            if (bookEntity.getTitle().equals(book.getTitle()) || bookEntity.getWriter().equals(book.getWriter())) {
                throw new RuntimeException("this title and writer is exists");
            }
        }
    }
}
