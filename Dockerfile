FROM openjdk:17
EXPOSE 9091
COPY target/wp-aud.jar wp-aud.jar
ENTRYPOINT ["java", "-jar", "wp-aud.jar"]