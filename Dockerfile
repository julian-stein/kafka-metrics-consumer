FROM openjdk:15
COPY ./target/consumer-0.0.1-SNAPSHOT.jar /var
WORKDIR /var
ENTRYPOINT ["java", "-jar","consumer-0.0.1-SNAPSHOT.jar"]