
FROM openjdk:8-jdk-alpine
EXPOSE 9100
COPY /target/packsendme-businessrulesa-server-0.0.1-SNAPSHOT.jar packsendme-businessrulesa-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/packsendme-businessrulesa-server-0.0.1-SNAPSHOT.jar"]