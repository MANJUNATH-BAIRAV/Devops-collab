FROM maven:3.8.6-openjdk-11 AS build
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean package

FROM openjdk:11
COPY --from=build /usr/src/app/target/devops-collab-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
