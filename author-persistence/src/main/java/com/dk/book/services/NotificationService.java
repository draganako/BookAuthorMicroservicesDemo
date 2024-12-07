package com.dk.book.services;

import com.dk.book.domain.Notification;

public interface NotificationService {
    void publishNotification(Notification notification);
}
