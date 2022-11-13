package com.example.demo.model;

import com.example.demo.entity.BookEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class  BookModelTest {
    BookEntity entity = new BookEntity("Анна Каренина", "Антон Павлович Чехов");
    BookModel model = new BookModel(4, "Анна Каренина", "Антон Павлович Чехов");


    @Test
    void getId() {
        Integer id = 4;
        Assertions.assertEquals(id, model.getId());
    }

    @Test
    void toModel() {
        entity.setId(4);
        Assertions.assertEquals(model.toString(), BookModel.toModelBook(entity).toString());
    }

    @Test
    void getWriter() {
    }
}