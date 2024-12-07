package com.dk.book.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dk.book.domain.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long>,
        PagingAndSortingRepository<Notification, Long> {
}
