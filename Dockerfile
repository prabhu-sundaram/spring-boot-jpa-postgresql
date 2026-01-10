FROM eclipse-temurin:21-jre-alpine
#COPY target/spring-boot-jpa-postgresql-0.0.1-SNAPSHOT.jar spring-boot-jpa-postgresql.jar
COPY build/libs/spring-boot-jpa-postgresql-0.0.1-SNAPSHOT.jar spring-boot-jpa-postgresql.jar
EXPOSE 7080
ENTRYPOINT ["java","-jar","spring-boot-jpa-postgresql.jar"]