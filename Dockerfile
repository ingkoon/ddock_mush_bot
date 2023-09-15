FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=build/libs/tarnished_bot-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} tarnished_bot.jar

ENTRYPOINT ["java", "-jar", "/tarnished_bot.jar"]