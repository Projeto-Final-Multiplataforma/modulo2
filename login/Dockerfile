FROM amazoncorretto:17-alpine3.15
LABEL MANTAINER="FATEC"

WORKDIR /app

EXPOSE 8081

COPY springframework/target/springframework-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
