FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/Producer-App-0.0.1-SNAPSHOT.jar producer.jar
ENTRYPOINT ["java","-jar","producer.jar"]