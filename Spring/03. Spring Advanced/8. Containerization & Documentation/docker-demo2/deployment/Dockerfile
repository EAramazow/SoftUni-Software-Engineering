FROM openjdk:17-jdk

VOLUME /tmp
COPY build/libs/docker-demo2.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Xms256m -Xmx512m", "-jar","/app.jar"]