package com.example.demo.model;

import com.example.demo.entity.BookEntity;

public class BookModel {
    private Integer id;
    private String title;
    private String writer;

    public BookModel(Integer id, String title, String writer) {
        this.id = id;
        this.title = title;
        this.writer = writer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static BookModel toModel(BookEntity entity){
        return new BookModel(entity.getId(), entity.getTitle(), entity.getWriter());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
