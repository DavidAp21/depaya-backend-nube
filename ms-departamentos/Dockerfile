FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY . .
RUN chmod +x mvnw
ENV JAVA_TOOL_OPTIONS="-Xmx256m"
EXPOSE 8080
CMD ["./mvnw", "spring-boot:run"]