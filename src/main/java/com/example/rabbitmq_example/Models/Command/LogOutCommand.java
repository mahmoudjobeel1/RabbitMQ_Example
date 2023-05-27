package com.example.rabbitmq_example.Models.Command;

import com.example.rabbitmq_example.Models.CustomMessage;

import java.util.Map;

public class LogOutCommand implements CommandInterface {

    @Override
    public void execute(CustomMessage message) {
        /*
        * Here we can send a URL request to the inside server to log out the user
        * Or we can reply the other service since we have the message with data
        * */
    }
}
