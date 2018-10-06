FROM openjdk:8
ADD ./spring-rest-iw-exam.jar spring-rest-iw-exam.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "spring-rest-iw-exam.jar"]