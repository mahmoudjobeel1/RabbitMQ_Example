package com.example.rabbitmq_example.Models.Command;

import com.example.rabbitmq_example.Models.CustomMessage;

public interface CommandInterface {
    public void execute(CustomMessage message);

}
