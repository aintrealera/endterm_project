package com.library.library_system.cache;

import com.library.library_system.model.Book;

import java.util.List;

public class BookCache {

    private static BookCache instance;

    private List<Book> cachedBooks;

    private BookCache() {}

    public static synchronized BookCache getInstance() {
        if (instance == null) {
            instance = new BookCache();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return cachedBooks;
    }

    public void setBooks(List<Book> books) {
        this.cachedBooks = books;
    }

    public void clear() {
        cachedBooks = null;
    }

    public boolean isEmpty() {
        return cachedBooks == null;
    }
}
