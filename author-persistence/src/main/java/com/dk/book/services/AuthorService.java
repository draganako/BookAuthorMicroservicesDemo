package com.dk.book.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dk.book.domain.Author;

public interface AuthorService {
    Author save(Author book);
    Page<Author> listAuthors(Pageable pageable);
}
