# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /myapp/src
COPY pom.xml /myapp
COPY smart-home-1.js /myapp
WORKDIR /myapp
#RUN mvn -f /myapp/pom.xml clean package
RUN mvn clean package
#WORKDIR /myapp/target
RUN mvn exec:java -Dexec.mainClass=ru.sbt.mipt.oop.Main

# Package stage
FROM openjdk:11-jre-slim
COPY --from=build /myapp/target/smart-home-1.0-SNAPSHOT.jar /myapp/target/smart-home-1.0-SNAPSHOT.jar
#EXPOSE 8080
WORKDIR /myapp/target
#ENTRYPOINT ["java","-jar","smart-home-1.0-SNAPSHOT.jar"]
ENTRYPOINT ["java" "-cp" "smart-home-1.0-SNAPSHOT.jar ru.sbt.mipt.oop.Main"]
##RUN mvn exec:java -Dexec.mainClass=ru.sbt.mipt.oop.Main
#CMD ["java" "Main"]