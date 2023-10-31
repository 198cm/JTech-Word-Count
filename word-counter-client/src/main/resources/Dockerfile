FROM openjdk:21

LABEL authors="198cm"

WORKDIR /client

COPY target/word-counter-client-0.0.1-SNAPSHOT.jar /client/client.jar
COPY src/main/resources/input.txt /client/input.txt


EXPOSE 8081

CMD ["java", "-jar", "client.jar"]
