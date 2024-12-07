package com.dk.book.publisher.services;

import com.dk.book.publisher.domain.Book;

/**
 * Publishes books.
 */
public interface BookPublisherService {

    void publish(Book book);

}
