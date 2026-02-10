package com.library.library_system.pattern;

import com.library.library_system.model.Book;

public class BookFactory {
    public static Book createBook(String type, String title) {
        Book book = new Book();
        book.setTitle(title);
        book.setBorrowed(false);

        if ("DIGITAL".equalsIgnoreCase(type)) {
            book.setType("E-BOOK");
            book.setAuthor("Internet Source");
        } else {
            book.setType("PHYSICAL");
            book.setAuthor("Library Archive");
        }
        return book;
    }
}