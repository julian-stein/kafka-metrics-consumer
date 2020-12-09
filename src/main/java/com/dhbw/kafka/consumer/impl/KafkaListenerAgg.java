package com.dhbw.kafka.consumer.impl;

import com.dhbw.kafka.consumer.metrics.SystemMetricsMessage;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerAgg {

    @KafkaListener(
            topics = "${metrics.topic.name}",
            containerFactory = "metricsKafkaListenerContainerFactory",
            groupId = "${consumergroup.id}",
            concurrency = "3",
            autoStartup = "true"
    )
    public void metricsListener(@Payload SystemMetricsMessage message,
                                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partitionId
                                ) {
        System.out.println("Received metrics from partition " + partitionId + "\n" + message);
    }
}