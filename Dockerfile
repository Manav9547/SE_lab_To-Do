FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY TodoApp.java /app

RUN javac TodoApp.java

CMD ["java", "TodoApp"]
