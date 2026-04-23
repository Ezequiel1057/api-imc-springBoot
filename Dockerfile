# Adicione o "AS build" aqui para dar nome à primeira fase
FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

# O caminho corrigido para buscar o jar de dentro da pasta target da fase build
COPY --from=build /target/imc-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
