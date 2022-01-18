FROM openjdk:11.0.13-jdk-bullseye as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/extracted
RUN java -Djarmode=layertools -jar ./target/*.jar extract --destination ./target/extracted

FROM openjdk:11-jre-bullseye
EXPOSE 8080
ARG EXTRACTED=/workspace/app/target/extracted
COPY --from=build ${EXTRACTED}/dependencies ./
RUN true
COPY --from=build ${EXTRACTED}/spring-boot-loader/ ./
RUN true
COPY --from=build ${EXTRACTED}/snapshot-dependencies/ ./
RUN true
COPY --from=build ${EXTRACTED}/application/ ./

ENTRYPOINT ["java","-Dspring.profiles.active=test","org.springframework.boot.loader.JarLauncher"]