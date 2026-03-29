# Use Java 21 since Spring Boot 4 requires it
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy backend files
COPY backend/ ./

# Make mvnw executable
RUN chmod +x mvnw

# Build Spring Boot app (skip tests)
RUN ./mvnw clean install -DskipTests

# Expose default Spring Boot port
EXPOSE 8080

# Start the app
CMD ["./mvnw", "spring-boot:run"]
