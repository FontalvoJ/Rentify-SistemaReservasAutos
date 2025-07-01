FROM amazoncorretto:17-alpine-jdk
ARG JAR_FILE=target/demo-api-backend-0.0.1.jar
COPY ${JAR_FILE} app_rentify.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_rentify.jar"]