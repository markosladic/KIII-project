FROM openjdk:17
EXPOSE 9091
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} wp-aud.jar
ENTRYPOINT ["java", "-jar", "wp-aud.jar"]