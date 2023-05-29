package com.example.rabbitmq_example.mq.consumer;

import com.example.rabbitmq_example.Models.Command.CommandInterface;
import com.example.rabbitmq_example.Models.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationServiceMessageConsumer {
    @RabbitListener(queues = "user-authentication-service-queue")
    public void processMessage(CustomMessage message) {
        String commandClassName = message.getCommand().getName();

        try {
            Class<?> commandClass = Class.forName("com.example.rabbitmq_example.Models.Command." + commandClassName);
            CommandInterface commandInstance = (CommandInterface) commandClass.newInstance();
            commandInstance.execute(message);
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
    }
}
