package com.dragospodariu.activemqstandalone.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SecondConsumer {

    @JmsListener(destination = "standalone.topic")
    public void consume(String message) {
        System.out.println("Second Consumer Received " + message);
    }
}
