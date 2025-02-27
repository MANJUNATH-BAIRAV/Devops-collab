FROM openjdk:11
COPY target/devops-collab-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]