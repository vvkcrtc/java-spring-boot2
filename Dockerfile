FROM openjdk:17-jdk-slim-buster

EXPOSE 8080

COPY build/libs/spring-boot2-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]


