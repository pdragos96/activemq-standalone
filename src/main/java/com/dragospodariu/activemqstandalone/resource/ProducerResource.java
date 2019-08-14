package com.dragospodariu.activemqstandalone.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.jms.Topic;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Topic topic;

    @PostConstruct
    public void publish() {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                jmsTemplate.convertAndSend(topic, getTimeStamp());
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    private String getTimeStamp() {
        return new Timestamp(new Date().getTime()).toString();
    }
}