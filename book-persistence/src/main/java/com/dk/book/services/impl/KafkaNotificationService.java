package com.dk.book.services.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dk.book.config.KafkaConfigProps;
import com.dk.book.domain.Notification;
import com.dk.book.exceptions.NotificationPublishException;
import com.dk.book.services.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaNotificationService implements NotificationService {

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaConfigProps kafkaConfigProps;

    public KafkaNotificationService(
        final ObjectMapper objectMapper,
        final KafkaTemplate<String, String> kafkaTemplate,
        final KafkaConfigProps kafkaConfigProps) {
            this.objectMapper = objectMapper;
            this.kafkaTemplate = kafkaTemplate;
            this.kafkaConfigProps = kafkaConfigProps;
    }

    @Override
    public void publishNotification(Notification notification) {
        try {
        final String payload = objectMapper.writeValueAsString(notification);
        kafkaTemplate.send(kafkaConfigProps.getTopic(), payload);
        } catch(final JsonProcessingException ex) {
            throw new NotificationPublishException("Unable to publish notification", ex, notification);
        }
    }


}
