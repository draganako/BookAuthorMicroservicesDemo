package com.dk.book.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dk.book.domain.Book;
import com.dk.book.repositories.BookRepository;
import com.dk.book.services.BooksService;

@Service
public class BooksServiceImpl implements BooksService {

    private final BookRepository bookRepository;

    public BooksServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(final Book book) {
        return bookRepository.save(book);
    }

    public Page<Book> listBooks(final Pageable pagable) {
        return bookRepository.findAll(pagable);
    }

}
