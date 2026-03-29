# 1️⃣ Use official Maven + JDK image
FROM maven:3.9.4-eclipse-temurin-17 AS build

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw mvnw
COPY .mvn .mvn
COPY pom.xml .

# 4️⃣ Make mvnw executable
RUN chmod +x mvnw

# 5️⃣ Copy source code
COPY src src

# 6️⃣ Build the project (skip tests for faster deploy)
RUN ./mvnw clean install -DskipTests

# 7️⃣ Use minimal JDK runtime for final image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# 8️⃣ Copy built JAR from builder
COPY --from=build /app/target/*.jar app.jar

# 9️⃣ Expose default Spring Boot port
EXPOSE 8080

# 🔟 Run the application
ENTRYPOINT ["java","-jar","app.jar"]
