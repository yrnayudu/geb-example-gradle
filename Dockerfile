FROM openjdk:8-jdk

WORKDIR '/workspace'

ENV GRADLE_USER_HOME=/workspace/.gradle

#commands
CMD ["./gradlew", "clean", "test"]