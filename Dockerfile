FROM openjdk:17-jdk-alpine
COPY target/spring-boot-jpa-postgresql-0.0.1-SNAPSHOT.jar spring-boot-jpa-postgresql.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-boot-jpa-postgresql.jar"]