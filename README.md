# Kafka Metrics Consumer
This repository contains the source code for a kafka consumer group with three consumers receiving messages containing current CPU and memory usage of a host system from a Kafka topic.

You can run the consumer using docker building an image with the provide Dockerfile and executable jar.

Run the producer using the following command:
```
docker run --name metrics-demo-consumer -e SPRING_APPLICATION_JSON='{\"metrics\":{\"topic\":{\"name\":\"<topicName>\"}},\"consumergroup\":{\"id\":\"<consumerGroupID>\"}}' --network kafka-network metrics-consumer
```
Make sure to supply a topic name and the ID for the consumer group using the SPRING_APPLICATION_JSON environment variable.
Depending on your CLI you may have to adjust the escaping of the JSON-String and/or remove the outer single quotation marks.
