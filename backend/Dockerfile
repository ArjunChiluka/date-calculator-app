# 1️⃣ Use Java 17 JDK image
FROM eclipse-temurin:17-jdk-jammy

# 2️⃣ Set working directory inside the container
WORKDIR /app

# 3️⃣ Copy all backend files into the container
COPY . .

# 4️⃣ Make Maven wrapper executable
RUN chmod +x mvnw

# 5️⃣ Build the Spring Boot project (skip tests for faster deploy)
RUN ./mvnw clean install -DskipTests

# 6️⃣ Expose default Spring Boot port
EXPOSE 8080

# 7️⃣ Run the Spring Boot app
CMD ["./mvnw", "spring-boot:run"]
