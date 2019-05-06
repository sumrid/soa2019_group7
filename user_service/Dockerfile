FROM openjdk:8-jdk-alpine
USER root
COPY /build/libs/userservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5000
CMD ["java", "-jar", "app.jar"]