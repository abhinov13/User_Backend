FROM maven:3.8.3-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests

FROM maven:3.8.1-openjdk-17-slim
COPY --from=build /target/user-0.0.1-SNAPSHOT.jar user.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","user.jar" ]