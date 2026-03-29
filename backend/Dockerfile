# 1️⃣ Use an official Java 17 JDK image
FROM eclipse-temurin:17-jdk-alpine

# 2️⃣ Set working directory
WORKDIR /app

# 3️⃣ Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# 4️⃣ Give execute permission to mvnw
RUN chmod +x mvnw

# 5️⃣ Build the project (skip tests for faster build)
RUN ./mvnw clean install -DskipTests

# 6️⃣ Expose default Spring Boot port
EXPOSE 8080

# 7️⃣ Start the Spring Boot app
CMD ["./mvnw", "spring-boot:run"]
