package com.udemy.rabbit.web;


import com.udemy.rabbit.config.ObjetoIntercambio;
import com.udemy.rabbit.config.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class PublisherService {

    private final Publisher publisher;


    public PublisherService(Publisher publisher) {
        this.publisher = publisher;
    }

    public void sendToRabbit(ObjetoIntercambio datos){
        // log.info("Message {} enviado",message);
        publisher.send(datos);
    }

    public void sendToRabbitByTopic(String key, ObjetoIntercambio datos){
        publisher.sendByTopic(key,datos);
    }

    public void sendByFanOutExchange(ObjetoIntercambio datos){
        publisher.sendByFanoutExchange("fanoutexchange",datos);
    }

    public void sendByHeaders(Map<String,Object> headers, Object message){
        publisher.sendByHeaders(headers,message);
    }
}
