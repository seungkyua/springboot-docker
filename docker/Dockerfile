#FROM maven:3.8.4-openjdk-17-slim as build
#MAINTAINER Ahn Seungkyu
#COPY ../pom.xml .
#COPY ../src src
#RUN mvn clean package -DskipTests


FROM openjdk:17.0.1-jdk-slim
MAINTAINER Ahn Seungkyu
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY scripts/run.sh .
ENTRYPOINT ["./run.sh"]
