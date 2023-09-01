FROM jelastic/maven:3.8.6-openjdk-20.ea-b24

WORKDIR /app
COPY . .
RUN mvn install -DskipTests

CMD mvn clean spring-boot:run