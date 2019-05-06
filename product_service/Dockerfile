################# build docker image ###################
FROM openjdk:8-jdk-alpine
USER root
#COPY /target/product_service.jar product.jar
COPY . .
RUN ./mvnw clean package
EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "product.jar"]
ENTRYPOINT ["java", "-jar", "target/product_service.jar"]
