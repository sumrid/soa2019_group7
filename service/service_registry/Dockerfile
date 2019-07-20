FROM openjdk:8-jdk-alpine

USER root
COPY . .
RUN ./gradlew clean build

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/build/libs/service_registry-1.0.jar"]