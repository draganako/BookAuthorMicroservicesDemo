package com.dk.book.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dk.book.domain.Book;
import com.dk.book.services.BooksService;

@RestController
public class BooksController {

    private final BooksService booksService;

    public BooksController(final BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping(path="/books")
    public Page<Book> listBooks(final Pageable pagable) {
        return booksService.listBooks(pagable);
    }

}
