# Dieses Dockerfile ist nicht direkt nutzbar wegen dem copy befehl
FROM maven:3.6.2-jdk-11-openj9 as builder
WORKDIR /app
# Der Copybefehl kann hier so geschrieben werden da der Build context (im docker-compose file) auf das Stammverzeichnis zeigt.
COPY ./ ./
RUN mvn -e -B dependency:resolve
RUN mvn -e package

FROM openjdk:8-alpine
COPY --from=builder /app/target/graphql-0.0.1-SNAPSHOT.jar /
CMD ["java","-jar","/graphql-0.0.1-SNAPSHOT.jar"]