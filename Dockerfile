FROM openjdk:18
WORKDIR /app
COPY /target/spring-boot-docker.war ./
CMD ["java", "-jar","spring-boot-docker.war"]