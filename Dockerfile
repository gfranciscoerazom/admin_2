FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu as base

EXPOSE 8080
ADD ./target/microservice_2.jar microservice_2.jar
ENTRYPOINT [ "java", "-jar", "/microservice_2.jar" ]