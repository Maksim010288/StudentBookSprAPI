package com.example.demo.model;

import com.example.demo.entity.BookEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookModelTest {
    BookEntity entity = new BookEntity("Анна Каренина", "Антон Павлович Чехов");
    BookModel modelBook = new BookModel(4, "Анна Каренина", "Антон Павлович Чехов");

    @Test
    void toModel() {
        entity.setId(4);
        Assertions.assertEquals(modelBook.toString(), BookModel.toModelBook(entity).toString());
    }
}