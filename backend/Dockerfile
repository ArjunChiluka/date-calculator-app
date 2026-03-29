# 1️⃣ Use official Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# 2️⃣ Set working directory
WORKDIR /app

# 3️⃣ Copy all backend files
COPY backend/ ./

# 4️⃣ Make mvnw executable
RUN chmod +x mvnw

# 5️⃣ Build the Spring Boot project (skip tests for faster deploy)
RUN ./mvnw clean install -DskipTests

# 6️⃣ Expose Spring Boot default port
EXPOSE 8080

# 7️⃣ Run the Spring Boot application
CMD ["./mvnw", "spring-boot:run"]
