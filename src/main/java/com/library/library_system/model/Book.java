package com.library.library_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String type; //
    private Boolean isBorrowed;

    public Book() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Boolean getBorrowed() { return isBorrowed; }
    public void setBorrowed(Boolean borrowed) { isBorrowed = borrowed; }

    public static class Builder {
        private Book newBook;

        public Builder() {
            newBook = new Book();
        }

        public Builder title(String title) {
            newBook.setTitle(title);
            return this;
        }

        public Builder author(String author) {
            newBook.setAuthor(author);
            return this;
        }

        public Builder type(String type) {
            newBook.setType(type);
            return this;
        }

        public Book build() {
            return newBook;
        }
    }
}