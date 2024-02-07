# syntax=docker/dockerfile:1

FROM docker.io/library/eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY app/.mvn/ .mvn
COPY app/mvnw app/pom.xml ./
RUN ./mvnw dependency:resolve

COPY app/src ./src

# Set label to indicate the commit hash
LABEL commit_hash=${COMMIT_HASH}

CMD ["./mvnw", "spring-boot:run"]
