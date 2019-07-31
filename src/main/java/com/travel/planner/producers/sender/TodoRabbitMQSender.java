package com.travel.planner.producers.sender;

import com.travel.planner.producers.channel.TodoMessageChannel;
import com.travel.planner.producers.model.TaskTodoMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoRabbitMQSender {

    private Logger logger = LoggerFactory.getLogger(TodoRabbitMQSender.class);

    private MessageChannel messageChannel;

    private TodoRabbitMQSender(TodoMessageChannel binding) {
        this.messageChannel = binding.greeting();
    }

    public String sendMesageToQueue(List<TaskTodoMessageProducer> taskTodoMessageProducer) {
        logger.info("Sending the index request through queue message");
        Message<String> msg = MessageBuilder.withPayload(taskTodoMessageProducer.toString())
                .build();
        this.messageChannel.send(msg);
        return "Message sent to the RabbitMQ  Successfully";
    }

}
