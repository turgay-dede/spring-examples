package com.turgaydede.listener;

import com.turgaydede.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues ="topic-queue" )
    public void listener(Notification notification){
        System.out.println(notification);
    }
}
