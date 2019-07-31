package com.travel.planner.controller;

import com.travel.planner.producers.model.TaskTodoMessageProducer;
import com.travel.planner.producers.sender.TodoRabbitMQSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todomessagerest")
public class TodoMessageSenderController {
    private Logger logger = LoggerFactory.getLogger(TodoMessageSenderController.class);

    @Autowired
    private TodoRabbitMQSender todoRabbitMQSender;


    @PostMapping(value = "/todos",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sendMessageToQueue(@RequestBody List<TaskTodoMessageProducer> todo){
       String messageQueueResponse = todoRabbitMQSender.sendMesageToQueue(todo);
       return ResponseEntity.ok().body(messageQueueResponse);

    }
}
