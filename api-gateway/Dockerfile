FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
ENV PORT=8080
EXPOSE 8080
CMD sh -c 'java -Xmx256m -jar target/*.jar'