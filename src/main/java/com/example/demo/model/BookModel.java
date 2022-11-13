package com.example.demo.model;

import com.example.demo.entity.BookEntity;
import com.example.demo.entity.StudentEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class BookModel {
    private Integer id;
    private String title;
    private String writer;

    public BookModel(){}

    public BookModel(Integer id, String title, String writer) {
        this.id = id;
        this.title = title;
        this.writer = writer;
    }

    public static BookModel toModelBook(BookEntity entity){
        return new BookModel(entity.getId(), entity.getTitle(), entity.getWriter());
    }
}
