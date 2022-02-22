ARG MAVEN_VERSION
ARG JDK_VERSION


FROM maven:${MAVEN_VERSION} as dependencies
WORKDIR /app
COPY . . 
RUN mvn clean install -DskipTests


FROM openjdk:${JDK_VERSION}
WORKDIR /app
ENTRYPOINT ["/entrypoint.sh"]
COPY .docker/entrypoint.sh /entrypoint.sh
COPY --from=dependencies /app/target/charpg-0.0.1-SNAPSHOT.jar ./charpg.jar