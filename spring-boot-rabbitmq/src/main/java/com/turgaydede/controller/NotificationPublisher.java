package com.turgaydede.controller;

import com.turgaydede.config.ApplicationConfiguration;
import com.turgaydede.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class NotificationPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    ApplicationConfiguration configuration;

    @PostMapping("/publish")
    public String publishNotification(@RequestBody Notification notification){
        notification.setId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        rabbitTemplate.convertAndSend(configuration.getExchangeName(),configuration.getRoutingName(),notification);
        return "Message Published";
    }
}
