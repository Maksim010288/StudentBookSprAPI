package com.example.demo.model;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentModelTest {

    StudentEntity entity = new StudentEntity("Baziuk", "Maks", 345321);
    StudentModel entityModel = new StudentModel(entity.getId(), entity.getSurName(), entity.getName());
    BookEntity model = new BookEntity( "Stefaniya", "Marko Wowchok");
    BookModel modelBook = new BookModel(model.getId(), model.getTitle(), model.getWriter());

    @Test
    void toModel() {
        List<BookEntity> bookModels = List.of(model);
        List<BookModel> bookModel = List.of(modelBook);
        entity.setBooks(bookModels);
        entityModel.setBooks(bookModel);
        Assertions.assertEquals(entityModel.toString(), StudentModel.toModel(entity).toString());
    }
}