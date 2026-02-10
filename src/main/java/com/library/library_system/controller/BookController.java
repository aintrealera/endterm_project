package com.library.library_system.controller;

import com.library.library_system.model.Book;
import com.library.library_system.pattern.BookFactory;
import com.library.library_system.pattern.LibraryLogger;
import com.library.library_system.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAll() {
        LibraryLogger.getInstance().log("GET request: All books");
        return service.getAllBooks();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PostMapping("/quick")
    public Book createQuick(@RequestParam String title, @RequestParam String type) {
        Book book = BookFactory.createBook(type, title);
        return service.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBook(id);
    }
}