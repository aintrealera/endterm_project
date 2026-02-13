package com.library.library_system.service;

import com.library.library_system.model.Book;
import com.library.library_system.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import com.library.library_system.cache.BookCache;

@Service
public class BookService {

    private final BookRepository repository;
    private final BookCache cache = BookCache.getInstance();

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {

        if (!cache.isEmpty()) {
            return cache.getBooks();
        }

        List<Book> books = repository.findAll();
        cache.setBooks(books);
        return books;
    }

    public Book saveBook(Book book) {
        Book saved = repository.save(book);
        cache.clear();
        return saved;
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
        cache.clear();
    }
}
