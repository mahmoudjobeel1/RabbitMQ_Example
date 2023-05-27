package com.example.rabbitmq_example.mq.producer;

import com.example.rabbitmq_example.Models.CustomMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UserServiceMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(CustomMessage message) {
        rabbitTemplate.convertAndSend(message.getRoutingKey(), message.getRoutingKey(), message);
    }
}
