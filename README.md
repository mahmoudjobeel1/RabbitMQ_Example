# RabbitMQ Example

This is a simple example project demonstrating the usage of RabbitMQ messaging system in a Java application. The project utilizes Spring AMQP framework for RabbitMQ integration.

## Overview

The project consists of a message producer (`UserServiceMessageProducer`) and a message consumer (`UserAuthenticationServiceMessageConsumer`) that communicate through RabbitMQ. The producer sends custom messages to the RabbitMQ exchange, and the consumer listens to the corresponding queue and processes the received messages.

## Prerequisites

To run this project, you need to have the following installed:

- Java Development Kit (JDK)
- RabbitMQ Server

## Configuration

The project's RabbitMQ configuration is defined in the `MQConfig` class in both the `mq.consumer` and `mq.producer` packages.

### Message Producer Configuration

In the `mq.producer` package, the `MQConfig` class configures the RabbitMQ exchange and queue for the user service. It defines a topic exchange named "user" and a corresponding queue named "user-service-queue". The binding between the queue and exchange is done based on the routing key pattern "user.#".

### Message Consumer Configuration

In the `mq.consumer` package, the `MQConfig` class configures the RabbitMQ exchange and queue for the user authentication service. It defines a topic exchange named "authentication" and a corresponding queue named "user-authentication-service-queue". The binding between the queue and exchange is done based on the routing key pattern "authentication.#".

## Custom Messages and Commands

The project uses custom messages to encapsulate data and commands. The `CustomMessage` class in the `Models` package represents a custom message and contains the following properties:

- `messageId`: A unique identifier for the message.
- `messageDate`: The date and time when the message was created.
- `command`: An enumeration of available commands.
- `dataMap`: A map of additional data associated with the message.
- `source`: The source of the message.

The `CommandEnum` enum in the `Models.Command` package defines the available commands. Currently, only the `LogOutCommand` is implemented.

The `CommandInterface` interface in the `Models.Command` package defines the contract for executing a command. Each command implementation, such as `LogOutCommand`, should implement this interface.

The `UserAuthenticationServiceMessageConsumer` class in the `mq.consumer` package listens to the "user-authentication-service-queue" and processes the received messages. It dynamically instantiates the appropriate command class based on the command name specified in the message and executes it.

The `UserServiceMessageProducer` class in the `mq.producer` package is responsible for sending custom messages to the RabbitMQ exchange. It uses the RabbitTemplate to convert and send the messages to the appropriate routing key.

## Usage

To use this project, you can follow these steps:

1. Ensure that RabbitMQ Server is running.

2. Configure the RabbitMQ connection properties in the `application.properties` file.

3. Build the project using Maven build.

4. Run the application.

5. The message producer (`UserServiceMessageProducer`) can send custom messages using the `send` method.

6. The message consumer (`UserAuthenticationServiceMessageConsumer`) will listen to the queue and execute the appropriate command based on the received messages.

