package com.dk.book.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dk.book.domain.Notification;

public interface NotificationsService {

    Notification save(Notification book);

    Page<Notification> listNotifications(Pageable pageable);
}
