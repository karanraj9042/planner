package com.travel.planner.producers.Enums;

public enum RabbitMessageQueueName {
    MESSAGE_QUEUE("planner-queue");

    public final String queueName;

    private RabbitMessageQueueName(String queueName) {
        this.queueName = queueName;
    }
}
