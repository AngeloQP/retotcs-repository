FROM openjdk:17
COPY target/demo-0.0.1-SNAPSHOT.jar retoTecnicoApp.jar
ENTRYPOINT ["java", "-jar", "/retoTecnicoApp.jar"]
