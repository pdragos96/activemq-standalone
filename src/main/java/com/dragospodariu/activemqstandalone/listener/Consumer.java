package com.dragospodariu.activemqstandalone.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "standalone.topic")
    public void consume(String message) {
        System.out.println("Consumer Received " + message);
    }
}