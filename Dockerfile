# ---- Build Stage ----
FROM maven:3.9.8-eclipse-temurin-8 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# ---- Run Stage ----
FROM eclipse-temurin:8-jdk
WORKDIR /app
# Copy the jar built in the previous stage:
COPY --from=build /app/target/*.jar app.jar
# Expose the default Spring Boot port
# EXPOSE 8080
# Start the application
ENTRYPOINT ["java","-jar","app.jar"]
