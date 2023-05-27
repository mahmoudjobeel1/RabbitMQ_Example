package com.example.rabbitmq_example.Models.Command;

public enum CommandEnum {
    LogOutCommand("LogOutCommand", "authentication");
    private final String name;
    private final String destination;

    CommandEnum(String name, String routingKey) {
        this.name = name;
        this.destination = routingKey;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }
}
