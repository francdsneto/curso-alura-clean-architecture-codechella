FROM maven:3.9.8-sapmachine-22 AS build
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:22-slim
COPY --from=build /app/target/codechella.jar ./app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar", "/app.jar"]