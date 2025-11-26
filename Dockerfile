FROM openjdk:17-slim

WORKDIR /app

COPY TodoApp.java /app

RUN javac TodoApp.java

CMD ["java", "TodoApp"]
