FROM openjdk:11-jdk-slim
EXPOSE 5460
ADD target/spring-rest.jar spring-rest.jar
ENTRYPOINT ["java","-jar","/spring-rest.jar"]