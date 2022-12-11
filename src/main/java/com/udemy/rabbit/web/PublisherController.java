package com.udemy.rabbit.web;


import com.udemy.rabbit.config.ObjetoIntercambio;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/test")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping()
    public void testSendMessage(@RequestBody ObjetoIntercambio msg){

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("a","b");
//        jsonObject.toString();

        log.error("a Enviar {}",msg);
        publisherService.sendToRabbit(msg);
    }

    @PostMapping("/tv")
    public void sendMessageTV(@RequestBody ObjetoIntercambio msg){
        log.error("a Enviar {}",msg);
        publisherService.sendToRabbitByTopic("tv",msg);
    }

    @PostMapping("/ac")
    public void sestSendAC(@RequestBody ObjetoIntercambio msg){
        log.error("a Enviar {}",msg);
        publisherService.sendToRabbitByTopic("ac",msg);
    }

    @PostMapping("/mobile")
    public void sendMessageMobile(@RequestBody ObjetoIntercambio msg){
        log.error("a Enviar {}",msg);
        publisherService.sendToRabbitByTopic("mobile",msg);
    }


    @PostMapping("/fanout")
    public void sendMessageFanout(@RequestBody ObjetoIntercambio msg){
        log.error("a Enviar {}",msg);
        publisherService.sendByFanOutExchange(msg);
    }

    @PostMapping("/byHeaders")
    public void sendWithHeaders(
            @RequestParam(value = "item1",required = false) String item1,
            @RequestParam(value = "item2",required = false) String item2,
            @RequestBody ObjetoIntercambio msg){
        log.error("a Enviar {}",msg);
        Map<String, Object> headers = new HashMap<>();
        if(!Objects.isNull(item1)){
            headers.put("item1",item1);
        }
        if(!Objects.isNull(item2)){
            headers.put("item2",item2);
        }
        if(headers.size()==0){
            log.error("error de parametros");
            return;
        }
        publisherService.sendByHeaders(headers,msg);
    }
}
