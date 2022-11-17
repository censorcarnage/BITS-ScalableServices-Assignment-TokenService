FROM maven:3.8.2-jdk-8

WORKDIR /tokenservice
COPY . .
RUN mvn clean install
EXPOSE 8088
CMD mvn spring-boot:run