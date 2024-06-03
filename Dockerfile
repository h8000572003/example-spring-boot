# Build stage
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app
COPY . .
RUN ./mvnw package

# Run stage
FROM eclipse-temurin:17-jdk-alpine AS runner

WORKDIR /app
COPY --from=builder /app/target/*.war app.war

CMD ["java", "-jar", "app.war"]
