package com.dk.book.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dk.book.domain.Author;
import com.dk.book.repositories.AuthorRepository;
import com.dk.book.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository bookRepository) {
        this.authorRepository = bookRepository;
    }

    @Override
    public Author save(final Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Page<Author> listAuthors(final Pageable pageable){
        return authorRepository.findAll(pageable);
    }


}
