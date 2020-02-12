# You cannot use this dockerfile directly without the compose file because of the copy command
FROM maven:3.6.2-jdk-11-openj9 as builder
WORKDIR /app
# You can write this copy command here because the build context in the compose file is set to the base directory 
COPY ./pom.xml ./pom.xml
RUN mvn -e -B dependency:go-offline
COPY ./ ./
RUN mvn -e package

FROM openjdk:8-alpine
COPY --from=builder /app/target/graphql-0.0.1-SNAPSHOT.jar /
CMD sleep 8;java -jar /graphql-0.0.1-SNAPSHOT.jar