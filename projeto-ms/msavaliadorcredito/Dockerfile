FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar

ARG RABBITMQ_SERVER=rabbitmq
ARG EUREKA_SERVER=ms-eureka
ENTRYPOINT java -jar -Dspring.profiles.active=prod app.jar
