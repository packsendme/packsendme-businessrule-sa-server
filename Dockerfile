
FROM openjdk:8-jdk-alpine
EXPOSE 9100
COPY /target/packsendme-businessrule-server-0.0.1-SNAPSHOT.jar packsendme-businessrule-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/packsendme-businessrule-server-0.0.1-SNAPSHOT.jar"]