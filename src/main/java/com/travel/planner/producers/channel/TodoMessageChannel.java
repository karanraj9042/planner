package com.travel.planner.producers.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface TodoMessageChannel {

   @Output("greetingChannel")
   MessageChannel greeting();



}
