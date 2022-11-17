FROM openjdk:9
COPY target/springpractice-0.0.1-SNAPSHOT.jar springpractice-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/springpractice-0.0.1-SNAPSHOT.jar"]