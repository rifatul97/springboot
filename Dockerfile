#
# Build stage
#
FROM maven:3.8.1-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17.0.1-jdk
COPY --from=build /target/springboot-0.0.1-SNAPSHOT.jar springboot.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot.jar"]