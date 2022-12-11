package com.udemy.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EnableRabbit
public class Publisher {

    private final RabbitTemplate rabbitTemplate;

    private final Queue queue;

    private final TopicExchange topicExchange;


    public Publisher(RabbitTemplate rabbitTemplate, Queue queue, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.topicExchange = topicExchange;
    }

    public void send(Object message){
        rabbitTemplate.convertAndSend(queue.getName(),message);
    }

    public void sendByTopic(String keyTopic, Object message){
        rabbitTemplate.convertAndSend(topicExchange.getName(),keyTopic,message);
    }

    public void sendByFanoutExchange(String fanoutExchange, Object messge){
        rabbitTemplate.convertAndSend(fanoutExchange,"",messge);
    }

    public void sendByHeaders(Map<String,Object> headers, Object message){
        rabbitTemplate.convertAndSend("headermessage","",message,m->{
            m.getMessageProperties().setHeaders(headers);
            return m;
        });
    }

}
