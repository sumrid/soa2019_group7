############ clean build & run #############



########### As simple as possible #############
FROM openjdk:8-jdk-alpine
USER root
COPY . .
RUN ./mvnw clean package
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/user_service.jar"]


############ clean build & run #############
#FROM openjdk:8-jdk-alpine AS TEMP_BUILD_IMAGE
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY build.gradle settings.gradle gradlew $APP_HOME
#COPY gradle $APP_HOME/gradle
#RUN  ./gradlew build --chmod +x|| return 0
#COPY . .
#RUN  ./gradlew build --chmod +x
#
#FROM openjdk:8-jdk-alpine
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/Bill-0.0.1-SNAPSHOT.jar .
#EXPOSE 8080
#CMD ["java","-jar", "Bill-0.0.1-SNAPSHOT.jar"]