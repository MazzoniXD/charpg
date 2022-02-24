FROM maven:3.8.4 as dependencies
WORKDIR /app
COPY . . 
RUN mvn clean install -DskipTests


FROM openjdk:17
WORKDIR /app
ENTRYPOINT ["/entrypoint.sh"]
COPY .docker/entrypoint.sh /entrypoint.sh
COPY --from=dependencies /app/target/charpg-0.0.1-SNAPSHOT.jar ./charpg.jar