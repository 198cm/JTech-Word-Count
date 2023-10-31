FROM openjdk:21

LABEL authors="198cm"

WORKDIR /server

COPY target/word-counter-rest-0.0.1-SNAPSHOT.jar /server/server.jar

EXPOSE 8080

CMD ["java", "-jar", "server.jar"]
