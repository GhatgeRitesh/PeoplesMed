#Stage 1 Building Application
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

#copy necessory files for caching dependencies

COPY pom.xml .
COPY src ./src

# Download dependecies and build application

RUN mvn clean package-DskipTests && cp target/*.jar app.jar

#Stage 2

FROM gcr.io/distroless/java17

WORKDIR /app

# copy only jar files from previous stage
COPY --from=builder /app/app.jar app.jar

#Run the jar file

ENTRYPOINT ["java","-jar","app.jar"]