package com.mathesukkj.apirestful.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.mathesukkj.apirestful.domain.User;

public class CommentDTO implements Serializable {
    private String text;
    private LocalDate date;
    private User author;

    public CommentDTO() {
    }

    public CommentDTO(String text, LocalDate date, User author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
