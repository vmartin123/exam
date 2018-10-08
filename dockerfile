FROM maven:3.5-alpine
COPY ./ /app
RUN cd /app && mvn package

FROM openjdk:8
COPY spring-rest-iw-exam.jar /tmp/spring-rest-iw-exam.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "/tmp/spring-rest-iw-exam.jar"]
