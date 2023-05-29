package com.example.rabbitmq_example.mq.producer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    private static final String EXCHANGE_NAME = "user";

    @Bean
    public TopicExchange userServiceExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue userServiceQueue() {
        return new Queue("user-service-queue");
    }

    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    @Bean
    public Binding userServiceBinding(Queue userServiceQueue, TopicExchange userServiceExchange) {
        return BindingBuilder.bind(userServiceQueue).to(userServiceExchange).with("user.#");
    }
}
