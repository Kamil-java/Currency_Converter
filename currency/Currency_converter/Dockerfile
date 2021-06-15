FROM maven AS build
COPY src ./Currency_converter/src
COPY pom.xml ./Currency_converter
RUN mvn -f ./Currency_converter/pom.xml clean package

FROM openjdk:11
COPY --from=build /Currency_converter/target/Currency_converter-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","Currency_converter-0.0.1-SNAPSHOT.jar"]