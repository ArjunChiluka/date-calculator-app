# Build stage
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY backend/ ./
RUN chmod +x mvnw && ./mvnw clean install -DskipTests

# Run stage
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
