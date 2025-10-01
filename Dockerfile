
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn .mvn

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests


FROM amazoncorretto:17-jre-alpine

WORKDIR /app

EXPOSE 8080

COPY --from=build /target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]