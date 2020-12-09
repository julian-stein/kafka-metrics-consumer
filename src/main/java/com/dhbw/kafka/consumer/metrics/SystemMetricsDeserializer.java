package com.dhbw.kafka.consumer.metrics;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class SystemMetricsDeserializer implements Deserializer<SystemMetricsMessage> {


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public SystemMetricsMessage deserialize(String s, byte[] bytes) {
        SystemMetricsMessage message = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            message = objectMapper.readValue(bytes, SystemMetricsMessage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public SystemMetricsMessage deserialize(String topic, Headers headers, byte[] data) {
        SystemMetricsMessage message = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            message = objectMapper.readValue(data, SystemMetricsMessage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public void close() {

    }
}
