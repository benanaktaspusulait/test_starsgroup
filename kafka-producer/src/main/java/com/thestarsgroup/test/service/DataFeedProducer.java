package com.thestarsgroup.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

@Slf4j
@Service
public class DataFeedProducer {

    @Autowired
    private Environment env;

    @Autowired
    protected KafkaTemplate<String, String> kafkaTemplate;

    private String ip;
    private Integer port;

    @PostConstruct
    public void init() {
        this.ip = env.getProperty("feedme.ip");
        this.port = Integer.valueOf(env.getProperty("feedme.port"));
        runClient();
    }

    //@Scheduled(initialDelay =    100)
    public void runClient() {
        try {

            Socket echoSocket = new Socket(ip, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            String userInput;

            while ((userInput = reader.readLine()) != null) {
                this.kafkaTemplate.send(Constants.TYPE_TOPIC, userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

